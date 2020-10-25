package cn.bitqian.controller;

import cn.bitqian.entity.Users;
import cn.bitqian.mapper.UsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author echo lovely
 * @date 2020/10/25 11:00
 */
@RestController
public class UsersController {

    @Autowired
    private UsersMapper usersMapper;

    @GetMapping(value = "/users")
    public List<Users> queryAllUsers() {
        return usersMapper.queryAllUsers();
    }

    @GetMapping(value = "/user/{id}")
    public Users queryOneUser(@PathVariable(value = "id") Integer id) {
        return usersMapper.queryUserById(id);
    }

    @GetMapping(value = "/add")
    public String addUser() {

        Users users = new Users(null, "abcdefghi", "abc");
        usersMapper.addUser(users);

        return "ok";
    }

    @GetMapping(value = "/upd/{id}/{userName}/{userPassword}")
    public String updateUser(@PathVariable(value = "id") Integer id,
                             @PathVariable(value = "userName") String userName,
                             @PathVariable(value = "userPassword") String userPassword) {
        Users users = new Users(id, userName, userPassword);

        usersMapper.updateUser(users);
        return "ok";
    }

    @GetMapping(value = "/del/{id}")
    public String deleteUser(@PathVariable(value = "id") Integer id) {

        usersMapper.deleteUserById(id);

        return "ok";
    }

}
