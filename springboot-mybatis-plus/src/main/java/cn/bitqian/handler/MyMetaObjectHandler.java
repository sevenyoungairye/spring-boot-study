package cn.bitqian.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 字段自动填充
 * @author echo lovely
 * @date 2020/11/14 11:49
 */

@Component
@Slf4j // lombok
public class MyMetaObjectHandler implements MetaObjectHandler {
    // 插入时填充
    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("新增，gmtCreate,gmtModify字段日期自动填充...");

        // 两个字段在 插入时填充
        this.setFieldValByName("gmtCreate", new Date(), metaObject);
        this.setFieldValByName("gmtModify", new Date(), metaObject);

        this.setFieldValByName("version", 0, metaObject);
    }

    // 修改时填充
    @Override
    public void updateFill(MetaObject metaObject) {
        log.debug("修改，gmtModify日期自动填充更新...");

        // 在修改时填充
        this.setFieldValByName("gmtModify", new Date(), metaObject);

        // this.setFieldValByName("version", 1, metaObject);
    }
}
