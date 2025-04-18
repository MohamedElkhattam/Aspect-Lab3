package com.Lab3.demo.service;

import com.Lab3.demo.dao.UserDao;
import com.Lab3.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserDao userdao;

    @Autowired
    public UserService(UserDao userdao) {
        this.userdao = userdao;
    }

    public List<User> getAllUsers() {
        return userdao.findAll();
    }

    public User getUser(Long id) {
        return userdao.findById(id).orElse(null);
    }

    public User createUser(User user) {
        return userdao.save(user);
    }

    public User updateUser(Long id, User updatedUser) {
        User user = getUser(id);
        if (user != null) {
            user.setName(updatedUser.getName());
            return userdao.save(user);
        }
        return null;
    }

    public void deleteUser(Long id) {
        userdao.deleteById(id);
    }
}
