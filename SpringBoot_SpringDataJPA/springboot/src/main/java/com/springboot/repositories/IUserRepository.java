package com.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.entity.UserEntity;

public interface IUserRepository extends JpaRepository<UserEntity, Integer>{

	UserEntity findOneByUsernameAndEnabled(String username, int enabled);

}
