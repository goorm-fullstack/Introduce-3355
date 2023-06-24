package Goorm.Introduce.Domain.FireBase.User;

import Goorm.Introduce.Domain.Board.Board;
import Goorm.Introduce.Domain.User.User;

import java.util.concurrent.ExecutionException;

public interface FirebaseUsereService {
    public void insertUser(User user);
    public User getUser(int id) throws ExecutionException, InterruptedException;
}
