package com.rongmu.applets.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName LoginController
 * @Author XingZhiTian
 * @Date 2021/1/8
 **/
@Api(tags = "用户信息")
@RestController
@RequestMapping("/loggin")
public class LoginController {
    @ApiOperation("登录接口")
   @PostMapping("/logg")
    public JSONObject loggin(JSONObject param){
        return null;
    }
}
