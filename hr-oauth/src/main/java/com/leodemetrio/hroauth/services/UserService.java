package com.leodemetrio.hroauth.services;

import com.leodemetrio.hroauth.entities.User;
import com.leodemetrio.hroauth.feignclients.UserFeignClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;



@Service
public class UserService implements UserDetailsService {

    private static Logger logger = LoggerFactory.getLogger(UserService.class);
    private final UserFeignClient userFeignClient;

    public UserService(UserFeignClient userFeignClient){
        this.userFeignClient = userFeignClient;
    }
    public User findByEmail(String email){
        User user = userFeignClient.findByEmail(email).getBody();
        if(user == null) {
            logger.error("Email not found");
            throw new IllegalArgumentException("Email not found");
        }
        logger.info(email);
        return user;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userFeignClient.findByEmail(email).getBody();
        if(user == null) {
            logger.error("Email not found");
            throw new UsernameNotFoundException("Email not found");
        }
        logger.info(email);
        return user;
    }
}
