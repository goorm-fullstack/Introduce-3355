package Goorm.Introduce.Domain.FireBase.Board;

import Goorm.Introduce.Domain.Board.Board;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * 파이어베이스 게시글 기능 구현부
 */
@Service
public class FirebaseBoardServiceImpl implements FirebaseBoardService {
    // 입력받은 게시글 데이터를 DB에 저장
    @Override
    public void insertBoard(Board board) {
        Firestore firestore = FirestoreClient.getFirestore();
        String uid = firestore.collection("board").document().getId();
        board.setId(uid);
        ApiFuture<WriteResult> apiFuture = firestore.collection("board").document(uid).set(board);
    }

    // 게시글의 id를 사용해서 DB에서 게시글을 가져오는 기능
    @Override
    public Board getBoard(String id) throws ExecutionException, InterruptedException {
        Firestore firestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = firestore.collection("board").document(id);
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

    /**
     * 
     * @return : 모든 게시글 리스트를 반환
     */
    @Override
    public List<Board> getAllBoard() throws ExecutionException, InterruptedException {
        List<Board> boardList = new ArrayList<>();
        Firestore firestore = FirestoreClient.getFirestore();
        ApiFuture<QuerySnapshot> apiFuture = firestore.collection("board").get();
        List<QueryDocumentSnapshot> documentSnapshots = apiFuture.get().getDocuments();
        for(QueryDocumentSnapshot snapshot : documentSnapshots) {
            boardList.add(snapshot.toObject(Board.class));
        }
        return boardList;
    }

    // 게시글을 업데이트하는 기능
    @Override
    public void updateBoard(Board board) throws Exception {
        Firestore firestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> apiFuture = firestore.collection("board").document(board.getId())
                .set(board);
    }

    // 게시글을 삭제하는 기능
    @Override
    public void deleteBoard(String id) {
        Firestore firestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> apiFuture = firestore.collection("board")
                .document(id).delete();
    }
}
