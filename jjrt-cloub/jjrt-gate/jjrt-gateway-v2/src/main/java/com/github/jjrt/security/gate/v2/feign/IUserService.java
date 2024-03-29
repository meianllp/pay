package com.github.jjrt.security.gate.v2.feign;

import com.github.jjrt.security.gate.v2.fallback.UserServiceFallback;
import com.github.jjrt.security.api.vo.authority.PermissionInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


/**
 * ${DESCRIPTION}
 *
 * @author jjrt
 * @create 2017-06-21 8:11
 */
@FeignClient(value = "jjrt-admin",fallback = UserServiceFallback.class)
public interface IUserService {
  @RequestMapping(value="/api/user/un/{username}/permissions",method = RequestMethod.GET)
  public List<PermissionInfo> getPermissionByUsername(@PathVariable("username") String username);
  @RequestMapping(value="/api/permissions",method = RequestMethod.GET)
  List<PermissionInfo> getAllPermissionInfo();
}
