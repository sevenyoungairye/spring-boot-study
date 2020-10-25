package cn.bitqian;

import cn.bitqian.entity.Users;
import cn.bitqian.mapper.UsersMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@SpringBootTest
class SpringbootMybatis05ApplicationTests {

    @Resource
    private DataSource dataSource;

    @Autowired
    private UsersMapper usersMapper;

    @Test
    void contextLoads() {
        List<Users> users = usersMapper.queryAllUsers();
        System.out.println(users);
    }

}
