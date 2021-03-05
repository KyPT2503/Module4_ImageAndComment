package service.comment;

import model.Comment;
import service.IGeneralService;

import java.util.List;

public interface ICommentService extends IGeneralService<Comment> {
    List<Comment> getByImageId(int imageId);
}
