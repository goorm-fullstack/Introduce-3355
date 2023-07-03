package Goorm.Introduce.Web.member;

import Goorm.Introduce.Domain.FireBase.Member.FirebaseMemberServiceImpl;
import Goorm.Introduce.Domain.Member.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * /modify/**로 들어오는 요청을 처리하는 컨트롤러
 */
@Controller
@RequestMapping("/modify")
@RequiredArgsConstructor
public class ModifyController {

    private final FirebaseMemberServiceImpl firebaseMemberService;

    // 멤버 추가 기능
    @PostMapping("/create")
    public String createMember(Member member) throws Exception {
        firebaseMemberService.insertMember(member);
        return "redirect:/";
    }

    // 멤버 정보 수정시 기존 정보 불러오는 기능
    @GetMapping("/update")
    public String updateMember(@RequestParam String id, Model model) throws Exception {
        Member member = firebaseMemberService.getMember(id);
        model.addAttribute("member", member);
        return "pages/modify";
    }

    // 멤버 정보 수정 완료 후 수정된 내용 화면에 보여주는 기능
    @PostMapping("/updated")
    public String updated(@RequestParam String id, Member member, Model model) throws Exception {
        firebaseMemberService.updateMember(member);
        model.addAttribute("member", member);
        return "pages/member";
    }
}

