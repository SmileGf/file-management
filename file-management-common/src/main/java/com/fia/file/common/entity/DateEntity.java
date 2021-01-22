package com.fia.file.common.entity;

import lombok.Data;

import java.util.Date;

@Data
public class DateEntity {

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 创建人
     */
    private String createUser;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 更新人
     */
    private String updateUser;
}
