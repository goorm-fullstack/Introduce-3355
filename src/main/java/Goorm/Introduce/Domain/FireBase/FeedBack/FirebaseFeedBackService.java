package Goorm.Introduce.Domain.FireBase.FeedBack;

import Goorm.Introduce.Domain.FeedBack.FeedBack;

import java.util.List;
import java.util.concurrent.ExecutionException;

public interface FirebaseFeedBackService {
    public void insertFeedBack(FeedBack feedBack);
    public FeedBack getFeedBack(String id) throws ExecutionException, InterruptedException;
    public List<FeedBack> findAllFeedBack() throws ExecutionException, InterruptedException;
    public List<FeedBack> getByMemberId(String memberId) throws ExecutionException, InterruptedException;
    public void updateFeedBack(FeedBack feedBack);
    public void deleteFeedBack(String id);
}
