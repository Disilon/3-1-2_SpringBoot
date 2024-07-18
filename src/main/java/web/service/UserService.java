package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    void save(User user);

    void update(User user);

    void delete(Long id) throws Exception;

    User findById(Long id);

    List<User> findAll();
}
