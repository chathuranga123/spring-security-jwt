/*
package com.gwsc.springsecurityjwt.service.impl;

import com.epic.open_banking.user_service.dao.DualAuthenticationDAO;
import com.epic.open_banking.user_service.dao.TaskDAO;
import com.epic.open_banking.user_service.dao.UserRoleDAO;
import com.epic.open_banking.user_service.dao.UserUserRoleDAO;
import com.epic.open_banking.user_service.dao.custom.ListSlicingDAO;
import com.epic.open_banking.user_service.dto.*;
import com.epic.open_banking.user_service.enums.*;
import com.epic.open_banking.user_service.exceptions.CodeExistsException;
import com.epic.open_banking.user_service.exceptions.InvalidOperationException;
import com.epic.open_banking.user_service.exceptions.ObjectNotFoundException;
import com.epic.open_banking.user_service.exceptions.PendingRequestException;
import com.epic.open_banking.user_service.mapper.SectionMapper;
import com.epic.open_banking.user_service.mapper.UserRoleMapper;
import com.epic.open_banking.user_service.mapping.DualAuthenticationRecord;
import com.epic.open_banking.user_service.mapping.Task;
import com.epic.open_banking.user_service.mapping.UserRole;
import com.epic.open_banking.user_service.mapping.UserUserRole;
import com.epic.open_banking.user_service.service.PageAuthService;
import com.epic.open_banking.user_service.service.PageService;
import com.epic.open_banking.user_service.service.SystemAuditService;
import com.epic.open_banking.user_service.service.UserRoleService;
import com.epic.open_banking.user_service.utility.CommonMethod;
import com.epic.open_banking.user_service.utility.MessageConstant;
import com.epic.open_banking.user_service.utility.MessageResource;
import com.epic.open_banking.user_service.utility.PageVarList;
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

*/
/*
 * @author: supul_g on 03/02/2021
 *//*

@Service
@Log4j2
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserRoleServiceImpl implements UserRoleService {

    private UserRoleDAO userRoleDAO;
    private MessageResource messageResource;
    @Qualifier("userRoleListSlicingDAO")
    private ListSlicingDAO<UserRole> userRoleListSlicingDAO;
    private DualAuthenticationDAO dualAuthenticationDAO;
    private PageService pageService;
    private CommonMethod commonMethod;
    private TaskDAO taskDAO;
    private PageAuthService pageAuthService;
    private SystemAuditService systemAuditService;
    private UserUserRoleDAO userUserRoleDAO;


    @Override
    public Object getReferenceData(String username) {
        try {
            Map<String, Object> refData = new HashMap<>();
            PageAuthDTO pageAuthDTO=this.pageAuthService.getPageAuth(PageVarList.USER_ROLE_MGT_PAGE,username);
            if(pageAuthDTO.isDualAuth()) {
                List<SimpleBaseDTO> defaultDualAuthStatus = Stream.of(DefaultDualAuthStatusEnum.values())
                        .map(statusEnum -> {
                            return new SimpleBaseDTO(statusEnum.getCode(), statusEnum.getDescription());
                        })
                        .collect(Collectors.toList());
                refData.put("defaultDualAuthStatus", defaultDualAuthStatus);
            }
            List<SimpleBaseDTO> defaultStatus = Stream.of(DefaultStatusEnum.values())
                    .map(statusEnum -> {
                        return new SimpleBaseDTO(statusEnum.getCode(), statusEnum.getDescription());
                    })
                    .collect(Collectors.toList());
            refData.put("pageAuth", pageAuthDTO);
            refData.put("defaultStatus", defaultStatus);
            return refData;
        } catch (ObjectNotFoundException ex) {
            log.error("Exception  :  ", ex);
            throw ex;
        } catch (Exception ex) {
            log.error("Exception  :  ", ex);
            throw ex;
        }
    }


    @Override
    @Transactional
    public Object getUserRoles(Map<String, Object> map, Boolean full, Boolean dataTable, Integer draw) {
        try {
            List<Object> list = userRoleListSlicingDAO.findAllByParameters(map).orElse(Collections.emptyList())
                    .stream()
                    .map(userRole -> {
                        if (!Optional.ofNullable(full).orElse(false))
                            return new ModelMapper().map(userRole, SimpleBaseDTO.class);
                        else
                            return UserRoleMapper.entityToDTO(userRole);
                    })
                    .collect(Collectors.toList());
            if (!Optional.ofNullable(dataTable).orElse(false))
                return list;
            else {
                Long count = userRoleListSlicingDAO.rowCount(map);
                return new DataTableDTO<Object>(count, (long) list.size(), list, draw);
            }
        } catch (Exception ex) {
            log.error("Exception  :  ", ex);
            throw ex;
        }
    }

    @Override
    @Transactional
    public Object getUserRoleByCode(String code, Boolean full) {
        try {
            UserRole userRole = Optional.ofNullable(userRoleDAO.findByCodeAndStatusCodeNot(code, StatusEnum.DELETE.getCode()))
                    .orElseThrow(() -> new ObjectNotFoundException(messageResource.getMessage(MessageConstant.USER_ROLE_NOT_FOUND, new Object[]{code})));
            if (!Optional.ofNullable(full).orElse(false))
                return new ModelMapper().map(userRole, SimpleBaseDTO.class);
            else
                return UserRoleMapper.entityToDTO(userRole);
        } catch (ObjectNotFoundException ex) {
            log.error("Exception  :  ", ex);
            throw ex;
        } catch (Exception ex) {
            log.error("Exception  :  ", ex);
            throw ex;
        }
    }

    @Override
    @Transactional
    public Object saveUserRole(UserRoleDTO userRoleDTO, String username,String ipAddress,Date systemDate) {
        try {
            String remark=userRoleDTO.getRemark();;
            UserRole userRole = Optional.ofNullable(userRoleDAO.findByCodeAndStatusCodeNot(userRoleDTO.getCode(), StatusEnum.DELETE.getCode())).orElse(new UserRole());
            if (userRole.getId() != null)
                throw new CodeExistsException(messageResource.getMessage(MessageConstant.USER_ROLE_ALREADY_EXISTS, new Object[]{userRoleDTO.getCode()}));
            userRoleDTO.setRemark(this.commonMethod.getRemark(userRoleDTO.getRemark(), null, username, systemDate));
            if (pageService.checkDualAuthStatus(PageVarList.USER_ROLE_MGT_PAGE)) {
                DualAuthenticationRecord authenticationRecord = Optional.ofNullable(dualAuthenticationDAO.findByPageAndUniqueId1AndStatusCode(PageVarList.USER_ROLE_MGT_PAGE, userRoleDTO.getCode(), DualAuthStatusEnum.PENDING.getCode())).orElse(null);
                if (authenticationRecord != null)
                    throw new PendingRequestException(messageResource.getMessage(MessageConstant.USER_ROLE_APPROVAL_PENDING, new Object[]{userRoleDTO.getCode()}));
                Task task = Optional.ofNullable(taskDAO.findByCodeAndStatusCode(TaskEnum.ADD.getCode(), StatusEnum.ACTIVE.getCode()))
                        .orElseThrow(() -> new ObjectNotFoundException(messageResource.getMessage(MessageConstant.TASK_NOT_FOUND, new Object[]{TaskEnum.ADD.getCode()})));
                authenticationRecord = commonMethod.createAuthenticationRecord(userRoleDTO, null, PageVarList.USER_ROLE_MGT_PAGE, task,remark, username, systemDate);
                dualAuthenticationDAO.save(authenticationRecord);
                return new CommonRecordResponseDTO(Long.valueOf(authenticationRecord.getId()), messageResource.getMessage(MessageConstant.USER_ROLE_SEND_APPROVAL, new Object[]{userRoleDTO.getCode()}));
            } else {
                UserRoleMapper.dtoToEntity(userRole, userRoleDTO);
                userRole.setCode(userRoleDTO.getCode());
                commonMethod.getPopulateEntityWhenInsert(userRole, username, systemDate);
                userRoleDAO.save(userRole);
                this.systemAuditService.saveSystemAudit(UserRoleMapper.entityToDTO(userRole), null, PageVarList.USER_ROLE_MGT_PAGE, TaskEnum.ADD.getCode(), ipAddress, username, systemDate);
                return new CommonRecordResponseDTO<Long>(Long.valueOf(userRole.getId()), messageResource.getMessage(MessageConstant.USER_ROLE_SAVE_SUCCESS, new Object[]{userRole.getCode()}));
            }
        } catch (CodeExistsException | PendingRequestException ex) {
            log.error("Exception  :  ", ex);
            throw ex;
        } catch (Exception ex) {
            log.error("Exception  :  ", ex);
            throw ex;
        }


    }

    @Override
    @Transactional
    public Object updateUserRole(String code, UserRoleDTO userRoleDTO, String username,String ipAddress,Date systemDate) {
        try {
            String remark=userRoleDTO.getRemark();;
            UserRole userRole = Optional.ofNullable(userRoleDAO.findByCodeAndStatusCodeNot(code, StatusEnum.DELETE.getCode()))
                    .orElseThrow(() -> new ObjectNotFoundException(messageResource.getMessage(MessageConstant.USER_ROLE_NOT_FOUND, new Object[]{code})));
            userRoleDTO.setRemark(this.commonMethod.getRemark(userRoleDTO.getRemark(), userRole.getRemark(), username, systemDate));
            UserRoleDTO preUserRoleDTO = UserRoleMapper.entityToDTO(userRole);
            if (pageService.checkDualAuthStatus(PageVarList.USER_ROLE_MGT_PAGE)) {
                DualAuthenticationRecord authenticationRecord = Optional.ofNullable(dualAuthenticationDAO.findByPageAndUniqueId1AndStatusCode(PageVarList.USER_ROLE_MGT_PAGE, userRoleDTO.getCode(), DualAuthStatusEnum.PENDING.getDescription())).orElse(null);
                if (authenticationRecord != null)
                    throw new PendingRequestException(messageResource.getMessage(MessageConstant.USER_ROLE_APPROVAL_PENDING, new Object[]{userRoleDTO.getCode()}));
                Task task = Optional.ofNullable(taskDAO.findByCodeAndStatusCode(TaskEnum.UPDATE.getCode(), StatusEnum.ACTIVE.getCode()))
                        .orElseThrow(() -> new ObjectNotFoundException(messageResource.getMessage(MessageConstant.TASK_NOT_FOUND, new Object[]{TaskEnum.UPDATE.getCode()})));
                authenticationRecord = commonMethod.createAuthenticationRecord(userRoleDTO, preUserRoleDTO, PageVarList.USER_ROLE_MGT_PAGE, task,remark, username, systemDate);
                dualAuthenticationDAO.save(authenticationRecord);
                return new CommonRecordResponseDTO(Long.valueOf(authenticationRecord.getId()), messageResource.getMessage(MessageConstant.USER_ROLE_SEND_APPROVAL, new Object[]{userRoleDTO.getCode()}));
            } else {
                UserRoleMapper.dtoToEntity(userRole, userRoleDTO);
                commonMethod.getPopulateEntityWhenUpdate(userRole, username, systemDate);
                userRoleDAO.save(userRole);
                this.systemAuditService.saveSystemAudit(UserRoleMapper.entityToDTO(userRole), preUserRoleDTO, PageVarList.USER_ROLE_MGT_PAGE, TaskEnum.UPDATE.getCode(), ipAddress, username, systemDate);
                return new CommonResponseDTO(messageResource.getMessage(MessageConstant.USER_ROLE_UPDATE_SUCCESS, new Object[]{userRoleDTO.getCode()}));
            }
        } catch (ObjectNotFoundException | PendingRequestException ex) {
            log.error("Exception  :  ", ex);
            throw ex;
        } catch (Exception ex) {
            log.error("Exception  :  ", ex);
            throw ex;
        }
    }

    @Override
    @Transactional
    public Object deleteUserRole(String code, String remark, String username,String ipAddress,Date systemDate) {
        try {
            String detailRemark;
            UserRole userRole = Optional.ofNullable(userRoleDAO.findByCodeAndStatusCodeNot(code, StatusEnum.DELETE.getCode()))
                    .orElseThrow(() -> new ObjectNotFoundException(messageResource.getMessage(MessageConstant.USER_ROLE_NOT_FOUND, new Object[]{code})));
            List<UserUserRole> userUserRoleList =userUserRoleDAO.findByUserRoleAndStatusCode(userRole,StatusEnum.ACTIVE.getCode());
            if(!userUserRoleList.isEmpty())
                throw new InvalidOperationException(messageResource.getMessage(MessageConstant.SECTION_DELETE_ERROR, new Object[]{code}));


            detailRemark = this.commonMethod.getRemark(remark, userRole.getRemark(), username, systemDate);
            if (pageService.checkDualAuthStatus(PageVarList.USER_ROLE_MGT_PAGE)) {
                DualAuthenticationRecord authenticationRecord = Optional.ofNullable(dualAuthenticationDAO.findByPageAndUniqueId1AndStatusCode(PageVarList.USER_ROLE_MGT_PAGE, code, DualAuthStatusEnum.PENDING.getCode())).orElse(null);
                if (authenticationRecord != null)
                    throw new PendingRequestException(messageResource.getMessage(MessageConstant.USER_ROLE_APPROVAL_PENDING, new Object[]{code}));
                Task task = Optional.ofNullable(taskDAO.findByCodeAndStatusCode(TaskEnum.DELETE.getCode(), StatusEnum.ACTIVE.getCode()))
                        .orElseThrow(() -> new ObjectNotFoundException(messageResource.getMessage(MessageConstant.TASK_NOT_FOUND, new Object[]{TaskEnum.DELETE.getCode()})));
                UserRoleDTO userRoleDTO = UserRoleMapper.entityToDTO(userRole);
                authenticationRecord = commonMethod.createAuthenticationRecord(userRoleDTO, null, PageVarList.USER_ROLE_MGT_PAGE, task,remark, username,systemDate);
                dualAuthenticationDAO.save(authenticationRecord);
                return new CommonRecordResponseDTO(Long.valueOf(authenticationRecord.getId()), messageResource.getMessage(MessageConstant.USER_ROLE_SEND_APPROVAL, new Object[]{code}));
            } else {
                userRole.setStatusCode(StatusEnum.DELETE.getCode());
                userRole.setRemark(detailRemark);
                commonMethod.getPopulateEntityWhenUpdate(userRole, username, systemDate);
                userRoleDAO.save(userRole);
                this.systemAuditService.saveSystemAudit(UserRoleMapper.entityToDTO(userRole), null, PageVarList.USER_ROLE_MGT_PAGE, TaskEnum.DELETE.getCode(), ipAddress, username, systemDate);
                return new CommonResponseDTO(messageResource.getMessage(MessageConstant.USER_ROLE_DELETE_SUCCESS, new Object[]{code}));
            }
        } catch (ObjectNotFoundException | PendingRequestException ex) {
            log.error("Exception  :  ", ex);
            throw ex;
        } catch (Exception ex) {
            log.error("Exception  :  ", ex);
            throw ex;
        }
    }



}
*/
