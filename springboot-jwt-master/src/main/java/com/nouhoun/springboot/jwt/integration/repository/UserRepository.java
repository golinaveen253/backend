package com.nouhoun.springboot.jwt.integration.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
  
import org.springframework.data.repository.query.Param;

import com.nouhoun.springboot.jwt.integration.domain.User;

/**
 * Created by nydiarra on 06/05/17.
 */
public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
    User save(User user);
    
    @Query(nativeQuery=true, value="SELECT FIRST_NAME, LAST_NAME, USERNAME FROM APP_USER")
    public List<Object[]> getAllUsers();
    
    @Query(nativeQuery=true, value="SELECT FIRST_NAME, LAST_NAME, USERNAME FROM APP_USER WHERE USERNAME=?1")
    public List<Object[]> getUserByUserName(@Param(value = "1") String userName);
    
}
