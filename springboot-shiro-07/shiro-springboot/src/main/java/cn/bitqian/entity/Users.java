package cn.bitqian.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用于用户验证
 * @author echo lovely
 * @date 2020/10/27 21:59
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Users {

    private Integer userId;
    private String userName;
    private String userPassword;

    private String permission;

}
