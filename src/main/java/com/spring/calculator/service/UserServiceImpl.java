package com.spring.calculator.service;

import com.spring.calculator.model.User;
import com.spring.calculator.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

// Skirtas vartotojo inforamcijos saugojimui (uzkoduoto slaptazodzio ir roliu)
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    public UserRepository userRepository;


    //@Autowired
    //@Qualifier("BCryptPasswordEncoder")
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(User user){
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        // Pagal nutylejima naujas vartotojas bus "user".
        // Saugumo sumetimais paprasta vartotoja padaryti "admin" galima, kol kas, tik per duomenu baze
        user.setAuthorities("user");

        userRepository.save(user);
    }

    @Override
    // kai registruojamas naujas vartotojas, reikia patikrinti ar nera duplikatu vartotojo vardui
    public User findByUsername(String username){
        return userRepository.findByUsername(username);
    }

}
