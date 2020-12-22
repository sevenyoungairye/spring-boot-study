package cn.bitqian;

import cn.bitqian.entity.User;
import cn.bitqian.mapper.UserMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author echo lovely
 * @date 2020/11/17 08:19
 */

@SpringBootTest
public class WrapperDemo {


    @Autowired
    private UserMapper userMapper;

    // 测试普通的条件查询
    @Test
    void test1() {

        // 条件构造器
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        // 查询name为jack的人 并且年龄大于等于3岁
        queryWrapper.eq(true,"name", "Jack").
                ge("age", 3).
                between("age", 10, 20);

        User user = userMapper.selectOne(queryWrapper);
        System.out.println(user);

        queryWrapper.clear();


    }


    // 测试模糊查询 demo
    @Test
    void test2() {
        // 查询构造器
        QueryWrapper<User> userWrapper = new QueryWrapper<>();

        // condition 条件为 false 不包含该条件查询
        // LIKE '值%'
        userWrapper.like("name", "J").likeRight(false, "name", "e");

        List<User> users = userMapper.selectList(userWrapper);
        users.forEach(System.out::println);
    }

    // 测试子查询
    @Test
    void test3() {
        // ==>  Preparing: SELECT id,name,age,email,version,
        // deleted,gmt_create,gmt_modify FROM user WHERE deleted=0
        // AND (id IN (select id from user where id < 3))
        QueryWrapper<User> userWrapper = new QueryWrapper<>();
        userWrapper.inSql("id", "select id from user where id < 3");

        List<Object> users = userMapper.selectObjs(userWrapper);
        users.forEach(System.out::println);
    }

    // order by ..
    @Test
    void test4() {

        QueryWrapper<User> userWrapper = new QueryWrapper<>();

        userWrapper.orderByDesc("id");

        List<User> users = userMapper.selectList(userWrapper);

        users.forEach(System.out::println);
    }




}
