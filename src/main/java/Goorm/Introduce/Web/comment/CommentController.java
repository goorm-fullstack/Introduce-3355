package Goorm.Introduce.Web.comment;

import Goorm.Introduce.Domain.Comment.Comment;
import Goorm.Introduce.Domain.FireBase.Comment.FirebaseCommentServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Comment와 관련된 기능을 처리하는 컨트롤러
 * /comment/**로 들어오는 요청을 처리
 */
@Controller
@RequestMapping("/comment")
@RequiredArgsConstructor
public class CommentController {
    private final FirebaseCommentServiceImpl firebaseCommentService;

    @PostMapping
    public String addComment(@ModelAttribute Comment comment) {
        firebaseCommentService.insertComment(comment);
        return "redirect:/member/"+comment.getBoardId();
    }
}
