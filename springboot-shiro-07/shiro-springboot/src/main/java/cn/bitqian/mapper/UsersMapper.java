package cn.bitqian.mapper;

import cn.bitqian.entity.Users;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 根据用户名查询 用户
 * @author echo lovely
 * @date 2020/10/27 22:04
 */
@Repository
@Mapper
public interface UsersMapper {

    Users findUsersByUsersName(String usersName);

}
