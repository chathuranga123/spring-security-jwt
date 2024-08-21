package com.gwsc.springsecurityjwt.dto;

import lombok.Data;

import java.util.Date;

/*
 * @author: supul_g on 01/02/2021
 */
@Data
public class CommonDTO {

    private String createdUser;
    private Date createdTime;
    private String lastUpdatedUser;
    private Date lastUpdatedTime;
}
