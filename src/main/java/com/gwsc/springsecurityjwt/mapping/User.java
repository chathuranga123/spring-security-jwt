package com.gwsc.springsecurityjwt.mapping;

/*
 * @author: supul_g on 03/02/2021
 */

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;



import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;
@Getter
@Setter
@Entity
@Table(name = "user")
public class User extends CommonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private int id;
    @Column(name = "USERNAME", nullable = false, length = 64)
    private String username;
    @Column(name = "FULL_NAME", nullable = false, length = 128)
    private String fullName;
    @Column(name = "EMAIL", nullable = false, length = 128)
    private String email;
    @Column(name = "PASSWORD")
    private String password;
    @Lob
    @Column(name = "PROFILE_PICTURE")
    private  byte[] profilePicture;
    @Column(name = "STATUS", nullable = false, length = 8)
    private String statusCode;
    @Column(name = "PASSWORD_STATUS", length = 8)
    private String passwordStatus;
    @Column(name = "ATTEMPT", nullable = false)
    private int attempt;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "LAST_LOGGED_DATE", length = 19)
    private Date lastLoggedDate;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "PASSWORD_EXPIRE_DATE", length = 19)
    private Date passwordExpireDate;
    @Column(name = "REMARK")
    private String remark;
}
