package com.github.jjrt.security.admin.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.jjrt.security.admin.entity.User;
import com.github.jjrt.security.admin.mapper.MenuMapper;
import com.github.jjrt.security.admin.mapper.UserMapper;
import com.github.jjrt.security.auth.client.jwt.UserAuthUtil;
import com.github.jjrt.security.common.biz.BaseBiz;
import com.github.jjrt.security.common.constant.UserConstant;

/**
 * ${DESCRIPTION}
 *
 * @author jjrt
 * @create 2017-06-08 16:23
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserBiz extends BaseBiz<UserMapper,User> {

    @Autowired
    private MenuMapper menuMapper;
    @Autowired
    private UserAuthUtil userAuthUtil;
    @Override
    public void insertSelective(User entity) {
        String password = new BCryptPasswordEncoder(UserConstant.PW_ENCORDER_SALT).encode(entity.getPassword());
        entity.setPassword(password);
        super.insertSelective(entity);
    }

    @Override
    public void updateSelectiveById(User entity) {
        super.updateSelectiveById(entity);
    }

    /**
     * 根据用户名获取用户信息
     * @param username
     * @return
     */
    public User getUserByUsername(String username){
        User user = new User();
        user.setUsername(username);
        return mapper.selectOne(user);
    }


}
