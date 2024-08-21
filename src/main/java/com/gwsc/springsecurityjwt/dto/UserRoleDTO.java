package com.gwsc.springsecurityjwt.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.Date;

/*
 * @author: supul_g on 03/02/2021
 */
@Data
public class UserRoleDTO extends BaseDTO{
    @NotBlank(message = "Please select a status")
    private String statusCode;
    private String statusDescription;
    private String remark;
    private String oldRemarks;
}
