package com.app.dao;

import java.util.List;

public interface UserRoleDao {
public List<String> findRoleByUserName(String userName);

}
