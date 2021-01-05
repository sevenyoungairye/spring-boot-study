package top.bitqian.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author echo lovely
 * @since 2020-11-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ForumUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "user_id", type = IdType.AUTO)
    private Integer userId;

    private String userName;

    private String userPwd;

    private String headImgPath;

    private String weiXinOpenId;


}
