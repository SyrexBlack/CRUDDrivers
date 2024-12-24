package web.service;

import org.springframework.stereotype.Service;
import web.model.User;
import web.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    private final UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public List<User> findAll() {
        return repo.getAllUsers();
    }

    public User findById(Long id) {
        return repo.getUserById(id);
    }

    public void save(User user) {
        repo.saveUser(user);
    }

    public void update(User user) {
        repo.updateUser(user);
    }

    public void delete(Long id) {
        repo.deleteUser(id);
    }
}
