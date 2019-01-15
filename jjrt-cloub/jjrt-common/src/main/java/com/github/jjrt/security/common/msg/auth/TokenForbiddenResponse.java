package com.github.jjrt.security.common.msg.auth;

import com.github.jjrt.security.common.constant.RestCodeConstants;
import com.github.jjrt.security.common.msg.BaseResponse;

/**
 * Created by ace on 2017/8/25.
 */
public class TokenForbiddenResponse  extends BaseResponse {
    public TokenForbiddenResponse(String message) {
        super(RestCodeConstants.TOKEN_FORBIDDEN_CODE, message);
    }
}
