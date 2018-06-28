
package com.student.crm.service.impl;

import com.student.crm.domain.Employee;
import com.student.crm.domain.SystemMenu;
import com.student.crm.mapper.SystemMenuMapper;
import com.student.crm.page.PageResult;
import com.student.crm.query.QueryObject;
import com.student.crm.service.ISystemMenuService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
@Service
public class SystemMenuServiceImpl implements ISystemMenuService {
    @Autowired
    private SystemMenuMapper systemMenuMapper;

    public int deleteByPrimaryKey(Long id) {
        return systemMenuMapper.deleteByPrimaryKey(id);
    }

    public int insert(SystemMenu record) {
        return systemMenuMapper.insert(record);
    }

    public SystemMenu selectByPrimaryKey(Long id) {
        return systemMenuMapper.selectByPrimaryKey(id);
    }

    public List<SystemMenu> selectAll() {
        return systemMenuMapper.selectAll();
    }

    public int updateByPrimaryKey(SystemMenu record) {
        return systemMenuMapper.updateByPrimaryKey(record);
    }

    @Override
    public PageResult queryPage(QueryObject qo) {
        Long count = systemMenuMapper.queryPageCount(qo);
        if(count<=0){
            return new PageResult(0L, Collections.EMPTY_LIST);
        }
        List<SystemMenu> result = systemMenuMapper.queryPageDataResult(qo);
        PageResult pageResult = new PageResult(count,result);
        return pageResult;
    }

    @Override
    public List<SystemMenu> queryTree() {
        return systemMenuMapper.queryTree();
    }

    @Override
    public List<SystemMenu> queryForRole() {
        return systemMenuMapper.queryTree();
    }

    @Override
    public List<Long> queryMenuIdsListForRole(Long roleId) {
        return systemMenuMapper.systemMenuMapper(roleId);
    }

    @Override
    public List<SystemMenu> indexMenu() {
	    /*判断是否是管理员是的话集直接获取所有*/
        Employee current  = (Employee) SecurityUtils.getSubject().getPrincipal();
        List<SystemMenu> systemMenus = systemMenuMapper.queryTree();
        if (current.isAdmin()) {
            return systemMenus;
        }
        // 不是的话就需要就需要查询到所有当前的员工所拥有的id集合
        List<Long> ids = systemMenuMapper.queryMenuIdByEmpId(current.getId());

        // 去重复的菜单
        filterMenu(systemMenus,ids);

        return systemMenuMapper.queryTree();
    }

    private void filterMenu(List<SystemMenu> systemMenus, List<Long> ids) {
        // 遍历集合
        SystemMenu menu = null;
        for (int i = systemMenus.size() - 1 ; i >=0 ; i --) {
            menu = systemMenus.get(i);
            if (!ids.contains(menu.getId())) {
                // 把当前的对象的元素删除
                systemMenus.remove(menu);
                continue;

            } else {
                if (menu != null && menu.getChildren().size() > 0) {
                    filterMenu(menu.getChildren(),ids);
                }
            }
        }


    }
}
