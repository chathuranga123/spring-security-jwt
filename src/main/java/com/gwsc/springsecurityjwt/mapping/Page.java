package com.gwsc.springsecurityjwt.mapping;
import jakarta.persistence.*;
import lombok.Data;

import static jakarta.persistence.GenerationType.IDENTITY;
/*
 * @author: supul_g on 01/02/2021
 */

@Data
@Entity
@Table(name = "page")
public class Page extends CommonEntity {
    @Id
    @Column(name = "CODE", unique = true, nullable = false, length = 8)
    private String code;
    @Column(name = "DESCRIPTION", nullable = false, length = 64)
    private String description;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SECTION", nullable = false)
    private Section section;
    @Column(name = "URL", nullable = false, length = 64)
    private String url;
    @Column(name = "SORT_KEY", nullable = false)
    private int sortKey;
    @Column(name = "FREEZED", nullable = false)
    private Boolean freezed;
    @Column(name = "DUAL_AUTH", nullable = false)
    private Boolean dualAuth;
    @Column(name = "STATUS", nullable = false, length = 8)
    private String statusCode;
    @Column(name = "REMARK")
    private String remark;

}
