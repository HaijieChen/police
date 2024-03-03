package org.zhajing.police.repository;

import org.springframework.data.repository.Repository;
import org.springframework.stereotype.Component;
import org.zhajing.police.entity.Police;

/**
 * @author Mason.Chen
 * @description
 * @date 2024/02/26 15:43
 * @blame Middle Platform
 */
@Component
public interface PoliceRepository extends Repository<Police,Long> {

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

}
