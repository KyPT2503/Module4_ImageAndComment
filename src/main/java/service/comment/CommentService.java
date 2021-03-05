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
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(comment);
        transaction.commit();
        return true;
    }

    @Override
    public int addAndGetId(Comment comment) {
        return 0;
    }

    @Override
    public boolean update(int id, Comment comment) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("update Comment set lever=:lever,author=:author,content=:content,likeCount=:likeCount where id=:id");
        query.setParameter("lever", comment.getLever());
        query.setParameter("author", comment.getAuthor());
        query.setParameter("content", comment.getContent());
        query.setParameter("likeCount", comment.getLikeCount());
        query.setParameter("id", id);
        query.executeUpdate();
        transaction.commit();
        return false;
    }

    @Override
    public Comment getById(int id) {
        Query query = sessionFactory.openSession().createQuery("select c from Comment as c where c.id=:id");
        query.setParameter("id", id);
        List result = query.getResultList();
        if (result.size() > 0) {
            return (Comment) result.get(0);
        }
        return null;
    }

    @Override
    public List<Comment> getByImageId(int imageId) {
        Query<Comment> query = sessionFactory.openSession().createQuery("select c from Comment as c where c.imageId=:imageId");
        query.setParameter("imageId", imageId);
        return query.getResultList();
    }
}
