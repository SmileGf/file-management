package com.fia.file.service.impl;

import com.fia.file.dao.MenuDao;
import com.fia.file.entity.MenuDto;
import com.fia.file.service.MenuServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MenuServerImpl implements MenuServer {

    @Autowired
    MenuDao menuDao;

    @Override
    public int createMenu(MenuDto menuDto) {
        return menuDao.addMenu(menuDto);
    }

    @Override
    public int deleteMenu(List<Integer> menuIdList,String updateUser) {
        return menuDao.deleteMenu(menuIdList, updateUser);
    }

    @Override
    public List<Map<String,Object>> queryMenuList(List<Integer> menuIdList) {
        if(null !=menuIdList && menuIdList.size() > 0){
            for(Integer menuId : menuIdList){
                return menuDao.selectMenuList(menuId);
            }
        }
        return menuDao.selectMenuList(null);
    }
}
