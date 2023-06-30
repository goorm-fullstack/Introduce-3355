package Goorm.Introduce.Web.member;

import Goorm.Introduce.Domain.FeedBack.FeedBack;
import Goorm.Introduce.Domain.FireBase.FeedBack.FirebaseFeedBackServiceImpl;
import Goorm.Introduce.Domain.FireBase.Member.FirebaseMemberService;
import Goorm.Introduce.Domain.Member.Member;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * /member/**로 들어오는 요청을 처리하는 컨트롤러
 */
@Controller
@Slf4j
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {
    private final FirebaseMemberService firebaseMemberService;
    private final FirebaseFeedBackServiceImpl firebaseFeedBackService;

    @GetMapping("/add")
    public String goModify(){
        return "pages/addMemberForm";
    }

    // 선택 멤버 페이지 이동
    @GetMapping("/{id}")
    public String introduceMember(@PathVariable String id, Model model) throws ExecutionException, InterruptedException{
        Member member = firebaseMemberService.getMember(id);
        List<FeedBack> feedBackList = firebaseFeedBackService.getByMemberId(id);
        model.addAttribute("member", member);
        model.addAttribute("boards", feedBackList);
        return "pages/member";
    }

    // 멤버 삭제
    @GetMapping("/delete")
    public String delete(@RequestParam String id) throws Exception {
        firebaseMemberService.deleteMember(id);
        return "redirect:/";
    }
}

