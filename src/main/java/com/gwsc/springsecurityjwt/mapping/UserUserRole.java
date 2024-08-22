package com.gwsc.springsecurityjwt.mapping;

import jakarta.persistence.*;
import lombok.Data;

import static jakarta.persistence.GenerationType.IDENTITY;

/*
 * @author: supul_g on 09/02/2021
 */
@Data
@Entity
@Table(name = "user_user_role")
public class UserUserRole  extends CommonEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private int id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER", nullable = false)
    private User user;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ROLE", nullable = false)
    private UserRole userRole;
    @Column(name = "STATUS", nullable = false, length = 8)
    private String statusCode;
    @Column(name = "REMARK")
    private String remark;
}
