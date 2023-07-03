package Goorm.Introduce.Domain.FireBase.Member;

import Goorm.Introduce.Domain.Member.Member;
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
public class FirebaseMemberServiceImpl implements FirebaseMemberService {
    // 입력받은 게시글 데이터를 DB에 저장
    @Override
    public void insertMember(Member member) {
        Firestore firestore = FirestoreClient.getFirestore();
        String uid = firestore.collection("member").document().getId();
        member.setId(uid);
        ApiFuture<WriteResult> apiFuture = firestore.collection("member").document(uid).set(member);
    }

    // 게시글의 id를 사용해서 DB에서 게시글을 가져오는 기능
    @Override
    public Member getMember(String id) throws ExecutionException, InterruptedException {
        Firestore firestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = firestore.collection("member").document(id);
        ApiFuture<DocumentSnapshot> apiFuture = documentReference.get();
        DocumentSnapshot documentSnapshot = apiFuture.get();

        Member member = null;
        if(documentSnapshot.exists()) {
            member = documentSnapshot.toObject(Member.class);
            return member;
        } else {
            return null;
        }
    }

    /**
     * @return : 모든 게시글 리스트를 반환
     */
    @Override
    public List<Member> getAllMember() throws ExecutionException, InterruptedException {
        List<Member> MemberList = new ArrayList<>();
        Firestore firestore = FirestoreClient.getFirestore();
        ApiFuture<QuerySnapshot> apiFuture = firestore.collection("member").get();
        List<QueryDocumentSnapshot> documentSnapshots = apiFuture.get().getDocuments();
        for(QueryDocumentSnapshot snapshot : documentSnapshots) {
            MemberList.add(snapshot.toObject(Member.class));
        }
        return MemberList;
    }

    // 게시글을 업데이트하는 기능
    @Override
    public void updateMember(Member member) throws Exception {
        Firestore firestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> apiFuture = firestore.collection("member").document(member.getId())
                .set(member);
    }

    // 게시글을 삭제하는 기능
    @Override
    public String deleteMember(String id) {
        Firestore firestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> apiFuture = firestore.collection("member")
                .document(id).delete();
        return "id : " + id + "delete";
    }
}