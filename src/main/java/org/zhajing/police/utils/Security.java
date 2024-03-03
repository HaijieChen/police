package org.zhajing.police.utils;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.zhajing.police.auth.PoliceDetails;
import org.zhajing.police.entity.Police;

import java.util.Optional;

/**
 * @author Mason.Chen
 * @description
 * @date 2024/02/26 16:26
 * @blame Middle Platform
 */
public class Security {

    public static PoliceDetails getPolice(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object details = authentication.getPrincipal();
        if (details instanceof PoliceDetails){
            return (PoliceDetails) details;
        }
        return null;
    }

    public static String getPoliceNumber(){
        PoliceDetails police = getPolice();
        return Optional.ofNullable(police).orElseThrow().getUsername();
    }
}
