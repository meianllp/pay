package com.jjrt.pay.openApi.test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.jjrt.pay.feign.api.PayBankFeignClient;
import com.jjrt.pay.feign.api.PayBankFeignClient2;
import com.jjrt.pay.feign.vo.PayBankInfo;

@Controller
public class HomeController {

	
   @Autowired
    private PayBankFeignClient userFeignClient;
   
   @Autowired
   private PayBankFeignClient2 userFeignClient2;
	
    @GetMapping("/")
    public String home(){
    	
    	String url="http://localhost:8080/userController/findById?id=";
    	
    	List<PayBankInfo> ret = userFeignClient.list();
    	System.out.println(ret);
    	
    	List<PayBankInfo> ret2 =userFeignClient2.list();
    	System.out.println(ret2);

        return "index";
    }
}
