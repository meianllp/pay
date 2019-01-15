package com.github.jjrt.security.admin.biz;

import org.springframework.stereotype.Service;

import com.github.jjrt.security.admin.entity.GroupType;
import com.github.jjrt.security.admin.mapper.GroupTypeMapper;
import com.github.jjrt.security.common.biz.BaseBiz;
import org.springframework.transaction.annotation.Transactional;

/**
 * ${DESCRIPTION}
 *
 * @author jjrt
 * @create 2017-06-12 8:48
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class GroupTypeBiz extends BaseBiz<GroupTypeMapper,GroupType> {
}
