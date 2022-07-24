package root.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import root.service.CommentService;
import root.dto.ResponseMapDto;
import root.dto.AddCommentDto;
import root.dto.ResponseMapDto;
import root.service.CommentService;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class    CommentController {

    private final CommentService commentService;

    @GetMapping(value = "/com/{id}")
    public ResponseMapDto getCommentFromId(@PathVariable("id") long parentId)
    {
        return commentService.getAll(parentId);
    }

    @PostMapping(value = "/com")
    public String addComment(@RequestBody AddCommentDto addCommentDto)
    {
        try
        {
            commentService.add(addCommentDto);
            return "SUCCESS";
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        return "Error";
    }
}
