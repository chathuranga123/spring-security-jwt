package com.gwsc.springsecurityjwt.enums;
/*
 * @author: supul_g on 01/02/2021
 */


import com.gwsc.springsecurityjwt.utility.CommonConstant;

public enum StatusEnum {

    ACTIVE(CommonConstant.STATUS_ACTIVE, CommonConstant.STATUS_ACTIVE_DESCRIPTION),
    INACTIVE(CommonConstant.STATUS_INACTIVE, CommonConstant.STATUS_INACTIVE_DESCRIPTION),
    DELETE(CommonConstant.STATUS_DELETE, CommonConstant.STATUS_DELETE_DESCRIPTION),
    LOCKED(CommonConstant.STATUS_LOCKED, CommonConstant.STATUS_LOCKED_DESCRIPTION),
    BLOCK(CommonConstant.STATUS_BLOCK, CommonConstant.STATUS_BLOCK_DESCRIPTION);

    private String code;
    private String description;

    StatusEnum(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public static StatusEnum getEnum(String code) {
        switch (code) {
            case CommonConstant.STATUS_ACTIVE:
                return ACTIVE;
            case CommonConstant.STATUS_INACTIVE:
                return INACTIVE;
            case CommonConstant.STATUS_LOCKED:
                return LOCKED;
            case CommonConstant.STATUS_BLOCK:
                return BLOCK;
            default:
                return DELETE;
        }
    }
}
