package top.bitqian.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import top.bitqian.entity.ForumUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author echo lovely
 * @since 2020-11-30
 */
@Repository
@Mapper
public interface ForumUserMapper extends BaseMapper<ForumUser> {

}
