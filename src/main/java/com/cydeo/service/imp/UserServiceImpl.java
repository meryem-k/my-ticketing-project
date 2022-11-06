package com.cydeo.service.imp;

import com.cydeo.dto.UserDTO;
import com.cydeo.entity.User;
import com.cydeo.mapper.UserMapper;
import com.cydeo.repository.UserRepository;
import com.cydeo.service.UserService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }


    @Override
    public List<UserDTO> listAllUsers() {
        //bring data from database to controller
        //service implementation -> repository -> mapper -> convert entity to dto

       List<User> userList = userRepository.findAll(Sort.by("firstName"));

       return userList.stream().map(userMapper::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public UserDTO findByUserName(String username) {
        return userMapper.convertToDTO(userRepository.findByUserName(username));
    }

    @Override
    public void save(UserDTO dto) {

        userRepository.save(userMapper.convertToEntity(dto));


    }

    @Override
    public UserDTO update(UserDTO dto) {

        //find current user
        User user = userRepository.findByUserName(dto.getUserName());

        //Map updated user dto to entity object
        User convertedUser = userMapper.convertToEntity(dto);

        //set id to converted object
        convertedUser.setId(user.getId());

        //save updated user to database
        userRepository.save(convertedUser);


        return findByUserName(dto.getUserName());
    }

    @Override
    public void deleteByUserName(String username) {

        userRepository.deleteUserByUserName(username);

    }

    @Override
    public void delete(String username) {
        // I will not delete from db
        //change the flag and keep in db
        User user = userRepository.findByUserName(username);
        user.setIsDeleted(true);
        userRepository.save(user);
    }


}
