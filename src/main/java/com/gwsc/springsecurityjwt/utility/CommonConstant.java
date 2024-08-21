package com.gwsc.springsecurityjwt.utility;

/*
 * @Author  supul_g
 * @Created 01/02/2021-2:41 PM
 */

public class CommonConstant {


    public static final String DATE_FORMAT="YYYY-MM-dd HH:mm:ss";
    public static final String DATE_FORMAT_ONE="MM/dd/yyyy 'at' h:mm a";
    public static final String DATE_FORMAT_TWO = "yyyy-MM-dd";
    public static final String DATE_TIMEZONE_JACKSON = "Asia/Colombo";


    /*------------ Default StatusEnum -------------------*/

    public static final String STATUS_ACTIVE = "ACTIVE";
    public static final String STATUS_INACTIVE = "INACTIVE";
    public static final String STATUS_DELETE = "DELETE";
    public static final String STATUS_LOCKED= "LOCKED";
    public static final String STATUS_BLOCK= "BLOCK";

    public static final String STATUS_ACTIVE_DESCRIPTION = "Active";
    public static final String STATUS_INACTIVE_DESCRIPTION = "Inactive";
    public static final String STATUS_DELETE_DESCRIPTION = "Delete";
    public static final String STATUS_LOCKED_DESCRIPTION = "Locked";
    public static final String STATUS_BLOCK_DESCRIPTION = "Block";

    /*------------ used in API StatusEnum, EmailReferenceType & Task Enum  -------------------*/

    public static final String CREATE = "CREATE";
    public static final String NEW_VERSION = "NVERSION";
    public static final String DELETE = "DELETE";
    public static final String BLKUBLK= "BLKUBLK";
    public static final String BLOCK= "BLOCK";
    public static final String UNBLOCK= "UNBLOCK";
    public static final String ACTIVE= "ACTIVE";
    public static final String REMOVED= "REMOVED";//SysRemoved
    public static final String RETIRE= "RETIRE";
    public static final String DEPRECATE= "DEPRECAT";

    public static final String CREATE_DESCRIPTION = "Create";
    public static final String NEW_VERSION_DESCRIPTION = "New Version";
    public static final String DELETE_DESCRIPTION = "Delete";
    public static final String BLKUBLK_DESCRIPTION = "Block/Unblock";
    public static final String BLOCK_DESCRIPTION = "Block";
    public static final String UNBLOCK_DESCRIPTION = "Unblock";
    public static final String ACTIVE_DESCRIPTION = "Active";
    public static final String REMOVED_DESCRIPTION = "Removed";
    public static final String RETIRE_DESCRIPTION = "Retire";
    public static final String DEPRECATE_DESCRIPTION = "Deprecate";

    /*------------ Dual Auth StatusEnum -------------------*/

    public static final String DUAL_AUTH_STATUS_PENDING= "PENDING";
    public static final String DUAL_AUTH_STATUS_APPROVED= "APPROVED";
    public static final String DUAL_AUTH_STATUS_REJECTED = "REJECTED";

    public static final String DUAL_AUTH_STATUS_PENDING_DESCRIPTION = "Pending";
    public static final String DUAL_AUTH_STATUS_APPROVED_DESCRIPTION = "Approved";
    public static final String DUAL_AUTH_STATUS_REJECTED_DESCRIPTION = "Rejected";


    /*------------ Password  StatusEnum -------------------*/

    public static final String PASSWORD_STATUS_DRAFT = "DRAFT";
    public static final String PASSWORD_STATUS_ACTIVE = "ACTIVE";
    public static final String DEFAULT_STATUS_EXPIRED = "EXPIRED";

    public static final String PASSWORD_STATUS_DRAFT_DESCRIPTION = "Draft";
    public static final String PASSWORD_STATUS_ACTIVE_DESCRIPTION = "Active";
    public static final String DEFAULT_STATUS_EXPIRED_DESCRIPTION = "Expired";


    /*------------ TaskEnum -------------------*/
    public static final String TASK_LOGIN= "LOGIN";
    public static final String TASK_ADD= "ADD";
    public static final String TASK_VIEW= "VIEW";
    public static final String TASK_UPDATE= "UPDATE";
    public static final String TASK_RETIRE = "RETIRE";
    public static final String TASK_DELETE= "DELETE";
    public static final String TASK_ASSIGN= "ASSIGN";
    public static final String TASK_APPROVE= "APPROVE";
    public static final String TASK_REJECT= "REJECT";
    public static final String TASK_RESET_PASSWORD= "RESETPW";
    public static final String TASK_ACTDCT= "ACTDCT";
    public static final String TASK_NEW_VERSION= "NVERSION";
    public static final String TASK_BLOCK_UNBLOCK= "BLKUBLK";
    public static final String TASK_ACTIVATE= "ACTIVE";
    public static final String TASK_DEPRECATE= "DEPRECAT";
    public static final String TASK_DOWNLOAD= "DOWNLOAD";

//    public static final String TASK_ADD_DESCRIPTION = "Login";
//    public static final String TASK_ADD_DESCRIPTION = "Add";
//    public static final String TASK_VIEW_DESCRIPTION = "View";
//    public static final String TASK_UPDATE_DESCRIPTION = "Update";
//    public static final String TASK_DELETE_DESCRIPTION = "delete";
//    public static final String TASK_ASSIGN_DESCRIPTION = "assign";
//    public static final String TASK_APPROVE_DESCRIPTION = "approve";
//    public static final String TASK_REJECT_DESCRIPTION = "reject";
//    public static final String TASK_RESET_PASSWORD_DESCRIPTION = "Reset Password";
//    public static final String TASK_ACTDCT_DESCRIPTION = "Active/De-active";
//    public static final String TASK_NEW_VERSION_DESCRIPTION= "New Version";
//    public static final String TASK_BLOCK_UNBLOCK_DESCRIPTION= "Block/Unblock";
//    public static final String TASK_ACTIVATE_DESCRIPTION= "Active";
//    public static final String TASK_DEPRECATE_DESCRIPTION= "Deprecate";
//    public static final String TASK_RETIRE_DESCRIPTION = "Retire";
    /*------------ Data type -------------------*/

    public static final String DATA_TYPE_NUMBER= "NUMBER";

    public static final String DATA_TYPE_NUMARIC_DESCRIPTION = "Number";

    /*------------  UserType Enum -------------------*/

    public static final String USER_TYPE_SYSTEM = "SYSUSER";
    public static final String USER_TYPE_TPP = "TPPUSER";

    public static final String USER_TYPE_SYSTEM_DESCRIPTION = "System User";
    public static final String USER_TYPE_TPP_DESCRIPTION = "Tpp User";

    public static final String REF_NUMBER_TYPE_API = "API_REF";
    public static final String REF_NUM_UNIQUE_CODE_API = "OBP_API_";
    public static final int REF_NUM_SERIAL_LENGTH= 4;
}
