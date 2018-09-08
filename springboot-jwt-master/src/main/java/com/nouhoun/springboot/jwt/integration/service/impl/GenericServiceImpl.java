package com.nouhoun.springboot.jwt.integration.service.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nouhoun.springboot.jwt.integration.bean.RoleBean;
import com.nouhoun.springboot.jwt.integration.bean.UserBean;
import com.nouhoun.springboot.jwt.integration.domain.Order;
import com.nouhoun.springboot.jwt.integration.domain.RandomCity;
import com.nouhoun.springboot.jwt.integration.domain.User;
import com.nouhoun.springboot.jwt.integration.domain.Work;
import com.nouhoun.springboot.jwt.integration.repository.OrderRepository;
import com.nouhoun.springboot.jwt.integration.repository.RandomCityRepository;
import com.nouhoun.springboot.jwt.integration.repository.RoleRepository;
import com.nouhoun.springboot.jwt.integration.repository.UserRepository;
import com.nouhoun.springboot.jwt.integration.repository.WorkRepository;
import com.nouhoun.springboot.jwt.integration.service.GenericService;


@Service
public class GenericServiceImpl implements GenericService {
	
	@Autowired
	private EntityManager entityManager;
	
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private WorkRepository workRepository;
    
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private RandomCityRepository randomCityRepository;
    
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> findAllUsers() {
        return (List<User>)userRepository.findAll();
    }

    @Override
    public User registerUser(User user) {
        return (User)userRepository.save(user);
    }
    
    @Override
    public List<RandomCity> findAllRandomCities() {
        return (List<RandomCity>)randomCityRepository.findAll();
    }

	@Override
	public List<UserBean> getAllUsers() {
		List<UserBean> arlUserBean = new ArrayList<UserBean>();
		UserBean bean = null;
		List<Object[]> list = userRepository.getAllUsers();
		for(Object[] obj : list){
			bean = new UserBean();
			bean.setUserName((String) obj[2]);
			bean.setFirstName((String) obj[0]);
			bean.setLastName((String) obj[1]);
			arlUserBean.add(bean);
		}
		return arlUserBean;
	}

	@Override
	public List<UserBean> getUserByUserName(String userName) {
		List<UserBean> arlUserBean = new ArrayList<UserBean>();
		List<Object[]> list = userRepository.getUserByUserName(userName);
		UserBean bean = null;
		for(Object[] obj : list){
			bean = new UserBean();
			bean.setUserName((String) obj[2]);
			bean.setFirstName((String) obj[0]);
			bean.setLastName((String) obj[1]);
			arlUserBean.add(bean);
		}
		return arlUserBean;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public int registerUser(UserBean userBean) {
		int retId = -1;
		int userId = -1;
		try {
				Query query = entityManager.createNativeQuery("INSERT INTO APP_USER (FIRST_NAME, LAST_NAME, USERNAME, PASSWORD) VALUES(?1,?2,?3,?4)");
		        query.setParameter(1, userBean.getFirstName());
		        query.setParameter(2, userBean.getLastName());
		        query.setParameter(3, userBean.getUserName());
		        query.setParameter(4, userBean.getEncodedPswd());
		        retId = query.executeUpdate();
		        if(retId > 0){
		        	query = entityManager.createNativeQuery("SELECT ID FROM APP_USER WHERE USERNAME = ?1");
		        	query.setParameter(1, userBean.getUserName());
		        	List<BigInteger> list = query.getResultList();
		        	for(BigInteger id : list){
		        		userId = id.intValue();
		        	}
		        	if(userId != -1){
		        		retId = -2;
		        		query = entityManager.createNativeQuery("INSERT INTO USER_ROLE (USER_ID, ROLE_ID) VALUES(?1,?2)");
		        		query.setParameter(1, userId);
		        		query.setParameter(2, 1);
		        		retId = query.executeUpdate();
		        	}
		        	
		        }
		        System.out.println("Ret Id-->"+retId);
		} catch (Exception e) {
			System.out.println("err-->"+ e);
		}
		return retId;
	}

	@Override
	public List<RoleBean> getAllRoles() {
		List<RoleBean> arlRoleBean = new ArrayList<RoleBean>();
		RoleBean bean = null;
		List<Object[]> list = roleRepository.getAllRoles();
		for(Object[] obj : list){
			bean = new RoleBean();
			bean.setId((int) obj[0]);
			bean.setRolename((String) obj[1]);
			bean.setDescription((String) obj[2]);
			arlRoleBean.add(bean);
		}
		return arlRoleBean;
	}

	@Override
	public List<Work> findAllWorks() {
		// TODO Auto-generated method stub
		return (List<Work>)workRepository.findAll();	
	}

	@Override
	public Order saveOrder(Order order) {
		 return (Order)orderRepository.save(order);
	}

}
