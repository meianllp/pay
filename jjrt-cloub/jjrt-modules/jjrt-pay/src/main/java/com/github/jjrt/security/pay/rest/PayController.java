package com.github.jjrt.security.pay.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.jjrt.security.auth.client.annotation.IgnoreUserToken;
import com.github.jjrt.security.pay.biz.PayBankInfoBiz;
import com.github.jjrt.security.pay.vo.PayBankInfo;

import io.swagger.annotations.Api;

/**
 * ${DESCRIPTION}
 *
 * @author jjrt
 * @create 2017-06-12 8:49
 */
@Controller
@IgnoreUserToken
@RequestMapping("payment")
@Api("支付模块")
public class PayController{
    
	@Autowired
    private PayBankInfoBiz payBankInfoBiz;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public List<PayBankInfo> list() {
//        if(StringUtils.isBlank(name)&&StringUtils.isBlank(groupType)) {
//            return new ArrayList<PayBankInfo>();
//        }
        
        

        return payBankInfoBiz.queryAllBankInfo();
    }
    
    @RequestMapping(value = "/list1", method = RequestMethod.POST, consumes="application/json")
    @ResponseBody
    public List<PayBankInfo> list(@RequestBody PayBankInfo info) {
//        if(StringUtils.isBlank(name)&&StringUtils.isBlank(groupType)) {
//            return new ArrayList<PayBankInfo>();
//        }
    	List<PayBankInfo> info1 = new ArrayList<PayBankInfo>();
    	info1.add(info);

        return info1;
    }
    
    
   



}
