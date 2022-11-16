package com.springboot.services.security;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springboot.entity.UserEntity;
import com.springboot.repositories.IUserRepository;
import com.springboot.security.MyUser;
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private IUserRepository userRepository;

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		MyUser myUser = null;
		try {
			UserEntity user = userRepository.findOneByUsernameAndEnabled(username, 1);
			if(user != null){
				Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
				grantedAuthorities.add(new SimpleGrantedAuthority(user.getRole()));

				myUser = new MyUser(user.getUsername(), user.getPassword(), grantedAuthorities);
				myUser.setId(user.getId());
				myUser.setFullName(user.getFullname());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return myUser;
	}

}
