package org.zhajing.police.vo;

import lombok.Data;

/**
 * @author Mason.Chen
 * @description
 * @date 2024/03/08 15:46
 * @blame Middle Platform
 */
@Data
public class StatisticVO {

    /**
     * 警察数量
     */
    private long policeNumb ;

    /**
     * 嫌疑人数量
     */
    private long suspectNumb ;
    /**
     * 新增嫌疑人数量
     */
    private long newSuspectNumb ;

    /**
     * 今日推送地址数量
     */
    private long todayPushAddressNumb ;
}
