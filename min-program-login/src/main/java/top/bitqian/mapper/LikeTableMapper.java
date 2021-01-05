package top.bitqian.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import top.bitqian.entity.LikeTable;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author echo lovely
 * @since 2020-11-30
 */
@Mapper
@Repository
public interface LikeTableMapper extends BaseMapper<LikeTable> {

}
