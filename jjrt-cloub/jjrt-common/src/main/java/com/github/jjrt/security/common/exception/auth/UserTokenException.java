package com.github.jjrt.security.common.exception.auth;


import com.github.jjrt.security.common.constant.CommonConstants;
import com.github.jjrt.security.common.exception.BaseException;

/**
 * Created by ace on 2017/9/8.
 */
public class UserTokenException extends BaseException {
    public UserTokenException(String message) {
        super(message, CommonConstants.EX_USER_INVALID_CODE);
    }
}
