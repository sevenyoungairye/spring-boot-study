package cn.bitqian;

import cn.bitqian.mapper.UsersMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ShiroSpringbootApplicationTests {

    @Autowired
    UsersMapper usersMapper;

    @Test
    void contextLoads() {
        System.out.println(usersMapper.findUsersByUsersName("jack"));
    }

}
