package Goorm.Introduce.Web.FeedBack;

import Goorm.Introduce.Domain.FeedBack.FeedBack;
import Goorm.Introduce.Domain.FireBase.FeedBack.FirebaseFeedBackServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.concurrent.ExecutionException;

/**
 * 피드백 기능 처리 컨트롤러
 * /board/**로 들어오는 요청 처리
 */
@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class FeedController {

    private final FirebaseFeedBackServiceImpl firebaseFeedBackService;

    @GetMapping("/{id}")
    public String getBoard(@PathVariable String id, Model model) throws ExecutionException, InterruptedException {
        FeedBack board = firebaseFeedBackService.getFeedBack(id);
        model.addAttribute("board", board);
        return "Board/Board";
    }

    @GetMapping("/add")
    public String addBoardForm() {
        return "Board/addBoard";

    }

    @PostMapping("/add")
    public String addBoard(@ModelAttribute FeedBack board, Model model) throws ExecutionException, InterruptedException {
        firebaseFeedBackService.insertFeedBack(board);
        model.addAttribute("boards", firebaseFeedBackService.findAllFeedBack());
        return "redirect:/member/"+board.getMemberId();
    }

    @PostMapping("/update")
    public String updateBoard(@ModelAttribute FeedBack board, Model model) throws Exception {
        firebaseFeedBackService.updateFeedBack(board);
        model.addAttribute("boards", firebaseFeedBackService.findAllFeedBack());
        return "redirect:/member/"+board.getMemberId();
    }

    @DeleteMapping("/delete")
    public String deleteBoard(@RequestBody Map<String, String> data, Model model) throws ExecutionException, InterruptedException {
        String id = data.get("id");
        FeedBack feedBack = firebaseFeedBackService.getFeedBack(id);
        firebaseFeedBackService.deleteFeedBack(id);
        model.addAttribute("boards", firebaseFeedBackService.findAllFeedBack());

        return "redirect:/member/"+feedBack.getMemberId();
    }
}
