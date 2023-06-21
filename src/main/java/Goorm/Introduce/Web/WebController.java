package Goorm.Introduce.Web;

import Goorm.Introduce.Domain.Board.Board;
import Goorm.Introduce.Domain.Board.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class WebController {
    private final BoardRepository boardRepository;
    @GetMapping("/")
    public String Home() {
        return "main";
    }

    @GetMapping("/members/{id}")
    public String introduce(@PathVariable int id, Model model) {
        Board board = boardRepository.findById(id);
        model.addAttribute("board", board);
        return "Member/member";
    }
}
