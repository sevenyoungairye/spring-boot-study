package cn.bitqian.controller;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * jdbc 测试controller
 * @author echo lovely
 * @date 2020/10/23 17:32
 */
@RestController
public class JdbcController {

    @Resource
    private JdbcTemplate jdbcTemplate;

    @GetMapping(value = "/user")
    public List<Map<String, Object>> getAllUsers() {

        // map 为每条数据

        String sql = "select * from users1";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);

        return maps;
    }

    @GetMapping(value = "/add")
    public String addUsers() {
        String sql = "insert into mybatis_study.users1 (userName, userPassword) values (?, ?)";

        jdbcTemplate.update(sql, new Object[]{"demotest哈哈哈", "zzzzzzz"});

        return "add-ok";
    }

    @GetMapping(value = "/upd/{id}")
    public String updateUser(@PathVariable(value = "id") Integer id) {
        String sql = "update users1 set userName = ? where userId = ?";

        jdbcTemplate.update(sql, new Object[]{"abc_upd", id});
        return "upd-ok";
    }

    @GetMapping(value = "/del/{id}")
    public String deleteUser(@PathVariable(value = "id") Integer id) {
        String sql = "delete from users1 where userId = ?";
        jdbcTemplate.update(sql, id);

        return "del-ok";
    }

}
