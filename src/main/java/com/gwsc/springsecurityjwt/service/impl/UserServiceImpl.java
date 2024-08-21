package com.gwsc.springsecurityjwt.service.impl;

import com.gwsc.springsecurityjwt.dao.UserDAO;
import com.gwsc.springsecurityjwt.dto.UserDTO;
import com.gwsc.springsecurityjwt.enums.StatusEnum;
import com.gwsc.springsecurityjwt.exceptions.ObjectNotFoundException;
import com.gwsc.springsecurityjwt.mapper.UserMapper;
import com.gwsc.springsecurityjwt.mapping.User;
import com.gwsc.springsecurityjwt.service.UserService;
import com.gwsc.springsecurityjwt.utility.MessageConstant;
import com.gwsc.springsecurityjwt.utility.MessageResource;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Log4j2
//@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserServiceImpl implements UserService {

    private UserDAO userDAO;

    private MessageResource messageResource;
    @Autowired
    public UserServiceImpl(UserDAO userDAO,MessageResource messageResource){
        this.userDAO = userDAO;
        this.messageResource = messageResource;
    }


    @Override
    public Object getUsersByUsername(String username, Boolean full) {
        try {
            UserDTO userDTO;
            User user = Optional.ofNullable(userDAO.findByUsernameAndStatusCodeNot(username, StatusEnum.DELETE.getCode()))
                    .orElseThrow(() -> new ObjectNotFoundException(messageResource.getMessage(MessageConstant.USER_NOT_FOUND, new Object[]{username})));
            if (!Optional.ofNullable(full).orElse(false)) {
                userDTO = UserMapper.entityToDTO(user, false);
            } else
                userDTO = UserMapper.entityToDTO(user, full);
            return userDTO;

        }catch (ObjectNotFoundException ex) {
            //log.error("Exception  :  ", ex);
            throw ex;
        } catch (Exception ex) {
           // log.error("Exception  :  ", ex);
            throw ex;
        }
    }
}
