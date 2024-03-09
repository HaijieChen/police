package org.zhajing.police.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.zhajing.police.entity.Suspect;

import java.time.Instant;
import java.time.LocalDate;

/**
 * @author Mason.Chen
 * @description
 * @date 2024/03/08 15:52
 * @blame Middle Platform
 */
@Repository
public interface SuspectRepository extends JpaRepository<Suspect,Long> {

    long count();


    long countByCreateTimeAfter(Instant createTime);

}