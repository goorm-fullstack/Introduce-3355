package Goorm.Introduce.Web;

import Goorm.Introduce.Domain.Board.Board;
import Goorm.Introduce.Domain.Board.BoardRepository;
import Goorm.Introduce.Domain.User.User;
import Goorm.Introduce.Domain.User.UserService;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.firebase.cloud.FirestoreClient;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Controller
@RequiredArgsConstructor
public class WebController {
    private final BoardRepository boardRepository;
    private final UserService userService;

    // 메인페이지
    // 로그인한 사용자와 아닌 사용자가 모두 온다.
    @GetMapping("/")
    public String Home(@SessionAttribute(name="loginAdmin", required = false) User user, Model model) {
        if(user ==null)
            return "main";

        model.addAttribute("user", user);
        return "main";
    }

    @GetMapping("/members/{id}")
    public String introduce(@PathVariable int id, Model model) {
        Board board = boardRepository.findById(id);
        model.addAttribute("board", board);
        return "Member/member";
    }

    // 로그인 폼 접근
    @GetMapping("/login")
    public String loingForm() {
        return "Member/login";
    }

    // 로그인 처리 로직
    // 아이디와 비밀번호가 모두 맞다면 세션을 만들고 리다이렉트함
    @PostMapping("/login")
    public String login(@ModelAttribute User user, BindingResult bindingResult, HttpServletRequest request) {
        if(bindingResult.hasErrors()){
            return "Member/login";
        }

        User loginUser = userService.login(user.getUsername(), user.getPassword());
        System.out.println(loginUser.toString());

        if(loginUser == null) {
            bindingResult.reject("로그인 실패", "아이디 또는 비밀번확 맞지 않습니다");
            return "Member/login";
        }

        HttpSession session = request.getSession();

        session.setAttribute("loginAdmin", user);

        return "redirect:/";
    }

    //파이어베이스 연동 확인용 코드입니다.
    @ResponseBody
    @GetMapping("/firebase-test")
    public ResponseEntity<Object> firebaseWebTest() throws ExecutionException, InterruptedException {
        List<Test> list = firebaseTest();
        return ResponseEntity.ok().body(list);
    }
    private List<Test> firebaseTest() throws ExecutionException, InterruptedException {
        StringBuilder sb = new StringBuilder();
        List<Test> list = new ArrayList<>();
        Firestore db = FirestoreClient.getFirestore();
        ApiFuture<QuerySnapshot> future = db.collection("test").get();
        List<QueryDocumentSnapshot> documents = future.get().getDocuments();
        for(QueryDocumentSnapshot document : documents) {
            list.add(document.toObject(Test.class));
        }
        return list;
    }

    //파이어베이스 연동 확인용 코드
    @Data
    private static class Test{
        private String message;
    }
}
