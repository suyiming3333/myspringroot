package com.sym.mybatisplus.model.system;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.sym.mybatisplus.common.SuperEntity;
import com.sym.mybatisplus.model.enums.TypeEnum;
import org.apache.ibatis.type.Alias;


/**
 * 系统用户表
 */
@TableName("sys_user")
@Alias("User")
public class User extends SuperEntity implements Serializable{

    /**
     * 用户名
     */
    // 这样可以注入 LIKE 查询 @TableField(condition = SqlCondition.LIKE)
    private String name;
    /**
     * 通用枚举测试
     */
    private TypeEnum type;
    /**
     * 用户年龄
     */
    @TableField(fill = FieldFill.INSERT)
    private Integer age;
    /**
     * 自定义填充的创建时间
     */
    @TableField(fill = FieldFill.INSERT) // 这样可以注入更新数据库时间 , update = "now()")// 该注解插入忽略验证，自动填充
    private Date ctime;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return this.age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public TypeEnum getType() {
        return type;
    }

    public void setType(TypeEnum type) {
        this.type = type;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }
}
