package com.cosmetique.auth.service;

import com.cosmetique.auth.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
