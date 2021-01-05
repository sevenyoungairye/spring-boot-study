package top.bitqian.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import top.bitqian.entity.Article;
import top.bitqian.mapper.ArticleMapper;
import top.bitqian.service.ArticleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author echo lovely
 * @since 2020-11-30
 */
@Service
@Transactional
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public List<Article> getAllArticle(Page<Article> page) {

        List<Article> articleList = articleMapper.getAllArticle(page);

        articleList.forEach(article -> {
            // System.out.println(article.getArticleId());
            Integer likeNum = articleMapper.getLikeNum(article.getArticleId());
            Integer commentNum = articleMapper.getCommentNum(article.getArticleId());

            // get ...
            article.setLikeNum(likeNum);
            article.setCommentNum(commentNum);
        });

        return articleList;
    }

    @Override
    public Integer getCommentNum(Integer articleId) {
        return articleMapper.getCommentNum(articleId);
    }

    @Override
    public Integer getLikeNum(Integer articleId) {
        return articleMapper.getLikeNum(articleId);
    }
}
