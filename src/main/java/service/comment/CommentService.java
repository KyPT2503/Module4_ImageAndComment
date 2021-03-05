package service.comment;

import model.Comment;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import java.util.List;

public class CommentService implements ICommentService {
    @Autowired
    private EntityManager entityManager;
    @Autowired
    private SessionFactory sessionFactory;

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
        Session session = sessionFactory.openSession();
        session.saveOrUpdate(comment);
        System.out.println("New comment added, if it does not actually added, then add Transaction.");
        return true;
    }

    @Override
    public int addAndGetId(Comment comment) {
        return 0;
    }

    @Override
    public boolean update(int id, Comment comment) {
        return false;
    }

    @Override
    public Comment getById(int id) {
        return null;
    }

    @Override
    public List<Comment> getByImageId(int imageId) {
        Query<Comment> query = sessionFactory.openSession().createQuery("select c from Comment as c where c.imageId=:imageId");
        return query.getResultList();
    }
}
