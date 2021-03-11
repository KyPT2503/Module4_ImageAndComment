package controller;

import model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.comment.ICommentService;

@Controller
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private ICommentService commentService;

    @PostMapping("/create")
    public ModelAndView create(@ModelAttribute("comment") Comment comment) throws Exception {
        String badWord = "fuck";
        if (comment.getContent().contains(badWord)) {
            throw new Exception();
        }
        commentService.add(comment);
        return new ModelAndView("redirect:/image/" + comment.getImageId());
    }

    @GetMapping("/like/{id}")
    public ModelAndView like(@PathVariable int id) {
        Comment newComment = commentService.getById(id);
        newComment.setLikeCount(newComment.getLikeCount() + 1);
        commentService.update(id, newComment);
        return new ModelAndView("redirect:/image/" + commentService.getById(id).getImageId());
    }
}
