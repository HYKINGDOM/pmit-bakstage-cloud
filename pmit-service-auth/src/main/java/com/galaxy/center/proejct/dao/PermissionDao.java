package com.galaxy.center.proejct.dao;


import com.center.pmit.project.common.pojo.entity.Permission;

import java.util.List;

/**
 * 〈权限Dao〉
 *
 */
public interface PermissionDao {

    /**
     * 根据角色id查找权限列表
     * @param roleId 角色id
     * @return 权限列表
     */
    List<Permission> findByRoleId(Integer roleId);
}
