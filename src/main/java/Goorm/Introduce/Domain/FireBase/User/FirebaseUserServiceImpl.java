package Goorm.Introduce.Domain.FireBase.User;

import Goorm.Introduce.Domain.Board.Board;
import Goorm.Introduce.Domain.User.User;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class FirebaseUserServiceImpl implements FirebaseUsereService {
    @Override
    public void insertUser(User user) {
        Firestore firestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> apiFuture = firestore.collection("user").document(String.valueOf(user.getId())).set(user);
    }

    @Override
    public User getUser(int id) throws ExecutionException, InterruptedException {
        Firestore firestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = firestore.collection("user").document(String.valueOf(id));
        ApiFuture<DocumentSnapshot> apiFuture = documentReference.get();
        DocumentSnapshot documentSnapshot = apiFuture.get();

        User user = null;
        if(documentSnapshot.exists()) {
            user = documentSnapshot.toObject(User.class);
            return user;
        } else {
            return null;
        }
    }
}
