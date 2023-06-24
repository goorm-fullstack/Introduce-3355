package Goorm.Introduce.Domain.FireBase.Board;

import Goorm.Introduce.Domain.Board.Board;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class FirebaseBoardServiceImpl implements FirebaseBoardService {
    @Override
    public void insertBoard(Board board) {
        Firestore firestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> apiFuture = firestore.collection("board").document(String.valueOf(board.getId())).set(board);
    }

    @Override
    public Board getBoard(int id) throws ExecutionException, InterruptedException {
        Firestore firestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = firestore.collection("board").document(String.valueOf(id));
        ApiFuture<DocumentSnapshot> apiFuture = documentReference.get();
        DocumentSnapshot documentSnapshot = apiFuture.get();

        Board board = null;
        if(documentSnapshot.exists()) {
            board = documentSnapshot.toObject(Board.class);
            return board;
        } else {
            return null;
        }
    }
}
