package com.example.ecommerce.service.impl;


import com.example.ecommerce.entity.Role;
import com.example.ecommerce.repository.RoleRepository;
import com.example.ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

  @Autowired
  private UserRepository userRepository;


  @Override
  public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
    com.example.ecommerce.entity.User user = userRepository.findByUsername(userName);

    if (user == null) {
      System.out.println("User not found! " + userName);
      throw new UsernameNotFoundException("User " + userName + " was not found in the database");
    }
    Role roleNames = user.getRole();
    List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
    GrantedAuthority authority = new SimpleGrantedAuthority(roleNames.getRoleName());
    grantList.add(authority);

    UserDetails userDetails =  new User(user.getUsername(),
            user.getPassword(), grantList);
    
    return userDetails;
  }

}
