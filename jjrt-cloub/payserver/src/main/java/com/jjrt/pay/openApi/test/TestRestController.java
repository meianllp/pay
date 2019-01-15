package com.jjrt.pay.openApi.test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jjrt.pay.feign.api.PayBankFeignClient;
import com.jjrt.pay.feign.api.PayBankFeignClient2;
import com.jjrt.pay.feign.vo.PayBankInfo;

@RestController
public class TestRestController {

	
   @Autowired
    private PayBankFeignClient payBankFeignClient;
   
   @Autowired
   private PayBankFeignClient2 payBankFeignClient2;
	
    @GetMapping(value = "/rest", produces ="application/json")
    @ResponseBody
    public List<PayBankInfo> rest(){
    	
    	
//    	List<PayBankInfo> ret = payBankFeignClient.list();
    	
    	List<PayBankInfo> ret2 =payBankFeignClient2.list();
    	
//    	List<PayBankInfo> ret2 = new ArrayList<PayBankInfo>();
//    	PayBankInfo test = new PayBankInfo();
//    	test.setBankCallNo("121212");
//    	ret2.add(test);
//    	ret2.add(test);

        return ret2;
    }
    
    
    @GetMapping(value = "/rest1", produces ="application/json")
    @ResponseBody
    public List<PayBankInfo> rest1(){
    	
    	
//    	List<PayBankInfo> ret = payBankFeignClient.list();
    	PayBankInfo bankinfo = new  PayBankInfo();
    	bankinfo.setBankCode("888888888888");
    	
    	List<PayBankInfo> ret2 =payBankFeignClient2.list1(bankinfo);
    	
//    	List<PayBankInfo> ret2 = new ArrayList<PayBankInfo>();
//    	PayBankInfo test = new PayBankInfo();
//    	test.setBankCallNo("121212");
//    	ret2.add(test);
//    	ret2.add(test);

        return ret2;
    }
}
