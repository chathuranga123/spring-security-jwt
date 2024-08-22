package com.gwsc.springsecurityjwt.mapping;

import jakarta.persistence.*;
import lombok.Data;

import static jakarta.persistence.GenerationType.IDENTITY;
/*
 * @author: supul_g on 01/02/2021
 */
@Data
@Entity
@Table(name = "page_task_user_role")
public class PageTaskUserRole extends CommonEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private int id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PAGE", nullable = false)
    private Page page;
    @Column(name = "TASK", nullable = false)
    private String task;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ROLE", nullable = false)
    private UserRole userRole;
    @Column(name = "STATUS", nullable = false, length = 8)
    private String statusCode;
    @Column(name = "REMARK")
    private String remark;
}


