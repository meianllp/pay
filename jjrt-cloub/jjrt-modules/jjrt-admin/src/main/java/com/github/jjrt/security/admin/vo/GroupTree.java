package com.github.jjrt.security.admin.vo;

import com.github.jjrt.security.common.vo.TreeNode;

/**
 * ${DESCRIPTION}
 *
 * @author jjrt
 * @create 2017-06-17 15:21
 */
public class GroupTree extends TreeNode {
    String label;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}