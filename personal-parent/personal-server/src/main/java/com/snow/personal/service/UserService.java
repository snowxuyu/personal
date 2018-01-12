package com.snow.personal.service;

import com.snow.personal.dto.UserDto;
import com.snow.personal.entity.User;
import org.framework.basic.service.BaseService;
import org.framework.basic.system.ResponseEntity;
import org.framework.exception.BaseException;


public interface UserService extends BaseService<User> {

    ResponseEntity createUser(UserDto userDto) throws BaseException;

    ResponseEntity updateUser(UserDto userDto) throws BaseException;
}
