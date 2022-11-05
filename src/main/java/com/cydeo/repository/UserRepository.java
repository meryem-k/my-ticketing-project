package com.cydeo.repository;

import com.cydeo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

public interface UserRepository extends JpaRepository<User,Long> {

    User findByUsername(String username);

    @Transactional
    void deleteUserByUserName(String username);


}
