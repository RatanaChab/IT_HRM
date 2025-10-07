package com.example.IT_HRM.ServiceImpl;

import com.example.IT_HRM.Config.SecurityUser;
import com.example.IT_HRM.Entity.User;
import com.example.IT_HRM.Repository.UserRepository;
import com.example.IT_HRM.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> byName = userRepository.findByName(username);

        byName.get().setPassword(passwordEncoder.encode(byName.get().getPassword()));
        System.out.println(byName.get().getPassword());
        return byName
                .map(SecurityUser::new)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}
