package com.gwsc.springsecurityjwt.service.impl;


import com.gwsc.springsecurityjwt.dto.UserRoleDTO;
import com.gwsc.springsecurityjwt.service.UserRoleService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
/*
 * @author: supul_g on 03/02/2021

 */


@Service
@Log4j2
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserRoleServiceImpl implements UserRoleService {

    @Override
    public Object getReferenceData(String username) {
        return null;
    }

    @Override
    public Object getUserRoles(Map<String, Object> map, Boolean full, Boolean dataTable, Integer draw) {
        return null;
    }

    @Override
    public Object getUserRoleByCode(String code, Boolean full) {
        return null;
    }

    @Override
    public Object saveUserRole(UserRoleDTO userRoleDTO, String username, String ipAddress, Date systemDate) {
        return null;
    }

    @Override
    public Object updateUserRole(String code, UserRoleDTO userRoleDTO, String username, String ipAddress, Date systemDate) {
        return null;
    }

    @Override
    public Object deleteUserRole(String code, String remark, String username, String ipAddress, Date systemDate) {
        return null;
    }
}
