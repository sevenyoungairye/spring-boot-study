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
public class Article implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "article_id", type = IdType.AUTO)
    private Integer articleId;

    private String articleTitle;

    private String articleContent;

    private Integer authorId;

    private Date articleDate;

    // 论坛作者信息
    private ForumUser forumUser;

    private Integer commentNum;

    private Integer likeNum;

}
