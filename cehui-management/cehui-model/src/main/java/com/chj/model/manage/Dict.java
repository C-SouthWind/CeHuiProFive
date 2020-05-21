package com.chj.model.manage;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "t_dict")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Dict implements Serializable {
    /**
        字典ID
     */
    private Long dictId;
    /**
        键
     */
    private Long keyy;
    /**
        值
     */
    private String valuee;
    /**
        字段名称
     */
    private String fieldName;
    /**
     * 表名
     */
    private String tableName;

    private static final long serialVersionUID = 1L;

}