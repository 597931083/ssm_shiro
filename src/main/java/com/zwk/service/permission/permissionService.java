package com.zwk.service.permission;

import com.zwk.entity.Permission;

import java.util.List;

/**
 * @author: zwk
 * @time: 2018/10/15
 * 描述
 */
public interface permissionService {
    /**
     * 根据用户id查询权限code集合
     */
    List<String> queryPermissionByUserId(Integer userid);
}
