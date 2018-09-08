package com.nouhoun.springboot.jwt.integration.repository;

import java.util.List;

import com.nouhoun.springboot.jwt.integration.domain.Role;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by nydiarra on 06/05/17.
 */
public interface RoleRepository extends CrudRepository<Role, Long> {
	
	@Query(nativeQuery=true, value="SELECT ID, ROLENAME, DESCRIPTION FROM ROLE")
    public List<Object[]> getAllRoles();
}
