package com.gwsc.springsecurityjwt.service;



import com.gwsc.springsecurityjwt.dto.UserRoleDTO;

import java.util.Date;
import java.util.Map;

/*
 * @author: supul_g on 03/02/2021
 */
public interface UserRoleService {

    Object getReferenceData(String username);

    Object getUserRoles(Map<String, Object> map, Boolean full, Boolean dataTable, Integer draw);

    Object getUserRoleByCode(String code,Boolean full);

    Object saveUserRole(UserRoleDTO userRoleDTO, String username, String ipAddress, Date systemDate);

    Object updateUserRole(String code,UserRoleDTO userRoleDTO,String username,String ipAddress,Date systemDate);

    Object deleteUserRole(String code,String remark,String username,String ipAddress,Date systemDate);



}
