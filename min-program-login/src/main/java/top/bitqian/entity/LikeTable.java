package top.bitqian.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
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
public class LikeTable implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "like_id", type = IdType.AUTO)
    private Integer likeId;

    private Integer articleId;

    private Integer likePersonId;

    private Date likeDate;


}
