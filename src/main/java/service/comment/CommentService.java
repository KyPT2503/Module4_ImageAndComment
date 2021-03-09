package service.comment;

import model.Comment;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CommentService implements ICommentService {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Comment> getAll() {
        return null;
    }

    @Override
    public boolean remove(int id) {
        return false;
    }

    @Override
    public boolean add(Comment comment) {
        entityManager.persist(comment);
        return true;
    }

    @Override
    public int addAndGetId(Comment comment) {
        return 0;
    }

    @Override
    public boolean update(int id, Comment comment) {
        entityManager.merge(comment);
        return true;
    }

    @Override
    public Comment getById(int id) {
        return entityManager.find(Comment.class, id);
    }

    @Override
    public List<Comment> getByImageId(int imageId) {
        return entityManager.createQuery("select c from Comment as c where c.imageId=?1").setParameter(1, imageId).getResultList();
    }
}
