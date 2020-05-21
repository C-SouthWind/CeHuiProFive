package com.chj.model.manage;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "t_menu")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Menu implements Serializable {
    /**
         菜单/按钮ID
     */
    private Long menuId;
    /**
        上级菜单ID
     */
    private Long parentId;
    /**
        菜单/按钮名称
     */
    private String menuName;
    /**
        对应路由path
     */
    private String path;
    /**
        对应路由组件component
     */
    private String component;
    /**
        权限标识
     */
    private String perms;
    /**
        图标
     */
    private String icon;
    /**
        类型 0菜单 1按钮
     */
    private String type;
    /**
        排序
     */
    private Double orderNum;
    /**
        创建时间
     */
    private String createTime;
    /**
        修改时间
     */
    private String modifyTime;

    private static final long serialVersionUID = 1L;

 }