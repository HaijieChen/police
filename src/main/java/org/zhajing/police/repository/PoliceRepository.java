package org.zhajing.police.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.zhajing.police.entity.Police;

/**
 * @author Mason.Chen
 * @description
 * @date 2024/02/26 15:43
 * @blame Middle Platform
 */
@Repository
public interface PoliceRepository extends JpaRepository<Police,Long> {

    /**
     * 通过警号和密码查询登录
     * @param policeNumber
     * @return
     */
    Police getPoliceByPoliceNumberAndPassword(String policeNumber,String password);

    /**
     * 根据警号查询身份信息
     * @param policeNumber
     * @return
     */
    Police getPoliceByPoliceNumber(String policeNumber);

    long count();

}
