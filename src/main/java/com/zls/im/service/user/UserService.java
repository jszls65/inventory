package com.zls.im.service.user;

import com.zls.im.dao.UserDao;
import com.zls.im.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户信息
 * @date 2018年4月9日 23:36:51
 * @author zhangliansheng
 */
@Service
public class UserService {
    @Autowired
    UserDao userDao;


    public User getById(Integer id){
        return userDao.getById(id);
    }

    /**
     * 测试事务
     * 一个方法执行2步操作，第二步失败时，确保第一步不能生效。
     * @return
     */
    //@Transactional
    public boolean tx(){

        User u1 = new User();
        u1.setId(2);
        u1.setName("2222222");
        userDao.insert(u1);

        User u2 = new User();
        u2.setId(1);
        u2.setName("11111");
        userDao.insert(u2);

        return  true;
    }
}
