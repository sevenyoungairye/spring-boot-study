package cn.bitqian;

import cn.bitqian.entity.User;
import cn.bitqian.mapper.UserMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class MybatisPlus01ApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {
        List<User> userList = userMapper.selectList(null);
        userList.forEach(System.out::println);
    }

    @Test
    void addUser() {

        User user = new User();
        user.setName("abc");
        user.setAge(19);
        user.setEmail("abc@abc.com");

        // 插入操作，默认雪花算法，主键生成为long类型
        int count = userMapper.insert(user);
        System.out.println(count);

        System.out.println(user);

        /**
         * 结果1：
         * 1
         * User(id=1327447426226786306, name=abc, age=19, email=abc@abc.com)
         */

        /**
         * 结果2： 设置主键自增 IdType.auto
         */

    }

    @Test
    void updateUser() {
        User user = new User();
        user.setId(1327447426226786310L);
        user.setAge(18);

        userMapper.updateById(user);
    }

    @Test
    void testOptimisticLocker1() {
        User user = userMapper.selectById(1327447426226786310L);

        // 抢先修改
        User user1 = userMapper.selectById(1327447426226786310L);
        user1.setName("jjj");
        userMapper.updateById(user1);

        // 不会被修改，因为由于上面的修改version变了
        user.setName("bitqian666");
        userMapper.updateById(user);

    }

    @Test
    void queryOne() {
        // 查询单个user
        User user = userMapper.selectById(1);

        System.out.println(user);
    }

    @Test
    void queryBatchUser() {
        // 根据id查询多个user
        List<User> users = userMapper.selectBatchIds(Arrays.asList(1, 2, 3));
        users.forEach(System.out::println);
    }

    @Test
    void queryByMap() {
        // 多条件查询
        Map<String, Object> conditionParamMap = new HashMap<>();

        conditionParamMap.put("name", "Jack");
        conditionParamMap.put("id", "2");

        List<User> users = userMapper.selectByMap(conditionParamMap);
        users.forEach(System.out::println);
    }

    @Test
    void queryByPaging() {
        int pageNum = 1;
        int pageSize = 5;
        Page<User> page = new Page<>(pageNum, pageSize);

        Page<User> userPage = userMapper.selectPage(page, null);

        // 遍历 user
        userPage.getRecords().forEach(System.out::println);
    }

    @Test
    void deleteById() {
        // ctrl shift z
       userMapper.deleteById(1327447426226786310l);
    }

    @Test
    void deleteBatchByIds() {
        userMapper.deleteBatchIds(
                Arrays.asList(1327447426226786306l,
                        1327447426226786307l));
    }

    @Test
    void deleteBatchByCondition() {
        Map<String, Object> conditionParamMap = new HashMap<>();

        // 删除name为abc的
        conditionParamMap.put("name", "abc");

        userMapper.deleteByMap(conditionParamMap);
    }

    // 逻辑删除 实际上是修改
    @Test
    void deleteByLogic() {
        // 被逻辑删除后的值不会被查询，修改到
        // SELECT id,name,age,email,version,deleted,gmt_create,gmt_modify FROM user WHERE id=? AND deleted=0
        userMapper.deleteById(1l);
    }


}
