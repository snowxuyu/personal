package com.snow.personal.controller;

import com.alibaba.fastjson.JSONObject;
import com.snow.personal.dto.UserDto;
import com.snow.personal.entity.User;
import com.snow.personal.service.UserService;
import org.framework.basic.system.BaseResponse;
import org.framework.basic.system.ResponseEntity;
import org.framework.exception.BaseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private UserService userService;

    /**
     * 添加
     *
     * @param userDto
     * @return
     */
    @RequestMapping(value = "/createUser", method = RequestMethod.POST)
    public ResponseEntity createUser(UserDto userDto) {
        logger.debug("userController create request info:{}", JSONObject.toJSONString(userDto));
        try {
            ResponseEntity resp = userService.createUser(userDto);
            return resp;
        } catch (BaseException e) {
            logger.debug(e.getMessage());
            return BaseResponse.buildError(e.getMessage(), "添加失败");
        }

    }


    /**
     * 修改
     *
     * @param userDto
     * @return
     */
    @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
    public ResponseEntity updateUser(UserDto userDto) {
        logger.debug("userController update request info:{}", JSONObject.toJSONString(userDto));
        try {
            ResponseEntity resp = userService.updateUser(userDto);
            return resp;
        } catch (BaseException e) {
            logger.debug(e.getMessage());
            return BaseResponse.buildError(e.getMessage(), "修改失败");
        }

    }


    /**
     * 删除
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/deleteUserById", method = RequestMethod.POST)
    public ResponseEntity deleteUserById(Long id) {
        logger.debug("userController deleteById request info:{}", id);
        try {
            userService.deleteById(id);
            return BaseResponse.buildSuccess("删除成功");
        } catch (BaseException e) {
            logger.debug(e.getMessage());
            return BaseResponse.buildError(e.getMessage(), "删除失败");
        }

    }


    /**
     * 查询
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "/queryUserByParams", method = RequestMethod.POST)
    public ResponseEntity queryUserByParams(User user) {
        logger.debug("userController queryUserByParams request info:{}", JSONObject.toJSONString(user));
        try {
            List<User> userList = userService.getByObj(user);
            return BaseResponse.buildSuccess(userList, "查询成功");
        } catch (BaseException e) {
            logger.debug(e.getMessage());
            return BaseResponse.buildError(e.getMessage(), "查询失败");
        }

    }


}
