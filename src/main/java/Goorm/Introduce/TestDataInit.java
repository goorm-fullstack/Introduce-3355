package Goorm.Introduce;

import Goorm.Introduce.Domain.Board.Board;
import Goorm.Introduce.Domain.Board.BoardRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TestDataInit {
    private final BoardRepository boardRepository;

    @PostConstruct
    public void init() {
        Board board1 = new Board();
        board1.setName("test1");
        board1.setLang("1");
        board1.setComments("1");
        board1.setGithub("1");
        board1.setFavorite("1");
        board1.setRole("1");

        Board board2 = new Board();
        board2.setName("test2");
        board2.setLang("2");
        board2.setComments("2");
        board2.setGithub("2");
        board2.setFavorite("2");
        board2.setRole("2");

        Board board3 = new Board();
        board3.setName("test3");
        board3.setLang("3");
        board3.setComments("3");
        board3.setGithub("3");
        board3.setFavorite("3");
        board3.setRole("3");

        Board board4 = new Board();
        board4.setName("test4");
        board4.setLang("4");
        board4.setComments("4");
        board4.setGithub("4");
        board4.setFavorite("4");
        board4.setRole("4");

        boardRepository.save(board1);
        boardRepository.save(board2);
        boardRepository.save(board3);
        boardRepository.save(board4);
    }
}
