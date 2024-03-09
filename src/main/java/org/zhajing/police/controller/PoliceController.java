package org.zhajing.police.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zhajing.police.entity.Police;
import org.zhajing.police.service.PoliceService;
import org.zhajing.police.utils.Result;
import org.zhajing.police.utils.Security;
import org.zhajing.police.vo.StatisticVO;

/**
 * @author Mason.Chen
 * @description
 * @date 2024/02/26 16:12
 * @blame Middle Platform
 */

@CrossOrigin(originPatterns = "/police/**")
@RestController
@RequestMapping("/police")
public class PoliceController {

    private PoliceService policeService;

    @Autowired
    public void setPoliceService(PoliceService policeService) {
        this.policeService = policeService;
    }

    @GetMapping
    public Result<Police> police(){
        String policeNumber = Security.getPoliceNumber();
        Police police = this.policeService.getPoliceByPoliceNumber(policeNumber);
        return Result.ok(police);
    }

    @GetMapping("/statisticNumb")
    public Result<StatisticVO> statisticNumb(){
       return Result.ok(this.policeService.getPoliceByPoliceNumber());
    }


}
