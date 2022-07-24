package root.service;

import org.springframework.stereotype.Service;
import root.dto.AddCommentDto;
import root.dto.ResponseMapDto;

@Service
public interface CommentService {

    ResponseMapDto getAll(long id);

    void add(AddCommentDto addCommentDto);
}
