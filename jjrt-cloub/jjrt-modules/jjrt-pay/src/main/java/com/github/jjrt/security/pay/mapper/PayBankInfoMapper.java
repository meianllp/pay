package com.github.jjrt.security.pay.mapper;

import java.util.List;

import com.github.jjrt.security.pay.vo.PayBankInfo;

public interface PayBankInfoMapper {
    int deleteByPrimaryKey(String bankCode);

    int insert(PayBankInfo record);

    int insertSelective(PayBankInfo record);

    PayBankInfo selectByPrimaryKey(String bankCode);

    int updateByPrimaryKeySelective(PayBankInfo record);

    int updateByPrimaryKey(PayBankInfo record);
    
    List<PayBankInfo>  selectAll();
}