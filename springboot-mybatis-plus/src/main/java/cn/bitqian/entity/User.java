package cn.bitqian.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * user table
 * @author echo lovely
 * @date 2020/11/14 10:20
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    // 主键自增 前提主键auto
    @TableId(type = IdType.AUTO)
    private Long id;
    private String name;
    private int age;
    private String email;

    // 当前版本号 用于乐观锁
    @Version
    @TableField(fill = FieldFill.INSERT)
    private int version;

    // 逻辑删除字段
    @TableLogic
    private int deleted;

    // 插入时填充字段
    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;
    // 更新或者插入时填充字段
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtModify;

}
