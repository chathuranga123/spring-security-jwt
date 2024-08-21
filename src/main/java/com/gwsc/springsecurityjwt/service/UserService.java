package com.gwsc.springsecurityjwt.service;

public interface UserService {

    Object getUsersByUsername(String username,Boolean full);

}
