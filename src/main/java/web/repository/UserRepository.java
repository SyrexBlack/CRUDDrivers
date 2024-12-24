package web.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import java.util.List;

@Repository
public class UserRepository {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void saveUser(User user) {
        em.persist(user);
    }

    public User getUserById(Long id) {
        return em.find(User.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<User> getAllUsers() {
        return em.createQuery("SELECT u FROM User u").getResultList();
    }

    @Transactional
    public void updateUser(User user) {
        em.merge(user);
    }

    @Transactional
    public void deleteUser(Long id) {
        User user = em.find(User.class, id);
        if (user != null) {
            em.remove(user);
        }
    }
}
