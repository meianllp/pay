package com.jjrt.pay.feign.api;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.jjrt.pay.feign.vo.PayBankInfo;

@FeignClient(name="jjrt-gateway-v2")
public interface PayBankFeignClient2 {
    
    @GetMapping("/api/pay/payment/list")
    public List<PayBankInfo> list();
    
    
    @PostMapping("/api/pay/payment/list1")
    public List<PayBankInfo> list1(PayBankInfo bankinfo);
}