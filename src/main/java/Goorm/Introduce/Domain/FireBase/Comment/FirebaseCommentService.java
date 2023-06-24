package Goorm.Introduce.Domain.FireBase.Comment;

import Goorm.Introduce.Domain.Board.Board;
import Goorm.Introduce.Domain.Comment.Comment;

import java.util.concurrent.ExecutionException;

public interface FirebaseCommentService {
    public void insertComment(Comment comment);
    public Comment getComment(int id) throws ExecutionException, InterruptedException;
}
