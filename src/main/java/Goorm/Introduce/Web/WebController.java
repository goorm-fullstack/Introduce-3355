package Goorm.Introduce.Web;

import Goorm.Introduce.Domain.Comment.Comment;
import Goorm.Introduce.Domain.FireBase.Member.FirebaseMemberServiceImpl;
import Goorm.Introduce.Domain.FireBase.Comment.FirebaseCommentServiceImpl;
import Goorm.Introduce.Domain.FireBase.User.FirebaseUserServiceImpl;
import Goorm.Introduce.Domain.Member.Member;
import Goorm.Introduce.Domain.User.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@Controller
@RequiredArgsConstructor
public class WebController {
    private final FirebaseUserServiceImpl firebaseUserService;
    private final FirebaseCommentServiceImpl firebaseCommentService;
    private final FirebaseMemberServiceImpl firebaseMemberService;

    // 메인페이지
    // 로그인한 사용자와 아닌 사용자가 모두 온다.
    @GetMapping("/")
    public String Home(@SessionAttribute(name="loginAdmin", required = false) User user, Model model) throws ExecutionException, InterruptedException {
        List<Comment> commentList = firebaseCommentService.findAllComment();
        List<Member> memberList = firebaseMemberService.getAllMember();
        if(user ==null) {
            model.addAttribute("comments", commentList);
            model.addAttribute("members", memberList);
            return "index";
        }
        model.addAttribute("comments", commentList);
        model.addAttribute("members", memberList);
        model.addAttribute("user", user);
        return "index";
    }

    // 로그인 폼 접근
    @GetMapping("/login")
    public String loingForm() {
        return "pages/login";
    }

    // 로그인 처리 로직
    // 아이디와 비밀번호가 모두 맞다면 세션을 만들고 리다이렉트함
    @PostMapping("/login")
    public String login(@ModelAttribute User user, BindingResult bindingResult, HttpServletRequest request) throws ExecutionException, InterruptedException {
        if(bindingResult.hasErrors()){
            return "pages/login";
        }

        User loginUser = firebaseUserService.login(user.getUsername(), user.getPassword());

        if(loginUser == null) {
            bindingResult.reject("로그인 실패", "아이디 또는 비밀번확 맞지 않습니다");
            return "pages/login";
        }

        HttpSession session = request.getSession();

        session.setAttribute("loginAdmin", user);

        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if(session != null) {
            session.invalidate();
        }
        return "redirect:/";
    }
}
