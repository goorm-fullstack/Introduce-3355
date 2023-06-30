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

@Controller
@RequestMapping("/modify")
@RequiredArgsConstructor
public class ModifyController {

    private final FirebaseMemberServiceImpl firebaseMemberService;

    @PostMapping("/create")
    public String createMember(Member member) throws Exception {
            firebaseMemberService.insertMember(member);
            return "redirect:/";
    }

    @GetMapping("/update")
    public String updateMember(@RequestParam String id, Model model) throws Exception {
        Member member = firebaseMemberService.getMember(id);
        model.addAttribute("member", member);
        return "pages/modify";
    }

    @PostMapping("/updated")
    public String updated(Member member) throws Exception {
        firebaseMemberService.updateMember(member);
        return "redirect:/";
    }
}
