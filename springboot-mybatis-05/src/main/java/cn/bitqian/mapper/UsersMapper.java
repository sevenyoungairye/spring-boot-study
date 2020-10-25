package cn.bitqian.mapper;

import cn.bitqian.entity.Users;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * user mapper
 * @author echo lovely
 * @date 2020/10/25 10:18
 */
@Mapper // mybatis映射类
@Repository
public interface UsersMapper {

    List<Users> queryAllUsers();

    Users queryUserById(int userId);

    void addUser(Users users);

    void updateUser(Users users);

    void deleteUserById(int usersId);

}
