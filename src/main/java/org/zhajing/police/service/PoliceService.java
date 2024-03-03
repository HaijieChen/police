package org.zhajing.police.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zhajing.police.entity.Police;
import org.zhajing.police.repository.PoliceRepository;

/**
 * @author Mason.Chen
 * @description
 * @date 2024/02/26 16:12
 * @blame Middle Platform
 */
@Service
public class PoliceService {

    private PoliceRepository policeRepository;

    @Autowired
    public void setPoliceRepository(PoliceRepository policeRepository) {
        this.policeRepository = policeRepository;
    }

    public Police getPoliceByPoliceNumber(String policeNumber) {
        Police policeByPoliceNumber = this.policeRepository.getPoliceByPoliceNumber(policeNumber);
        policeByPoliceNumber.setPassword(null);
        return policeByPoliceNumber;
    }
}
