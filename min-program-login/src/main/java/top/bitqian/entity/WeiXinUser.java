package top.bitqian.entity;

import java.util.Date;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 *  微信用户注册实体类~
 * </p>
 *
 * @author echo lovely
 * @since 2020-12-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class WeiXinUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    private Integer id;

    private String userName;

    private String userPwd;

    private Date createDate;

    private String wxOpenId;


}
