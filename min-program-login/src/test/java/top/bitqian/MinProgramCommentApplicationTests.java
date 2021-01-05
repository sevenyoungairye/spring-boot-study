package top.bitqian;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.bitqian.entity.Article;
import top.bitqian.mapper.ArticleMapper;
import top.bitqian.service.WeiXinUserService;

@SpringBootTest
class MinProgramCommentApplicationTests {

    @Autowired
    private ArticleMapper articleMapper;

    @Test
    void contextLoads() {

        Page<Article> page = new Page<>();
        page.setCurrent(1L);
        page.setSize(2);

        articleMapper.getAllArticle(page).forEach(System.out::println);
        // System.out.println(articleMapper);

        //articleMapper.selectList(null).forEach(System.out::println);
    }

    @Test
    void test1() {
        System.out.println(articleMapper.getCommentNum(1));

        System.out.println(articleMapper.getLikeNum(1));
    }

    @Test
    void test2() {
        System.out.println(articleMapper.getArticleById(1));
    }

    @Autowired
    private WeiXinUserService weiXinUserService;

    @Test
    void test3() {
        System.out.println(weiXinUserService.getWinXinJson("test"));
    }

    @Test
    void  test4() {
        System.out.println(weiXinUserService.getWeiXinUserByOpenId("abc"));
    }

}
