package root.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import root.entity.Comment;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Query("select c from Comment c where c.rootId = ?1")
    List<Comment> findAllByRootId(String rootId);

    @Query("select c from Comment c where c.rootId = ?1")
    List<Comment> findCommentsByRootId(String rootId);
}