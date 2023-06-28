package Goorm.Introduce.Domain.FireBase.Comment;

import Goorm.Introduce.Domain.Board.Board;
import Goorm.Introduce.Domain.Comment.Comment;

import java.util.List;
import java.util.concurrent.ExecutionException;

public interface FirebaseCommentService {
    public void insertComment(Comment comment);
    public Comment getComment(String id) throws ExecutionException, InterruptedException;
    public List<Comment> findAllComment() throws ExecutionException, InterruptedException;
    public void updateComment(Comment comment);
    public void deleteComment(String id);
}
