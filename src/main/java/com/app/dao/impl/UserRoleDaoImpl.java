package com.app.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.dao.UserRoleDao;

@Repository
public class UserRoleDaoImpl implements UserRoleDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<String> findRoleByUserName(String userName) {
		String hql="select UROLE.role from UserRole UROLE, User USER where USER.userName="+"'"+userName+"'"+" and UROLE.userid=USER.userId";
		return sessionFactory.openSession().createQuery(hql).list();
	}

}
