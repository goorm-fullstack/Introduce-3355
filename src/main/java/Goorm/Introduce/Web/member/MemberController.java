package Goorm.Introduce.Web.member;

import Goorm.Introduce.Domain.Board.Board;
import Goorm.Introduce.Domain.Board.BoardRepository;
import Goorm.Introduce.Domain.Comment.Comment;
import Goorm.Introduce.Domain.FireBase.Board.FirebaseBoardServiceImpl;
import Goorm.Introduce.Domain.FireBase.Comment.FirebaseCommentServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * /member/**로 들어오는 요청을 처리하는 컨트롤러
 */
@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {
    private final FirebaseBoardServiceImpl firebaseBoardService;

    @GetMapping("/{id}")
    public String introduce(@PathVariable String id, Model model) throws ExecutionException, InterruptedException {
        Board board = firebaseBoardService.getBoard(id);
        model.addAttribute("board", board);
        return "Member/member";
    }

    @ResponseBody
    @GetMapping("/add")
    public String addForm() {
        return "Member/member";
    }

    @GetMapping("/list")
    public String memberList(Model model) throws ExecutionException, InterruptedException {
        model.addAttribute("members", firebaseBoardService.getAllBoard());
        return "Member/memberList";
    }
}
