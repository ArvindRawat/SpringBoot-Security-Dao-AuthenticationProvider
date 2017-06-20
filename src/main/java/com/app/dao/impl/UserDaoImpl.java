package com.app.dao.impl;


import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.dao.UserDao;
import com.app.entity.User;


@Repository
public class UserDaoImpl implements UserDao {
	
	@Autowired
	SessionFactory sessionFactory;
/***
 * @author arvind.rawat
 * @description get user detail from db by username
 */
	@Override
	public User getUserByUserName(String userName) {
		Criteria criteria=sessionFactory.openSession().createCriteria(User.class);
		criteria.add(Restrictions.eq("userName", userName.trim()));
		return (User) criteria.uniqueResult();
	}


}
