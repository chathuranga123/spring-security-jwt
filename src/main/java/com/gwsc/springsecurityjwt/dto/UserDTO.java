package com.gwsc.springsecurityjwt.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
public class UserDTO extends CommonDTO{
    private Long id;
    @NotBlank(message = "Please provide a username")
    @Size(min = 1, max = 64, message = "Username maximum length should be 64 characters.")
    private String username;
    private String password;
    private String newPassword;
    private String fullName;
    private String email;
    @NotBlank(message = "Please select a status")
    private String statusCode;
    private String userRoleCode;
    private String userRoleDescription;
    private String statusDescription;
    private String passwordStatus;
    private String profilePicture;
    private int attempt;
    private Date lastLoggedDate;
    private Date passwordExpireDate;
    private String remark;
    private String oldRemarks;
}
