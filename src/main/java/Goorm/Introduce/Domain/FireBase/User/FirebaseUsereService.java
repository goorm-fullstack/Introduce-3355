package Goorm.Introduce.Domain.FireBase.User;

import Goorm.Introduce.Domain.User.User;

import java.util.concurrent.ExecutionException;

public interface FirebaseUsereService {
    public void insertUser(User user);
    public User getUser(String id) throws ExecutionException, InterruptedException;
    public void updateUser(User user);
    public void deleteUser(String id);
    public User login(String username, String password) throws ExecutionException, InterruptedException;
}
