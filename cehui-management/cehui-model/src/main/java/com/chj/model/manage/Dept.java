package com.chj.model.manage;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "t_dept")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Dept implements Serializable {
    /**
        部门ID
     */
    private Long deptId;
    /**
        上级部门ID
     */
    private Long parentId;
    /**
        部门名称
     */
    private String deptName;
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