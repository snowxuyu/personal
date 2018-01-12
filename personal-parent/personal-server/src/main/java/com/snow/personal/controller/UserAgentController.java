package com.snow.personal.controller;

import eu.bitwalker.useragentutils.Browser;
import eu.bitwalker.useragentutils.OperatingSystem;
import eu.bitwalker.useragentutils.UserAgent;
import eu.bitwalker.useragentutils.Version;
import org.framework.basic.system.BaseResponse;
import org.framework.basic.system.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * date: 2018-1-12 21:29
 * author: snowxuyu
 * describe:
 */
@RestController
@RequestMapping(value = "/useragent")
public class UserAgentController {

    @RequestMapping(value = "/test")
    public ResponseEntity test(HttpServletRequest request) {
        String header = request.getHeader("User-Agent");
        UserAgent userAgent = UserAgent.parseUserAgentString(header);
        Browser browser = userAgent.getBrowser();
        Version browserVersion = userAgent.getBrowserVersion();
        OperatingSystem operatingSystem = userAgent.getOperatingSystem();

        System.out.println("浏览器:" + browser.getName());
        System.out.println("浏览器版本号:" + browserVersion.getVersion());
        System.out.println("操作系统:" + operatingSystem.getName());
        return BaseResponse.buildSuccess();
    }
}
