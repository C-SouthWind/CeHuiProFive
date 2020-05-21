package com.chj.base;


import com.chj.utils.Map2BeanUtils;
import com.chj.utils.SpringContextUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.bouncycastle.asn1.cms.OtherRecipientInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.Sqls;


import java.lang.reflect.ParameterizedType;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author ：chj
 * @date ：Created in 2020/5/11 18:13
 * @params :
 */
public abstract class BaseService<T> {

    private Class<T> cache = null;

    @Autowired
    private Mapper<T> mapper;
    /** 方法描述 
    * @Description: 使子类可以继承写自己的方法
    * @Param: []
    * @return: tk.mybatis.mapper.common.Mapper
    * @Author: chj
    * @Date: 2020/5/11
    */
    protected Mapper getMapper(){
        return mapper;
    }

    /** 方法描述
    * @Description: 新增
     *              保存一个实体，null的属性不会保存，会使用数据库默认值
    * @Param: [t]
    * @return: java.lang.Integer
    * @Author: chj
    * @Date: 2020/5/11
    */
    public Integer add(T t) throws Exception{
        return mapper.insertSelective(t);
    }
    
    /** 方法描述 
    * @Description:   通过主键删除
     *          根据主键字段进行删除，方法参数必须包含完整的主键属性
    * @Param: [t]
    * @return: java.lang.Integer
    * @Author: chj
    * @Date: 2020/5/11
    */
    public Integer delete(T t) throws Exception{
        return mapper.deleteByPrimaryKey(t);
    }
    
    /** 方法描述 
    * @Description: 获取子类泛型类型
    * @Param: []
    * @return: java.lang.Class<T>
    * @Author: chj
    * @Date: 2020/5/11
    */
    private Class<T> getTypeArguement(){
        if (null == cache) {
            //getGenericSuperclass() 获取父类类型     getActualTypeArguments()[0]  此类型实际类型参数的 Type 对象的数组 取第一个
            cache = (Class<T>) ((ParameterizedType) (this.getClass().getGenericSuperclass())).getActualTypeArguments()[0];
        }
        return cache;
    }

    /** 方法描述 
    * @Description: 通过主键批量删除
     *              deleteByExample(example)  根据Example条件删除数据
     *              Example.builder(getTypeArguement())
     *              .where(xx)
     *              Sqls.custom()
     *              .andIn("id",ids)
     *              .build
    * @Param: [ids]
    * @return: java.lang.Integer
    * @Author: chj
    * @Date: 2020/5/11
    */
    public Integer delete(List<Object> ids) throws Exception{
        Example example = Example.builder(getTypeArguement()).where(Sqls.custom().andIn("id", ids)).build();
        return mapper.deleteByExample(example);
    }

    /** 方法描述
    * @Description:  更新功能
     *              根据主键更新属性不为null的值
    * @Param: [t]
    * @return: java.lang.Integer
    * @Author: chj
    * @Date: 2020/5/11
    */
    public Integer update(T t) throws Exception{
        return mapper.updateByPrimaryKeySelective(t);
    }

    /** 方法描述 
    * @Description: 批量更新
    * @Param: [t, ids]
    * @return: java.lang.Integer
    * @Author: chj
    * @Date: 2020/5/11
    */
    public Integer batchUpdate(T t,Object[] ids) throws Exception{
       Example example =  Example.builder(getTypeArguement()).where(Sqls.custom().andIn("id", Arrays.asList(ids))).build();
        return mapper.updateByExample(t,example);
    }

    /** 方法描述
    * @Description:  查询一条数据
    *      根据实体中的属性进行查询，只能有一个返回值
    * @Param: [t]
    * @return: T
    * @Author: chj
    * @Date: 2020/5/11
    */
    public T queryOne(T t)throws Exception{
        return mapper.selectOne(t);
    }

    public List<T> selectAll(){
        return mapper.selectAll();
    }

    /** 方法描述
    * @Description:
     *          封装条件查询，分页查询以及排序查询的通用方法(多条件查询)
     *
     *         selectByExample(example)  根据Example条件进行查询
    * @Param: [pageNo, pageSize, where, orderByField, field]
    * @return: java.util.List<T>
    * @Author: chj
    * @Date: 2020/5/11
    */
    private List<T> queryByFieldsBase(Integer pageNo,Integer pageSize,Sqls where ,String orderByField,String... field){
        Example.Builder builder = null;
        if (null == field || field.length==0) {
            //没有条件查询 说明查询的是所有数据
            builder = Example.builder(getTypeArguement());
        }else {
            //指定某个字段查询
            builder = Example.builder(getTypeArguement()).select(field);
        }
        if (null != orderByField) {
            builder = builder.orderByDesc(orderByField);
        }
        Example example = builder.build();

        if (null != pageNo && null != pageSize) {
            PageHelper.startPage(pageNo,pageSize);
        }
        List list = getMapper().selectByExample(example);
        return list;
    }
    
    /** 方法描述 
    * @Description:  通过指定字段查询一条数据
    * @Param: [where, orderByField, fields]
    * @return: T
    * @Author: chj
    * @Date: 2020/5/11
    */
    public T queryByField(Sqls where , String orderByField,String... fields) throws Exception{
        return queryByFieldsBase(null,null,where,orderByField,fields).get(0);
    }
    
    /** 方法描述 
    * @Description: 条件查询集合
    * @Param: [where, orderByField, fields]
    * @return: java.util.List<T>
    * @Author: chj
    * @Date: 2020/5/11
    */
    public List<T> queryListByFields(Sqls where ,String orderByField, String... fields) throws Exception{
        return queryByFieldsBase(null,null,where,orderByField,fields);
    }
    
    /** 方法描述 
    * @Description: 条件查询分页
    * @Param: [pageNo, pageSize, where, orderByFileds, fields]
    * @return: com.github.pagehelper.PageInfo<T>
    * @Author: chj
    * @Date: 2020/5/11
    */
    public PageInfo<T> queryListByPageAndFields(Integer pageNo,Integer pageSize,Sqls where,String orderByFileds,String... fields) throws Exception{
        return new PageInfo<T>(queryByFieldsBase(pageNo,pageSize,where,orderByFileds,fields));
    }

    /** 方法描述
    * @Description: 条件查询
    * @Param: [t]
    * @return: java.util.List<T>
    * @Author: chj
    * @Date: 2020/5/11
    */
    public List<T> queryList(T t) throws Exception{
        return mapper.select(t);
    }

    /** 方法描述 
    * @Description: 分页查询
    * @Param: [t, pageNo, pageSize]
    * @return: com.github.pagehelper.PageInfo<T>
    * @Author: chj
    * @Date: 2020/5/11
    */
    public PageInfo<T> queryListByPage(T t ,Integer pageNo , Integer pageSize) throws Exception{
        PageHelper.startPage(pageNo,pageSize);
        List<T> select = mapper.select(t);
        PageInfo<T> pageInfo = new PageInfo<T>(select);
        return pageInfo;
    }

    /** 方法描述
    * @Description: 获取Spring容器
    * @Param: []
    * @return: org.springframework.context.ApplicationContext
    * @Author: chj
    * @Date: 2020/5/12
    */
    private ApplicationContext getApplicationContext(){
        return SpringContextUtils.getApplicationContext();
    }
    
    /** 方法描述 
    * @Description:
     *          根据反射获取实例对象
    * @Param: [map]
    * @return: T
    * @Author: chj
    * @Date: 2020/5/12
    */
    public T newInstance(Map map){
        return (T) Map2BeanUtils.map2Bean(map,getTypeArguement());
    }
}

