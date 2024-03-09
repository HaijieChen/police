package org.zhajing.police.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.zhajing.police.entity.SuspectAddress;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;

@Repository
public interface SuspectAddressRepository extends JpaRepository<SuspectAddress, Long> {

   long countAllByCreateTimeAfter(Instant localDate);
}