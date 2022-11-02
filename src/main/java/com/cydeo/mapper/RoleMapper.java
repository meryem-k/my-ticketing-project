package com.cydeo.mapper;

import com.cydeo.dto.RoleDTO;
import com.cydeo.entity.Role;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class RoleMapper {

    //inject the ModelMapper to have access to its fields

    private final ModelMapper modelMapper;

    public RoleMapper(ModelMapper modelMapper){

        this.modelMapper = modelMapper;

    }

    //ConvertToEntity -> save to DB
    public Role convertToEntity(RoleDTO dto){

        return modelMapper.map(dto, Role.class);//makes the conversion

    }

    //ConverToDTO -> retrieve from DB
    public RoleDTO convertToDTO(Role entity){

        return modelMapper.map(entity, RoleDTO.class);
    }


}
