package com.gwsc.springsecurityjwt.mapping;
import jakarta.persistence.*;
import lombok.Data;

import static jakarta.persistence.GenerationType.IDENTITY;
@Data
@Entity
@Table(name = "module")
public class Module extends CommonEntity{
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private int id;
    @Column(name = "CODE", nullable = false, length = 8)
    private String code;
    @Column(name = "DESCRIPTION", nullable = false, length = 64)
    private String description;
    @Column(name = "STATUS", nullable = false, length = 8)
    private String statusCode;
}
