package Goorm.Introduce.Domain.FireBase.Board;

import Goorm.Introduce.Domain.Board.Board;

import java.util.concurrent.ExecutionException;

public interface FirebaseBoardService {
    public void insertBoard(Board board);
    public Board getBoard(String id) throws ExecutionException, InterruptedException;
    public void updateBoard(Board board) throws Exception;
    public void deleteBoard(String id);
}
