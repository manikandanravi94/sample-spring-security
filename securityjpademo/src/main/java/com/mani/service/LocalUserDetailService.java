package com.mani.service;

import com.mani.model.LocalUserDetail;
import com.mani.model.User;
import com.mani.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LocalUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<User> user=userRepository.findByUserName(s);

        user.orElseThrow(() -> new UsernameNotFoundException("userName/password is invalid"));

        if(user==null){
            throw new UsernameNotFoundException("userName/password is invalid");
        }

        return new LocalUserDetail(user.get());
    }
}
