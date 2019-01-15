package com.github.jjrt.security.admin.biz;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.jjrt.security.admin.entity.Element;
import com.github.jjrt.security.admin.mapper.ElementMapper;
import com.github.jjrt.security.common.biz.BaseBiz;

/**
 * ${DESCRIPTION}
 *
 * @author jjrt
 * @create 2017-06-23 20:27
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ElementBiz extends BaseBiz<ElementMapper,Element> {
    public List<Element> getAuthorityElementByUserId(String userId){
       return mapper.selectAuthorityElementByUserId(userId);
    }
    public List<Element> getAuthorityElementByUserId(String userId,String menuId){
        return mapper.selectAuthorityMenuElementByUserId(userId,menuId);
    }

    public List<Element> getAllElementPermissions(){
        return mapper.selectAllElementPermissions();
    }

    @Override
    public void insertSelective(Element entity) {
        super.insertSelective(entity);
    }

    @Override
    public void updateSelectiveById(Element entity) {
        super.updateSelectiveById(entity);
    }
}
