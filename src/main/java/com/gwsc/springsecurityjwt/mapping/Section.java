package com.gwsc.springsecurityjwt.mapping;
/*
 * @author: supul_g on 01/02/2021
 */

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.IDENTITY;

@Data
@Entity
@Table(name = "section")
@NoArgsConstructor
public class Section  extends CommonEntity   {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private int id;
    @Column(name = "CODE", nullable = false, length = 8)
    private String code;
    @Column(name = "DESCRIPTION", nullable = false, length = 64)
    private String description;
    @Column(name = "SORT_KEY", nullable = false)
    private int sortKey;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MODULE", nullable = false)
    private Module module;
    @Column(name = "STATUS", nullable = false, length = 8)
    private String statusCode;
    @Column(name = "REMARK")
    private String remark;

//    public Section(Section obj){
//        super(obj.getCreatedUser(),obj.getLastUpdatedUser(),obj.getCreatedTime(),obj.getLastUpdatedTime());
//        this.id=obj.id;
//        this.code=obj.code;
//        this.description=obj.description;
//        this.sortKey=obj.sortKey;
//        this.statusCode=obj.statusCode;
//        this.remark=obj.remark;
//
//
//    }




}
