package org.zhajing.police.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "suspect_address")
public class SuspectAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "suspect_id", nullable = false)
    private Long suspectId;

    @Column(name = "address", nullable = false, length = 64)
    private String address;

    @Column(name = "found_time", nullable = false)
    private Instant foundTime;

    @Column(name = "latitude", nullable = false, length = 64)
    private String latitude;

    @Column(name = "longitude", nullable = false, length = 64)
    private String longitude;

    @Column(name = "create_time", nullable = false)
    private Instant createTime;

    @Column(name = "update_time", nullable = false)
    private Instant updateTime;

}