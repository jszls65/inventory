package com.zls.im.controller;

import com.zls.im.common.AjaxExceptionHandler;
import com.zls.im.domain.User;
import com.zls.im.result.CodeMsg;
import com.zls.im.result.Result;
import com.zls.im.service.user.UserService;
import com.zls.im.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 用户Controller
 * @date 2018年4月9日 23:34:29
 * @author zhangliansheng
 */
@Controller
@RequestMapping("/im/login")
public class LoginController   extends AjaxExceptionHandler {
    @Autowired
    UserService userService;

    @Autowired
    private ResponseUtil responseUtil;

    /**
     * 根据ID获取用户信息
     * 如果id不传, 默认查全部
     * @return
     */
    @RequestMapping(value = "/get/{userId}", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public String getUserInfo(@PathVariable("userId") String userId){
        Integer userIdInt = Integer.valueOf(userId);
        User user = userService.getById(userIdInt);
        return responseUtil.responseJson(ResponseUtil.ResponseCode.OK,"", user);
    }

    @RequestMapping("/db/tx")
    @ResponseBody
    public Result<Boolean> dbTx(){
        boolean re = userService.tx();
        if(re){
            return Result.success(re);
        }else{
            return Result.error(CodeMsg.SERVER_ERROR);
        }

    }



}
