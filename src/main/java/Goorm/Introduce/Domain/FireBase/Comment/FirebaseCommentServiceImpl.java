package Goorm.Introduce.Domain.FireBase.Comment;

import Goorm.Introduce.Domain.Board.Board;
import Goorm.Introduce.Domain.Comment.Comment;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * 파이어베이스 방명록 기능 구현부
 */
@Slf4j
@Service
public class FirebaseCommentServiceImpl implements FirebaseCommentService {
    // 생성한 방명록을 DB에 저장
    @Override
    public void insertComment(Comment comment) {
        Date date = new Date();
        Firestore firestore = FirestoreClient.getFirestore();
        String uid = firestore.collection("comment").document().getId();
        comment.setId(uid);
        comment.setDate(date.toString());
        ApiFuture<WriteResult> apiFuture = firestore.collection("comment").document(uid).set(comment);
    }

    // 방명록의 id를 사용해서 DB에서 찾음
    @Override
    public Comment getComment(String id) throws ExecutionException, InterruptedException {
        Firestore firestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = firestore.collection("comment").document(id);
        ApiFuture<DocumentSnapshot> apiFuture = documentReference.get();
        DocumentSnapshot documentSnapshot = apiFuture.get();

        Comment comment = null;
        if(documentSnapshot.exists()) {
            comment = documentSnapshot.toObject(Comment.class);
            return comment;
        } else {
            return null;
        }
    }

    /**
     *
     * @return : 등록된 모든 방명록을 반환함
     */
    @Override
    public List<Comment> findAllComment() throws ExecutionException, InterruptedException {
        List<Comment> commentList = new ArrayList<>();
        Firestore firestore = FirestoreClient.getFirestore();
        ApiFuture<QuerySnapshot> apiFuture = firestore.collection("comment").get();
        List<QueryDocumentSnapshot> documentSnapshots = apiFuture.get().getDocuments();
        for(QueryDocumentSnapshot snapshot : documentSnapshots) {
            commentList.add(snapshot.toObject(Comment.class));
        }
        return commentList;
    }

    // 방명록을 업데이트하는 경우에 사용
    @Override
    public void updateComment(Comment comment) {
        Date date = new Date();
        comment.setDate(date.toString());
        Firestore firestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> apiFuture = firestore.collection("comment").document(comment.getId())
                .set(comment);
    }

    // 방명록을 제거하는 함수
    @Override
    public void deleteComment(String id) {
        Firestore firestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> apiFuture = firestore.collection("comment")
                .document(id).delete();
    }
}
