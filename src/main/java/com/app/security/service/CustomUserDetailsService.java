package com.app.security.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.app.dao.UserDao;
import com.app.dao.UserRoleDao;
import com.app.entity.User;
import com.app.security.model.CustomUserDetail;



@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	UserRoleDao userRoleDao;

	@Transactional
	@Override
	public CustomUserDetail loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("In loadUserByUsername method..");
		User user=userDao.getUserByUserName(username);
		if(user!=null){
			List<String> userRoles=userRoleDao.findRoleByUserName(username);
			 return new CustomUserDetail(user,userRoles);
	    }
		return null;
	}

}
