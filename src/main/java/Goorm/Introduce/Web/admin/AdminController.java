package Goorm.Introduce.Web.admin;

import Goorm.Introduce.Domain.Board.Board;
import Goorm.Introduce.Domain.Board.BoardRepository;
import Goorm.Introduce.Domain.FireBase.Board.FirebaseBoardServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/*
* 어드민용 페이지 컨트롤러
* /admin/**로 들어오는 모든 응답을 처리
 */
@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {
    private final BoardRepository boardRepository;
    private final FirebaseBoardServiceImpl firebaseBoardService;
    @GetMapping
    public String main() {
        return "Admin/main";
    }

    @GetMapping("/addMember")
    public String addMemberForm() {
        return "Admin/addForm";
    }

    @PostMapping("/addMember")
    public String addMember(@ModelAttribute Board board) {
        firebaseBoardService.insertBoard(board);
        return "redirect:/admin";
    }

    @GetMapping("/updateMember")
    public String updateForm() {
        return "Admin/updateForm";
    }

    @PostMapping("/updateMember")
    public String updateMember() {
        return "";
    }

    @DeleteMapping("/delete")
    public void deleteMember() {

    }
}
