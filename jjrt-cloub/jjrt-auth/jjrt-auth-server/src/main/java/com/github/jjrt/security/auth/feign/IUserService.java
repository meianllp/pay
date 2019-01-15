package com.github.jjrt.security.auth.feign;

import com.github.jjrt.security.api.vo.user.UserInfo;
import com.github.jjrt.security.auth.configuration.FeignConfiguration;
import com.github.jjrt.security.auth.util.user.JwtAuthenticationRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * ${DESCRIPTION}
 *
 * @author jjrt
 * @create 2017-06-21 8:11
 */
@FeignClient(value = "jjrt-admin",configuration = FeignConfiguration.class)
public interface IUserService {
  @RequestMapping(value = "/api/user/validate", method = RequestMethod.POST)
  public UserInfo validate(@RequestBody JwtAuthenticationRequest authenticationRequest);
}
