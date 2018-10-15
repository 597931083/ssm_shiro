package com.zwk.service.permission;

import com.zwk.dao.PermissionMapper;
import com.zwk.entity.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: zwk
 * @time: 2018/10/15
 * 描述
 */
@Service
public class permissionServiceImpl implements permissionService {
    @Autowired
    private PermissionMapper permissionMapper;

    public List<String> queryPermissionByUserId(Integer userid) {
        List<Permission> permissions = permissionMapper.queryPermissionByUserId(userid);
        List<String> codes=new ArrayList<>();
        for (Permission permission : permissions) {
            codes.add(permission.getPercode());
        }
        return codes;
    }
}
