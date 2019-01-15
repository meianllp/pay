package com.jjrt.pay.feign.api;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.jjrt.pay.feign.vo.PayBankInfo;

@FeignClient(name="jjrt-pay")
public interface PayBankFeignClient {
    
    @GetMapping("/payment/list")
    public List<PayBankInfo> list();
    
}