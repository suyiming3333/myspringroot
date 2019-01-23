package com.sym.mybatisplus.common;

import java.util.Date;

import org.apache.ibatis.reflection.MetaObject;

import com.baomidou.mybatisplus.mapper.MetaObjectHandler;

/**
 * 自定义填充处理器
 */
public class MyMetaObjectHandler extends MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
//        this.setFieldValByName("ctime", new Date(), metaObject);
        Object age = metaObject.getValue("age");
        if(age == null){
            //如果不手动设置默认值，age为18
            //metaObject.setValue("age",18);
            setFieldValByName("age", 18, metaObject);
        }
        setFieldValByName("ctime", new Date(), metaObject);
    }

    @Override
    public boolean openUpdateFill() {
        return false;
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        // 关闭更新填充、这里不执行
    }
}
