package com.mysite.nexfilx.User.service;

import com.mysite.nexfilx.User.dao.UserRepository;
import com.mysite.nexfilx.User.main.NetflixUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public NetflixUser create(NetflixUser netflixUser) {

//        NetflixUser user = new NetflixUser();
//        user.setUserEmail(userDto.getUserEmail());

//        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        netflixUser.setPassword(passwordEncoder.encode(netflixUser.getPassword()));

        userRepository.save(netflixUser);

        return netflixUser;


    }

    public NetflixUser login(NetflixUser netflixUser) {
        Optional<NetflixUser> User = userRepository.findByUseremail(netflixUser.getUseremail());
        if (User.isPresent()) {
            NetflixUser loginUser = User.get();

            if(passwordEncoder.matches(netflixUser.getPassword(), loginUser.getPassword())) {
                return loginUser;
            }
            return null;
        }
        return null;
    }


}
