package com.fia.file.entity;

import com.fia.file.common.entity.DateEntity;
import lombok.Data;

/**
 * menu dto
 * @author 10268
 * @date 2021/1/14 14:53
 */
@Data
public class MenuDto extends DateEntity {

    /**
     * 菜单id
     */
    private int menuId;

    /**
     * 菜单名称
     */
    private String menuName;

    /**
     * 父菜单ID
     */
    private int parentId;

    /**
     * 显示顺序
     */
    private int seq;

    /**
     * 请求地址
     */
    private String url;

    /**
     * 菜单类型（M目录 C菜单 F按钮）
     */
    private String menuType;

    /**
     * 菜单状态（0显示 1隐藏）
     */
    private int status;

    /**
     * 权限标识
     */
    private String perms;

    /**
     * 菜单图标
     */
    private String icon;

    /**
     * 删除标志 0 正常 1删除(禁用)
     */
    private int isDelete;

    /**
     * 备注
     */
    private String remark;

}
