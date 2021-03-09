package service.image;

import model.Image;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ImageService implements IImageService {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Image> getAll() {
        return entityManager.createQuery("select i from Image as i").getResultList();
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
        entityManager.persist(image);
        return image.getId();
    }

    @Override
    public boolean update(int id, Image image) {
        return false;
    }

    @Override
    public Image getById(int id) {
        return entityManager.find(Image.class, id);
    }
}
