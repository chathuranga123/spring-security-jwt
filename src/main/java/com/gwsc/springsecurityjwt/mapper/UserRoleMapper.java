package com.gwsc.springsecurityjwt.mapper;



import com.gwsc.springsecurityjwt.enums.StatusEnum;
import com.gwsc.springsecurityjwt.mapping.UserRole;
import org.modelmapper.ModelMapper;
import com.gwsc.springsecurityjwt.dto.UserRoleDTO;

/*
 * @author: supul_g on 03/02/2021
 */
public class UserRoleMapper {

    public static UserRoleDTO entityToDTO(UserRole userRole) {
        UserRoleDTO userRoleDTO = new ModelMapper().map(userRole, UserRoleDTO.class);
        userRoleDTO.setStatusDescription(StatusEnum.getEnum(userRole.getStatusCode()).getDescription());
        userRoleDTO.setOldRemarks(userRole.getRemark());
        userRoleDTO.setRemark(null);
        return userRoleDTO;
    }

    public static void dtoToEntity(UserRole userRole, UserRoleDTO userRoleDTO) {
        userRole.setDescription(userRoleDTO.getDescription().trim());
        userRole.setRemark(userRoleDTO.getRemark());
        userRole.setStatusCode(userRoleDTO.getStatusCode());
    }

    public static UserRoleDTO populate(UserRoleDTO userRoleDTO) {
        userRoleDTO.setStatusDescription(StatusEnum.getEnum(userRoleDTO.getStatusCode()).getDescription());
        return userRoleDTO;
    }

}
