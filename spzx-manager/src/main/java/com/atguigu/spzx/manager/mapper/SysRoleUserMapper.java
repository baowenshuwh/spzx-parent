package com.atguigu.spzx.manager.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysRoleUserMapper  {
    List<Long> selectRoleIdsByUserId(Long roleId);

    void doAssign(Long userId, Long roleId);

    void deleteByUserId(Long userId);
}
