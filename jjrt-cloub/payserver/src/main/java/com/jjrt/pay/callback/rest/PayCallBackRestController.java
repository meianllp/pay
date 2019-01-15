package com.jjrt.pay.callback.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jjrt.pay.feign.api.PayBankFeignClient;
import com.jjrt.pay.feign.api.PayBankFeignClient2;
import com.jjrt.pay.feign.vo.PayBankInfo;

@RestController
@RequestMapping("/hrcallback")
public class PayCallBackRestController {

	
   @Autowired
    private PayBankFeignClient userFeignClient;
   

   @Autowired
   private PayBankFeignClient2 userFeignClient2;
	
   /**
    * 开户回调
    * 
    * */
    @RequestMapping(value = "/acctOpen", produces ="application/json")
    @ResponseBody
    public List<PayBankInfo> balanceQuery(){
    	
    	
//    	List<PayBankInfo> ret = userFeignClient.list();
//    	System.out.println(ret);
//    	
//    	List<PayBankInfo> ret2 =userFeignClient2.list();
//    	System.out.println(ret2);
    	
    	List<PayBankInfo> ret2 = new ArrayList<PayBankInfo>();
    	PayBankInfo test = new PayBankInfo();
    	test.setBankCallNo("121212");
    	ret2.add(test);
    	ret2.add(test);

        return ret2;
    }
    
    /**
     * 订单支付
     * 
     * */
    @GetMapping(value = "/orderPay", produces ="application/json")
    @ResponseBody
    public List<PayBankInfo> orderPay(){
    	
    	
//    	List<PayBankInfo> ret = userFeignClient.list();
//    	System.out.println(ret);
//    	
//    	List<PayBankInfo> ret2 =userFeignClient2.list();
//    	System.out.println(ret2);
    	
    	List<PayBankInfo> ret2 = new ArrayList<PayBankInfo>();
    	PayBankInfo test = new PayBankInfo();
    	test.setBankCallNo("121212");
    	ret2.add(test);
    	ret2.add(test);

        return ret2;
    }
    
    /**
     * 退款
     * 
     * */
    @GetMapping(value = "/refundRequest", produces ="application/json")
    @ResponseBody
    public List<PayBankInfo> refundRequest(){
    	
//    	List<PayBankInfo> ret = userFeignClient.list();
//    	System.out.println(ret);
//    	
//    	List<PayBankInfo> ret2 =userFeignClient2.list();
//    	System.out.println(ret2);
    	
    	List<PayBankInfo> ret2 = new ArrayList<PayBankInfo>();
    	PayBankInfo test = new PayBankInfo();
    	test.setBankCallNo("121212");
    	ret2.add(test);
    	ret2.add(test);

        return ret2;
    }
    
    
    
}
