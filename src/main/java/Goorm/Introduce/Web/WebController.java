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
}
