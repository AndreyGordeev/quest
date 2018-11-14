package com.andreiy.gordeev.dao.login;

import com.andreiy.gordeev.model.User;

public interface UserDAO {

    User findByUsername(String username);
}
