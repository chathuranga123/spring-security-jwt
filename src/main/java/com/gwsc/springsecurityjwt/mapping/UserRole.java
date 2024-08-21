package com.gwsc.springsecurityjwt.mapping;

/*
 * @author: supul_g on 03/02/2021
 */

import jakarta.persistence.*;
import lombok.Data;

import static jakarta.persistence.GenerationType.IDENTITY;


@Data
@Entity
@Table(name = "user_role")
public class UserRole extends CommonEntity {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Long id;
    @Column(name = "CODE", nullable = false, length = 8)
    private String code;
    @Column(name = "DESCRIPTION", nullable = false, length = 64)
    private String description;
    @Column(name = "STATUS", nullable = false, length = 8)
    private String statusCode;
    @Column(name = "REMARK")
    private String remark;
}
