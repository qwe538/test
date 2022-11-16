package cn.wdxxxw.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Project :mp -MyHandler
 * Powered by qaz On 2022-06-16-21:57
 * Description:TODO
 *
 * @Author: li
 * @DATE: 2022/06/16
 * version:1.0
 */
@Component
public class MyHandler implements MetaObjectHandler {

    //使用mp实现添加操作，这个方法执行
    @Override
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName("createTime",new Date(),metaObject);
        this.setFieldValByName("updateTime",new Date(),metaObject);

        this.setFieldValByName("version",1,metaObject);
    }

    //使用mp实现修改操作，这个方法执行
    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("updateTime",new Date(),metaObject);
    }

}
