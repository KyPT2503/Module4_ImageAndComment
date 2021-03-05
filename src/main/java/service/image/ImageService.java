package service.image;

import model.Image;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class ImageService implements IImageService {
    @Autowired
    private EntityManager entityManager;
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Image> getAll() {
        Query query = sessionFactory.openSession().createQuery("select i from Image as i");
        return query.getResultList();
    }

    @Override
    public boolean remove(int id) {
        return false;
    }

    @Override
    public boolean add(Image image) {
        return false;
    }

    @Override
    public int addAndGetId(Image image) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(image);
        transaction.commit();
        session.close();

        System.out.println("Saved image, ID of new row(image): " + image.getId());
        return image.getId();
    }

    @Override
    public boolean update(int id, Image image) {
        return false;
    }

    @Override
    public Image getById(int id) {
        Query query = sessionFactory.openSession().createQuery("select i from Image as i where i.id=:id");
        query.setParameter("id", id);
        List result = query.getResultList();
        if (result.size() > 0) {
            return (Image) result.get(0);
        }
        return null;
    }
}
