package com.fia.file.dao;

import com.fia.file.entity.MenuDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * menu dao
 * @author 10268
 * @date 2021/1/14 14:49
 */
@Mapper
public interface MenuDao {

    /**
     * add menu
     * @param menuDto  menu info
     * @return primary key
     */
    int addMenu(MenuDto menuDto);

    /**
     * delete menu
     * @param menuIdList menuId
     * @param updateUser user
     * @return int
     */
    int deleteMenu(@Param("menuIdList") List<Integer> menuIdList,@Param("updateUser")String updateUser);

    /**
     * query menu subclass
     * @param menuId  menu id
     * @return  list
     */
    List<Map<String,Object>> selectMenuList(@Param("menuId")Integer menuId);
}
