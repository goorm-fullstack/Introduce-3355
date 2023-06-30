package Goorm.Introduce.Domain.FireBase.Member;

import Goorm.Introduce.Domain.Member.Member;

import java.util.List;
import java.util.concurrent.ExecutionException;

public interface FirebaseMemberService {
    public void insertMember(Member member);
    public Member getMember(String id) throws ExecutionException, InterruptedException;
    public List<Member> getAllMember() throws ExecutionException, InterruptedException;
    public void updateMember(Member member) throws Exception;
    public void deleteMember(String id);
}
