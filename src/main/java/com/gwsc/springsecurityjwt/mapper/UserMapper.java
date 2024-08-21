package com.gwsc.springsecurityjwt.mapper;

/*
 * @author: supul_g on 03/02/2021
 */



import com.gwsc.springsecurityjwt.dto.UserDTO;
import com.gwsc.springsecurityjwt.enums.StatusEnum;
import com.gwsc.springsecurityjwt.mapping.User;

import java.util.Date;

public class UserMapper {

    public static UserDTO entityToDTO(User user, boolean full) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setFullName(user.getFullName());
        userDTO.setEmail(user.getEmail());
        userDTO.setStatusCode(user.getStatusCode());
        userDTO.setStatusDescription(StatusEnum.getEnum(user.getStatusCode()).getDescription());
        userDTO.setLastLoggedDate(user.getLastLoggedDate());
        userDTO.setOldRemarks(userDTO.getRemark());
        userDTO.setRemark(null);
        if (full) {
            userDTO.setPassword(null);
            userDTO.setProfilePicture(user.getProfilePicture());
            userDTO.setAttempt(user.getAttempt());
            userDTO.setPasswordStatus(user.getPasswordStatus());
            userDTO.setPasswordExpireDate(user.getPasswordExpireDate());
            userDTO.setPasswordStatus(user.getPasswordStatus());
            userDTO.setCreatedUser(user.getCreatedUser());
            userDTO.setLastUpdatedUser(user.getLastUpdatedUser());
            userDTO.setCreatedTime(user.getCreatedTime());
            userDTO.setLastUpdatedTime(user.getLastUpdatedTime());
            userDTO.setOldRemarks(user.getRemark());

        }
        return userDTO;
    }

    public static User dtoToEntity(User user, UserDTO userDTO) {
        user.setUsername(userDTO.getUsername());
        user.setFullName(userDTO.getFullName());
        user.setEmail(userDTO.getEmail());
        user.setProfilePicture(userDTO.getProfilePicture());
        user.setStatusCode(userDTO.getStatusCode());
        user.setPasswordStatus(userDTO.getPasswordStatus());
        user.setRemark(userDTO.getRemark());
        return user;
    }

   /* public static UserDTO populate(UserDTO userDTO,UserRole userRole) {
        userDTO.setStatusDescription(StatusEnum.getEnum(userDTO.getStatusCode()).getDescription());
        userDTO.setUserRoleDescription(userRole.getDescription());
        userDTO.setPassword(null);
        return userDTO;
    }*/

    public static UserDTO populate(UserDTO userDTO) {
        userDTO.setStatusDescription(StatusEnum.getEnum(userDTO.getStatusCode()).getDescription());
        userDTO.setPassword(null);
        return userDTO;
    }

   /* public static User dtoToEntity(User user, Date passWordExpireDate, String password) {
        user.setPasswordExpireDate(passWordExpireDate);
        user.setPassword(password);
        user.setAttempt(0);
        user.setPasswordStatus(PasswordStatusEnum.ACTIVE.getCode());
        return user;
    }*/


}
