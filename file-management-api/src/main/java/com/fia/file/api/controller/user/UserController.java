package com.fia.file.api.controller.user;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *  用户信息相关
 * @author ggf
 * @date 2019/10/25 16:37
 */
@RestController
public class UserController {

    @RequestMapping("/getTest")
    public String getTest(){
        return "success";
    }

}
