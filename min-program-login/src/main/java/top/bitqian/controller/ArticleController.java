package top.bitqian.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import top.bitqian.entity.Article;
import top.bitqian.entity.ForumUser;
import top.bitqian.service.ArticleService;
import top.bitqian.service.ForumUserService;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author echo lovely
 * @since 2020-11-30
 */
@RestController
@RequestMapping("/bitqian/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping("/all/{pageNo}")
    public List<Article> getAllArticle(@PathVariable("pageNo") Integer pageNo) {

        Page<Article> page = new Page<>();
        page.setCurrent(pageNo);
        page.setSize(5);

        return articleService.getAllArticle(page);
    }

    @Resource
    private ForumUserService userService;

    @RequestMapping("/img/{uid}")
    public void getForumUserImg(@PathVariable("uid") Integer userId, HttpServletResponse resp) {

        ForumUser user = userService.getById(userId);

        String imgPath = user.getHeadImgPath();
        // 根据图片路径发送图片..

        if (imgPath == null)
            return;

        // 设置文件展示的类型
        resp.setContentType("image/jpeg");
        // 拿到out流
        ServletOutputStream out = null;

        // 文件读取
        FileInputStream fis = null;
        try {

            out = resp.getOutputStream();

            // 读取到文件
            fis = new FileInputStream(new File(imgPath));

            // 使用一个byte数组
            byte[] b = new byte[1024];

            // 将读取的字节装入byte数组
            int read = fis.read(b);

            while (read != -1) {
                out.write(b, 0, read);
                read = fis.read(b);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null)
                    fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (out != null) {
                    out.flush();
                    out.close();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @RequestMapping("/commentNum/{id}")
    public Integer getCommentNum(@PathVariable("id") Integer articleId) {
        return articleService.getCommentNum(articleId);
    }

    @RequestMapping("/likeNum/{id}")
    public Integer getLikeNum(@PathVariable("id") Integer articleId) {
        return articleService.getLikeNum(articleId);
    }

}

