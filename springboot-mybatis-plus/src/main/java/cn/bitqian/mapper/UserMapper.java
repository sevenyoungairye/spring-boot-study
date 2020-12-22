package cn.bitqian.mapper;

import cn.bitqian.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * user mapper
 * @author echo lovely
 * @date 2020/11/14 10:23
 */
@Repository
public interface UserMapper extends BaseMapper<User> {
    // curd 方法已经写好了
}
