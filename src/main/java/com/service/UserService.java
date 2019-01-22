package com.service;

import com.bean.User;
import org.springframework.stereotype.Repository;

/**
 * Created by ${邹} on 2019/1/11.
 * 描述：
 */
@Repository
public interface UserService {
    long register(User user);
    User login(String username);
}
