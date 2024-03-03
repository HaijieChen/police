package org.zhajing.police.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "police")
public class Police {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false, length = 64)
    private String name;

    @Column(name = "police_number", nullable = false, length = 64)
    private String policeNumber;

    @Column(name = "phone", nullable = false, length = 64)
    private String phone;

    @Column(name = "password", nullable = false, length = 64)
    private String password;

    @Column(name = "create_time", nullable = false)
    private Instant createTime;

    @Column(name = "update_time", nullable = false)
    private Instant updateTime;

}