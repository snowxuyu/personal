package com.snow.personal.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.snow.personal.dao.UserDao;
import com.snow.personal.dto.UserDto;
import com.snow.personal.entity.User;
import com.snow.personal.service.UserService;
import org.framework.basic.service.impl.BaseServiceImpl;
import org.framework.basic.system.BaseResponse;
import org.framework.basic.system.ResponseEntity;
import org.framework.exception.BaseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private UserDao userDao;


    /**
     * 添加
     *
     * @param userDto
     * @return
     * @throws BaseException
     */
    public ResponseEntity createUser(UserDto userDto) throws BaseException {
        logger.debug("userService create request info:{}", JSONObject.toJSONString(userDto));
        User user = new User();
        user.setUserName(userDto.getUserName());
        user.setPassWord(userDto.getPassWord());
        user.setAddress(userDto.getAddress());
        user.setPhone(userDto.getPhone());

        userDao.insert(user);
        return BaseResponse.buildSuccess("添加成功");
    }

    /**
     * 修改
     *
     * @param userDto
     * @return
     * @throws BaseException
     */
    public ResponseEntity updateUser(UserDto userDto) throws BaseException {
        logger.debug("userService update request info:{}", JSONObject.toJSONString(userDto));

        if (userDto.getId() == null) {
            return BaseResponse.buildError("id不能为空");
        }

        User user = userDao.getById(userDto.getId());
        user.setUserName(userDto.getUserName());
        user.setPassWord(userDto.getPassWord());
        user.setAddress(userDto.getAddress());
        user.setPhone(userDto.getPhone());

        userDao.update(user);
        return BaseResponse.buildSuccess("修改成功");
    }

}
