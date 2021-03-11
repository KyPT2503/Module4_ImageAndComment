package aspect;

import model.Comment;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

import java.time.LocalDate;

@Aspect
public class Logger {
    @AfterThrowing(pointcut = "execution(public * controller.CommentController.create(..)) && args(comment)")
    public void printBadWord(Comment comment) {
        System.out.println("Bad word .");
        System.out.println("Author: "+comment.getAuthor());
        System.out.println("Content: "+comment.getContent());
        System.out.println("Time: "+ LocalDate.now());
    }
}
