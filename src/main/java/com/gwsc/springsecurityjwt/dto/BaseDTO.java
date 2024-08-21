package com.gwsc.springsecurityjwt.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
/*
 * @author: supul_g on 01/02/2021
 */

@Data
public class BaseDTO extends CommonDTO {
    private Long id;

    @NotBlank(message = "Please provide a code")
    @Size(min = 1, max = 8, message = "Code maximum length should be 8 characters.")
    private String code;
    @NotBlank(message = "Please provide a description")
    @Size(min = 1, max = 64, message = "Description maximum length should be 64 characters.")
    private String description;

}
