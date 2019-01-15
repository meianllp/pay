package com.github.jjrt.security.pay.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.jjrt.security.pay.mapper.PayBankInfoMapper;
import com.github.jjrt.security.pay.vo.PayBankInfo;

/**
 * ${DESCRIPTION}
 *
 * @author jjrt
 * @create 2017-06-23 20:27
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class PayBankInfoBiz {
	
	@Autowired
	PayBankInfoMapper payBankInfoMapper;

	/**
	 * 
	 * 查询所有的银行列表
	 * 
	 * @return 银行列表
	 */
	public List<PayBankInfo> queryAllBankInfo(){
		
		return payBankInfoMapper.selectAll();
	}
}