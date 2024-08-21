package com.gwsc.springsecurityjwt.dao;

/*
 * @author: supul_g on 03/02/2021
 */


import com.gwsc.springsecurityjwt.mapping.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserDAO extends JpaRepository<User,Long> {

    User findByUsernameAndStatusCodeNot(String userName,String statusCode);

    User findByUsernameAndStatusCode(String username,String statusCode);

    List<User> findByStatusCode(String statusCode);
}
