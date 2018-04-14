package com.zls.im.controller;

import com.zls.im.common.AjaxExceptionHandler;
import com.zls.im.common.exception.WrongParameterException;
import com.zls.im.model.User;
import com.zls.im.service.LoginService;
import com.zls.im.util.MD5Utils;
import com.zls.im.util.ResponseUtil;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;

/**
 * 用户Controller
 *
 * @author zhangliansheng
 * @date 2018年4月9日 23:34:29
 */
@RestController
@RequestMapping("/im/login")
public class LoginController extends AjaxExceptionHandler {
    @Autowired
    LoginService loginService;

    @Autowired
    private ResponseUtil responseUtil;
    @Autowired
    private MD5Utils md5Utils;


    private static final Logger logger = Logger.getLogger(LoginController.class);


    /**
     * 登录
     *
     * @param request
     * @param response
     * @return
     * @throws WrongParameterException
     * @throws ParseException
     * @author john listen
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = {"text/javascript;charset=UTF-8"})
    public String doLogin(HttpServletRequest request, HttpServletResponse response)
            throws WrongParameterException, ParseException {
        request.getSession().removeAttribute("user");
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        String remember = request.getParameter("remember");
        if (StringUtils.isBlank(userName) || StringUtils.isBlank(password)) {
            throw new WrongParameterException("用户名密码不能为空");
        }
        String pwdMd5 = md5Utils.encode(password);


        User userInfo = loginService.getUserLogin(userName, pwdMd5);


        ServletContext sc = request.getServletContext();
        if (userInfo != null) {
            JSONObject user = new JSONObject();
            user.put("username", userName);

            request.getSession().setAttribute("user", user);
            if ("true".equalsIgnoreCase(remember)) {
                Cookie userCookie = new Cookie("username", userName);
                Cookie passwordCookie = new Cookie("password", password);
                userCookie.setMaxAge(7 * 24 * 60 * 60 * 1000);
                passwordCookie.setMaxAge(7 * 24 * 60 * 60 * 1000);
                response.addCookie(userCookie);
                response.addCookie(passwordCookie);
            }
        } else {
            return responseUtil.responseJson(ResponseUtil.ResponseCode.WRONG_PASSWORD, "账号或密码错误");
        }
        logger.info("------用户" + userName + "登录成功------");
        return responseUtil.responseJson(ResponseUtil.ResponseCode.OK);
    }

    /**
     * 登出
     *
     * @param request
     * @param response
     * @return
     * @Description
     * @author zhaoht
     */
    @RequestMapping(value = "/logout", method = RequestMethod.POST, produces = {"text/javascript;charset=UTF-8"})
    public String doLogot(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().removeAttribute("user");
        logger.info("------用户退出登录------");
        return responseUtil.responseJson(ResponseUtil.ResponseCode.OK);
    }

}
