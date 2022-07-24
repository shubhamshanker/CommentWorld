package root.service;

import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import root.dto.AddCommentDto;
import root.dto.ResponseMapDto;
import root.entity.Comment;
import root.repository.CommentRepository;
import root.service.CommentService;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;

    @Override
    public ResponseMapDto getAll(long parentId) {
        String rootId = this.getRootIdFromParentId(parentId);
        List<Comment> commentList = commentRepository.findAllByRootId(rootId);
        ResponseMapDto responseMapDto = ResponseMapDto.builder().commentList(commentList).build();
        return responseMapDto;
    }

    @Override
    @Transactional
    public void add(AddCommentDto addCommentDto) {
        Comment comment = new Comment();
        comment.setContent(addCommentDto.getContent());
        comment.setUserId(addCommentDto.getUserId());

    // if parentId null -> root
    if (Objects.nonNull(addCommentDto.getParentId())) {
      comment.setLevel(getCurrentLevelFromParentId(addCommentDto.getParentId()));
      comment.setParentId(addCommentDto.getParentId());
      comment.setRootId(getRootIdFromParentId(addCommentDto.getParentId()));
    } else {
      comment.setLevel(0);
      comment.setParentId(0L);
      comment.setRootId(RandomStringUtils.randomAlphanumeric(5));
        }
        commentRepository.save(comment);
    }


    private String getRootIdFromParentId(Long parentId)
    {
        return commentRepository.getById(parentId).getRootId();
    }

    private Integer getCurrentLevelFromParentId(Long parentId)
    {
        return commentRepository.getById(parentId).getLevel() + 1;
    }



}
