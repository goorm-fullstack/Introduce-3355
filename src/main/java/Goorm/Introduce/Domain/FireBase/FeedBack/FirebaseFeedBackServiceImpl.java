package Goorm.Introduce.Domain.FireBase.FeedBack;

import Goorm.Introduce.Domain.FeedBack.FeedBack;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * 파이어베이스 방명록 기능 구현부
 */
@Slf4j
@Service
public class FirebaseFeedBackServiceImpl implements FirebaseFeedBackService {
    // 생성한 방명록을 DB에 저장
    @Override
    public void insertFeedBack(FeedBack feedBack) {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd");
        String strDate = simpleDateFormat.format(date);

        Firestore firestore = FirestoreClient.getFirestore();
        String uid = firestore.collection("board").document().getId();
        String profile = "";

        switch (feedBack.getName()) {
            case "김경규": profile = "https://user-images.githubusercontent.com/121299334/247801974-24f71bb9-12bb-4b29-9e2b-73461af0635d.png"; break;
            case "문소희": profile = "https://github-production-user-asset-6210df.s3.amazonaws.com/121299334/247800096-24c6f23b-8952-4e02-9347-ba42f5b67bc8.png"; break;
            case "배진환": profile = "https://user-images.githubusercontent.com/121299334/248290954-c503b06b-188f-4041-abf8-4041093d80a0.png"; break;
            case "이정원": profile = "https://user-images.githubusercontent.com/121299334/247802501-275b401f-aa95-43a9-a41e-6f4482e8f3e4.png"; break;
            default: profile = "/assets/images/ico_profile.png";
        }

        feedBack.setId(uid);
        feedBack.setDate(strDate);
        feedBack.setProfile(profile);

        ApiFuture<WriteResult> apiFuture = firestore.collection("board").document(uid).set(feedBack);
    }

    // 방명록의 id를 사용해서 DB에서 찾음
    @Override
    public FeedBack getFeedBack(String id) throws ExecutionException, InterruptedException {
        Firestore firestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = firestore.collection("board").document(id);
        ApiFuture<DocumentSnapshot> apiFuture = documentReference.get();
        DocumentSnapshot documentSnapshot = apiFuture.get();

        FeedBack FeedBack = null;
        if(documentSnapshot.exists()) {
            FeedBack = documentSnapshot.toObject(FeedBack.class);
            return FeedBack;
        } else {
            return null;
        }
    }

    /**
     *
     * @return : 등록된 모든 방명록을 반환함
     */
    @Override
    public List<FeedBack> findAllFeedBack() throws ExecutionException, InterruptedException {
        List<FeedBack> FeedBackList = new ArrayList<>();
        Firestore firestore = FirestoreClient.getFirestore();
        ApiFuture<QuerySnapshot> apiFuture = firestore.collection("board").get();
        List<QueryDocumentSnapshot> documentSnapshots = apiFuture.get().getDocuments();
        for(QueryDocumentSnapshot snapshot : documentSnapshots) {
            FeedBackList.add(snapshot.toObject(FeedBack.class));
        }
        return FeedBackList;
    }

    /**
     *
     * @return
     */
    @Override
    public List<FeedBack> getByMemberId(String memberId) throws ExecutionException, InterruptedException {
        List<FeedBack> FeedBackList = new ArrayList<>();
        Firestore firestore = FirestoreClient.getFirestore();
        ApiFuture<QuerySnapshot> apiFuture = firestore.collection("board").get();
        List<QueryDocumentSnapshot> documentSnapshots = apiFuture.get().getDocuments();
        for(QueryDocumentSnapshot snapshot : documentSnapshots) {
            FeedBack feedBack = snapshot.toObject(FeedBack.class);
            if(feedBack.getMemberId().equals(memberId))
                FeedBackList.add(feedBack);
        }
        return FeedBackList;
    }

    // 방명록을 업데이트하는 경우에 사용
    @Override
    public void updateFeedBack(FeedBack FeedBack) {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd");
        String strDate = simpleDateFormat.format(date);
        FeedBack.setDate(strDate);
        Firestore firestore = FirestoreClient.getFirestore();
        String profile = "";
        switch (FeedBack.getName()) {
            case "김경규": profile = "https://user-images.githubusercontent.com/121299334/247801974-24f71bb9-12bb-4b29-9e2b-73461af0635d.png"; break;
            case "문소희": profile = "https://github-production-user-asset-6210df.s3.amazonaws.com/121299334/247800096-24c6f23b-8952-4e02-9347-ba42f5b67bc8.png"; break;
            case "배진환": profile = "https://user-images.githubusercontent.com/121299334/248290954-c503b06b-188f-4041-abf8-4041093d80a0.png"; break;
            case "이정원": profile = "https://user-images.githubusercontent.com/121299334/247802501-275b401f-aa95-43a9-a41e-6f4482e8f3e4.png"; break;
            default: profile = "/assets/images/ico_profile.png";
        }
        FeedBack.setProfile(profile);
        ApiFuture<WriteResult> apiFuture = firestore.collection("board").document(FeedBack.getId())
                .set(FeedBack);
    }

    // 방명록을 제거하는 함수
    @Override
    public void deleteFeedBack(String id) {
        Firestore firestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> apiFuture = firestore.collection("board")
                .document(id).delete();
    }
}
