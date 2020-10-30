package cn.bitqian.swagger.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 给实体类生成文档
 * @author echo lovely
 * @date 2020/10/29 21:09
 */
@ApiModel("user实体类")
public class User {

    @ApiModelProperty("用户名")
    public String username;
    @ApiModelProperty("密码")
    public String password;

    public User() {}

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
