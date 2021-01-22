package com.fia.file.api.controller.menu;

import com.fia.file.common.ResponseEntity;
import com.fia.file.common.ResponseUtil;
import com.fia.file.common.api.ApiUrls;
import com.fia.file.common.api.MenuApiUrls;
import com.fia.file.entity.MenuDto;
import com.fia.file.service.MenuServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 菜单相关
 */
@RestController
@RequestMapping(ApiUrls.API)
public class MenuController {

    @Autowired
    MenuServer menuServer;

    @PostMapping(MenuApiUrls.MENU_MANAGER_CREATE_MENU)
    public ResponseEntity createMenu(@RequestBody MenuDto menuDto){
        return ResponseUtil.successResponse(menuServer.createMenu(menuDto));
    }

    @DeleteMapping(MenuApiUrls.MENU_MANAGER_DELETE_MENU)
    public ResponseEntity deleteMenu(@RequestParam("menuIdList") List<Integer> menuIdList,@RequestParam("updateUser")String updateUser){
        return ResponseUtil.successResponse(menuServer.deleteMenu(menuIdList,updateUser));
    }

    @GetMapping(MenuApiUrls.MENU_MANAGER_QUERY_MENU_List)
    public ResponseEntity queryMenuSub(@RequestParam(value = "menuIdList" ,required = false)List<Integer> menuIdList){
        return ResponseUtil.successResponse(menuServer.queryMenuList(menuIdList));
    }
}
