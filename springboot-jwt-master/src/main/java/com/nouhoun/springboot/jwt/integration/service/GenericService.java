package com.nouhoun.springboot.jwt.integration.service;

import java.util.List;

import com.nouhoun.springboot.jwt.integration.bean.RoleBean;
import com.nouhoun.springboot.jwt.integration.bean.UserBean;
import com.nouhoun.springboot.jwt.integration.domain.Order;
import com.nouhoun.springboot.jwt.integration.domain.RandomCity;
import com.nouhoun.springboot.jwt.integration.domain.User;
import com.nouhoun.springboot.jwt.integration.domain.Work;

/**
 * Created by nydiarra on 06/05/17.
 */
public interface GenericService {
    User findByUsername(String username);

    List<User> findAllUsers();

    List<RandomCity> findAllRandomCities();
    
	User registerUser(User user);
	
	List<UserBean> getUserByUserName(String userName);
	
	List<UserBean> getAllUsers();
	
	int registerUser(UserBean userBean);
	
	List<RoleBean> getAllRoles();
	
	List<Work> findAllWorks();
	
	Order saveOrder(Order order);
}
