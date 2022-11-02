package com.cydeo.service.imp;

import com.cydeo.dto.UserDTO;
import com.cydeo.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public List<UserDTO> listAllUsers() {

        //controller calling me and requesting all the roles
        //so i need to go to database and bring all the roles from there
        //who is going to give the data from database? Repository becasue only way to retrieve data from database is with sql

        return null;
    }

    @Override
    public UserDTO findByUserName(String username) {
        return null;
    }

    @Override
    public void save(UserDTO dto) {

    }

    @Override
    public UserDTO update(UserDTO dto) {
        return null;
    }

    @Override
    public void deleteByUserName(String username) {

    }
}
