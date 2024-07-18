package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;
import java.util.logging.Logger;

@Repository
public class JpaUserDao implements UserDao {
    private static final Logger logger = Logger.getLogger(JpaUserDao.class.getName());

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    public void update(User user) {
        entityManager.merge(user);
    }

    @Override
    public void delete(Long id) throws Exception {
        User user = findById(id);
        if (user == null) {
            logger.warning("Trying to remove not existent user. User is null");
            throw new Exception("Trying to remove not existent user. User is null");
        }
        entityManager.remove(findById(id));
    }

    @Override
    public User findById(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public List<User> findAll() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }
}
