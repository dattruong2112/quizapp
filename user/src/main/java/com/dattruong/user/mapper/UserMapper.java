package com.dattruong.user.mapper;

import com.dattruong.user.dto.UserDto;
import com.dattruong.user.entity.User;

public class UserMapper {
    public static UserDto mapUserToUserDto(User user){
        UserDto userDto = new UserDto();
        userDto.setId(user.getUserId());
        userDto.setEmail(user.getEmail());
        userDto.setUsername(user.getUsername());
        userDto.setLastName(user.getLastName());
        userDto.setFirstName(user.getFirstName());
        return userDto;
    }

    public static User mapUserDtoToUser(UserDto userDto) {
        User user = new User();
        user.setUserId(userDto.getId());
        user.setEmail(userDto.getEmail());
        user.setUsername(userDto.getUsername());
        user.setLastName(userDto.getLastName());
        user.setFirstName(userDto.getFirstName());
        return user;
    }
}
