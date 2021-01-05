package top.bitqian.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import top.bitqian.entity.Article;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author echo lovely
 * @since 2020-11-30
 */
public interface ArticleService extends IService<Article> {
    List<Article> getAllArticle(Page<Article> page);

    Integer getCommentNum(Integer articleId);

    Integer getLikeNum(Integer articleId);

}
