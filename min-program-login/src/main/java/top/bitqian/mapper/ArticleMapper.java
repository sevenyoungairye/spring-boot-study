package top.bitqian.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import top.bitqian.entity.Article;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author echo lovely
 * @since 2020-11-30
 */
@Repository
@Mapper
public interface ArticleMapper extends BaseMapper<Article> {


    @Select("select a.*, u.user_id, u.user_name from article a " +
            "left join forum_user u on a.author_id = u.user_id" )
    @Results(
            id = "baseArticle",
            value = {
            @Result(property = "forumUser.userName", column = "user_name"),
            @Result(property = "forumUser.userId", column = "user_id")
    })
    // @ResultMap("")
    List<Article> getAllArticle(Page<Article> page);

    // 查询某个水贴的点赞数
    @Select("select count(c.comment_id) from article a right join comment c on a.article_id = c.article_id " +
            "where a.article_id = #{articleId}")
    Integer getCommentNum(@Param("articleId") Integer articleId);

    // 查询喜欢数量
    @Select("select count(lt.like_id) from article a right join like_table lt on a.article_id = lt.article_id " +
            "where a.article_id = #{articleId}")
    Integer getLikeNum(@Param("articleId") Integer articleId);

    @Select("select a.*, u.user_id, u.user_name from article a " +
            "left join forum_user u on a.author_id = u.user_id " +
            "where a.article_id = #{articleId}")
    @ResultMap("baseArticle")
    Article getArticleById(@Param("articleId") Integer articleId);
}
