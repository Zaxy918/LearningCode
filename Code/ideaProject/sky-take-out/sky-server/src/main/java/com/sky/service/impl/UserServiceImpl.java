package com.sky.service.impl;

import com.alibaba.fastjson.JSON;
import com.sky.constant.MessageConstant;
import com.sky.dto.UserLoginDTO;
import com.sky.entity.User;
import com.sky.mapper.UserMapper;
import com.sky.properties.WeChatProperties;
import com.sky.service.UserService;
import com.sky.utils.HttpClientUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.security.auth.login.LoginException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private static final String WX_LOGIN_URL = "https://api.weixin.qq.com/sns/jscode2session";

    @Autowired
    WeChatProperties weChatProperties;
    @Autowired
    UserMapper userMapper;

    @Override
    public User wxLogin(UserLoginDTO userLoginDTO) throws LoginException {
        // Get openid from WeChat using the provided code
        String openId = getOpenId(userLoginDTO.getCode());
        // Validate the openid
        if (openId == null) {
            log.error("Failed to get openid from WeChat");
            throw new LoginException(MessageConstant.LOGIN_FAILED);
        }
        // Check if user exists in the database
        User user = userMapper.getByOpenid(openId);
        if (user == null) {
            // If user does not exist, create a new user
            // The other user information can't be obtained at this stage
            user = User.builder()
                    .createTime(LocalDateTime.now())
                    .openid(openId)
                    .build();
            userMapper.insert(user);
        }
        return user;
    }

    private String getOpenId(String code) {
        Map<String, String> params = new HashMap<>();
        params.put("appid", weChatProperties.getAppid());
        params.put("secret", weChatProperties.getSecret());
        params.put("js_code", code);
        params.put("grant_type", "authorization_code");
        String json = HttpClientUtil.doGet(WX_LOGIN_URL, params);
        return JSON.parseObject(json).get("openid").toString();
    }
}
