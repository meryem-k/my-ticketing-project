package com.cydeo.converter;


import com.cydeo.dto.UserDTO;
import com.cydeo.service.UserService;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@ConfigurationPropertiesBinding
public class UserDtoConverter implements Converter<String, UserDTO> {

    //Converter is needed because we get string from  UI and needed to convert to object

    //example
    //User list table when we click update and change the role object to another role and click save whatever coming from UI comes as string so it was returning a string instead of a role object
    // therefore when saving there was an exception thrown. To prevent this we created the converter class which will ocnver the role string value to object in order to save it as a role object. We needed to parse string as a role object


    UserService userService;


    public UserDtoConverter(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDTO convert(String source) {
        return userService.findByUserName(source);
    }
}
