package cn.bitqian.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author echo lovely
 * @date 2020/10/25 10:11
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Users {

    private Integer userId;
    private String userName;
    private String userPassword;

}
