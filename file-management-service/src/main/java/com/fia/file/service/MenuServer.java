package com.fia.file.service;

import com.fia.file.entity.MenuDto;

import java.util.List;
import java.util.Map;

public interface MenuServer {

    /**
     * create menu
     * @param menuDto menu
     * @return int
     */
    int createMenu(MenuDto menuDto);

    /**
     * delete menu
     * @param menuIdList menuId
     * @param updateUser user
     * @return int
     */
    int deleteMenu(List<Integer> menuIdList,String updateUser);

    /**
     * query menu list
     * @param menuIdList list menu id
     * @return list
     */
    List<Map<String,Object>> queryMenuList(List<Integer> menuIdList);
}
