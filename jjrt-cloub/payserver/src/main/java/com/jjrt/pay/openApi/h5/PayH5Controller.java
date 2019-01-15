package com.jjrt.pay.openApi.h5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jjrt.pay.config.HRProperties;
import com.jjrt.pay.feign.api.PayBankFeignClient;
import com.jjrt.pay.feign.api.PayBankFeignClient2;

@Controller
@RequestMapping("/h5")
public class PayH5Controller {

	@Autowired
	HRProperties hRProperties;
	
   @Autowired
    private PayBankFeignClient payBankFeignClient;
   
   @Autowired
   private PayBankFeignClient2 payBankFeignClient2;
	
   /**
    * 绑卡
    * 
    * */
    @RequestMapping("/acctOpen")
    public String bindCard(){
    	
    	//调用内部支付服务
    	System.out.println(hRProperties.getAppID()+":"+hRProperties.getAppSecret());

        return "huarui/acctOpen";
    }
    
    
    /**
     * 充值
     * 
     * */
     @RequestMapping("/deposits")
     public String deposits(){
     	
     	//调用内部支付服务
     	

         return "huarui/deposits";
     }
     
     
     /**
      * 取现
      * 
      * */
      @RequestMapping("/withdraw")
      public String withdraw(){
      	
      	//调用内部支付服务
      	

          return "huarui/withdraw";
      }
      


    
}
