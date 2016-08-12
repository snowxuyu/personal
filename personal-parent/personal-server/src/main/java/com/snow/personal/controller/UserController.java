package com.snow.personal.controller;

import com.alibaba.fastjson.JSONObject;
import com.snow.personal.entity.User;
import com.snow.personal.service.UserService;
import org.framework.basic.system.BaseException;
import org.framework.basic.system.BaseResponse;
import org.framework.basic.system.ResponseEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by gaoguoxiang on 2016/3/4.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Resource
    private UserService userService;


    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity create(User user) {
        logger.debug("[personal-server] userController create request info:{}", JSONObject.toJSONString(user));
        try {
            System.out.println(userService);
            userService.insert(user);
            return BaseResponse.buildSuccess("用户添加成功");
        } catch (BaseException e) {
            logger.debug(e.getMessage());
            return BaseResponse.buildError(e.getMessage(), "用户添加失败");
        }

    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test(Model model) {
        model.addAttribute("name", "springmvc");
        return "index";
    }
}
