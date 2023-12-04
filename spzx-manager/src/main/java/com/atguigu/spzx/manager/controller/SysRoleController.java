package com.atguigu.spzx.manager.controller;

import com.atguigu.spzx.common.log.annotation.Log;
import com.atguigu.spzx.manager.service.SysRoleService;
import com.atguigu.spzx.model.dto.system.SysRoleDto;
import com.atguigu.spzx.model.entity.system.SysRole;
import com.atguigu.spzx.model.vo.common.Result;
import com.atguigu.spzx.model.vo.common.ResultCodeEnum;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(value = "/admin/system/sysRole")
public class SysRoleController {

    @Autowired
    private SysRoleService sysRoleService ;

    @PostMapping("/findByPage/{current}/{limit}")
    public Result<PageInfo<SysRole>> findByPage(@RequestBody SysRoleDto sysRoleDto ,
                                                @PathVariable(value = "current") Integer current ,
                                                @PathVariable(value = "limit") Integer limit) {
        PageInfo<SysRole> pageInfo = sysRoleService.findByPage(sysRoleDto , current , limit) ;
        return Result.build(pageInfo , ResultCodeEnum.SUCCESS) ;
    }

    @Log(title = "角色添加",businessType = 0) //添加Log注解，设置属性
    @PostMapping("/saveSysRole")
    public Result saveSysRole(@RequestBody SysRole sysRole) {
        sysRoleService.saveSysRole(sysRole);
        return Result.build(null, ResultCodeEnum.SUCCESS);
    }

    @PutMapping("/updateSysRole")
    public Result updateSysRole(@RequestBody SysRole sysRole) {
        sysRoleService.updateSysRole(sysRole);
        return Result.build(null, ResultCodeEnum.SUCCESS);
    }

    @DeleteMapping("/deleteById/{roleId}")
    public Result deleteById(@PathVariable("roleId") Long roleId) {
        sysRoleService.deleteById(roleId);
        return Result.build(null, ResultCodeEnum.SUCCESS);
    }

    @GetMapping("/findAllRoles/{roleId}")
    public Result<Map<String,Object>> findAllRoles(@PathVariable("roleId") Long  roleId) {
        Map<String,Object> resultMap = sysRoleService.findAllRoles(roleId);
        return Result.build(resultMap, ResultCodeEnum.SUCCESS);
    }


}
