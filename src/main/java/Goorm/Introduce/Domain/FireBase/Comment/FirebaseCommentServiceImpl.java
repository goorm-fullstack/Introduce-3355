package Goorm.Introduce.Domain.FireBase.Comment;

import Goorm.Introduce.Domain.Board.Board;
import Goorm.Introduce.Domain.Comment.Comment;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class FirebaseCommentServiceImpl implements FirebaseCommentService {
    @Override
    public void insertComment(Comment comment) {
        Firestore firestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> apiFuture = firestore.collection("comment").document(String.valueOf(comment.getId())).set(comment);
    }

    @Override
    public Comment getComment(int id) throws ExecutionException, InterruptedException {
        Firestore firestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = firestore.collection("comment").document(String.valueOf(id));
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
}
