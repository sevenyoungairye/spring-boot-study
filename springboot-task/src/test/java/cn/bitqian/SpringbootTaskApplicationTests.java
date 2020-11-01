package cn.bitqian;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.FileNotFoundException;

@SpringBootTest
class SpringbootTaskApplicationTests {

    @Autowired
    JavaMailSenderImpl mailSender;

    @Test
    void contextLoads() {

        // 一封简单的mail~
        SimpleMailMessage mailMessage = new SimpleMailMessage();

        mailMessage.setSubject("hello bitqian");
        mailMessage.setText("send a simple email using springboot.. by qq");

        mailMessage.setFrom("999999@qq.com");
        mailMessage.setTo("999999@qq.com");
        mailSender.send(mailMessage);

    }

    @Test
    void test1() throws MessagingException, FileNotFoundException {

        // 发送带有附件 的邮件
        MimeMessage mimeMessage = mailSender.createMimeMessage();

        // 发送多个附件，并设置编码
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

        // 发送图片
        helper.addAttachment("1.png", new File("C:\\Users\\Pictures\\Eibw4t2UMAEoosS.jfif"));

        // 发送音乐
        helper.addAttachment("Innocence.mp3", new File("F:\\music\\Avril Lavigne - Innocence.mp3"));

        helper.setSubject("发送了图片和音乐");
        helper.setText("springboot 邮箱发送附件测试");

        helper.setFrom("999999@qq.com");
        helper.setTo("999999@qq.com");

        mailSender.send(mimeMessage);
    }

}
