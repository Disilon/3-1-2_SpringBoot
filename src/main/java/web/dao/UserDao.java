package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    void save(User user);

    void update(User user);

    void delete(Long id) throws Exception;

    User findById(Long id);

    List<User> findAll();
}
