package org.zhajing.police;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.zhajing.police.auth.PoliceDetails;
import org.zhajing.police.entity.Police;
import org.zhajing.police.repository.PoliceRepository;

/**
 * @author Mason.Chen
 * @description
 * @date 2024/02/22 15:20
 * @blame Middle Platform
 */

@Component
public class PoliceUserDetailService implements UserDetailsService {

    PoliceRepository policeRepository;

    @Autowired
    public void setPoliceRepository(PoliceRepository policeRepository) {
        this.policeRepository = policeRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Police police = this.policeRepository.getPoliceByPoliceNumber(username);
        PoliceDetails policeDetails = new PoliceDetails();
        policeDetails.setName(police.getName());
        policeDetails.setPassword(police.getPassword());
        policeDetails.setUsername(police.getPoliceNumber());
        return policeDetails;
    }

    public static void main(String[] args) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encode = bCryptPasswordEncoder.encode("123456");
        System.out.println(encode);
    }
}
