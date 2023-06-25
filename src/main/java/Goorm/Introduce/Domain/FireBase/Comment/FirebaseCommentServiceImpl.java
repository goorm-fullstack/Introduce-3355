package Goorm.Introduce.Domain.FireBase.Comment;

import Goorm.Introduce.Domain.Board.Board;
import Goorm.Introduce.Domain.Comment.Comment;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * 파이어베이스 방명록 기능 구현부
 */
@Service
public class FirebaseCommentServiceImpl implements FirebaseCommentService {
    // 생성한 방명록을 DB에 저장
    @Override
    public void insertComment(Comment comment) {
        Firestore firestore = FirestoreClient.getFirestore();
        String uid = firestore.collection("comment").document().getId();
        comment.setId(uid);
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
     * @param boardId : 게시글의 아이디로 방명록 댓글을 찾음
     * @return : 찾아낸 게시글의 방명록 내용
     */
    @Override
    public List<Comment> findByBoardIdComment(String boardId) throws ExecutionException, InterruptedException {
        List<Comment> commentList = new ArrayList<>();
        Firestore firestore = FirestoreClient.getFirestore();
        ApiFuture<QuerySnapshot> apiFuture = firestore.collection("comment").get();
        List<QueryDocumentSnapshot> documentSnapshots = apiFuture.get().getDocuments();
        for(QueryDocumentSnapshot snapshot : documentSnapshots) {
            Comment comment = snapshot.toObject(Comment.class);
            if(comment.getBoardId().equals(boardId))
                commentList.add(comment);
        }
        return commentList;
    }

    // 방명록을 업데이트하는 경우에 사용
    @Override
    public void updateComment(Comment comment) {
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
