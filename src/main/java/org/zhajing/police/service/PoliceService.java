package org.zhajing.police.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zhajing.police.entity.Police;
import org.zhajing.police.repository.PoliceRepository;
import org.zhajing.police.repository.SuspectAddressRepository;
import org.zhajing.police.repository.SuspectRepository;
import org.zhajing.police.vo.StatisticVO;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZoneOffset;

/**
 * @author Mason.Chen
 * @description
 * @date 2024/02/26 16:12
 * @blame Middle Platform
 */
@Service
public class PoliceService {

    private PoliceRepository policeRepository;
    private SuspectRepository suspectRepository;
    private SuspectAddressRepository suspectAddressRepository;

    @Autowired
    public void setSuspectAddressRepository(SuspectAddressRepository suspectAddressRepository) {
        this.suspectAddressRepository = suspectAddressRepository;
    }

    @Autowired
    public void setSuspectRepository(SuspectRepository suspectRepository) {
        this.suspectRepository = suspectRepository;
    }

    @Autowired
    public void setPoliceRepository(PoliceRepository policeRepository) {
        this.policeRepository = policeRepository;
    }

    public Police getPoliceByPoliceNumber(String policeNumber) {
        Police policeByPoliceNumber = this.policeRepository.getPoliceByPoliceNumber(policeNumber);
        policeByPoliceNumber.setPassword(null);
        return policeByPoliceNumber;
    }

    public StatisticVO getPoliceByPoliceNumber() {
        long policeCount = this.policeRepository.count();
        long suspectCount = this.suspectRepository.count();
        long todaySuspectCount = suspectRepository.countByCreateTimeAfter(LocalDate.now().atStartOfDay().toInstant(ZoneOffset.of("+8"))  );
        long todaySuspectAddress = this.suspectAddressRepository.countAllByCreateTimeAfter(LocalDate.now().atStartOfDay().toInstant(ZoneOffset.of("+8")));

        StatisticVO statisticVO = new StatisticVO();
        statisticVO.setPoliceNumb(policeCount);
        statisticVO.setNewSuspectNumb(todaySuspectAddress);
        statisticVO.setSuspectNumb(suspectCount);
        statisticVO.setNewSuspectNumb(todaySuspectCount);
        return statisticVO;
    }
}
