package top.bitqian.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import top.bitqian.entity.WeiXinUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author echo lovely
 * @since 2020-12-04
 */
@Mapper
@Repository
public interface WeiXinUserMapper extends BaseMapper<WeiXinUser> {

    @Insert("insert into wei_xin_user values (null, #{userName}, #{userPwd}, #{createDate}, #{wxOpenId})")
    void addWeiXinUser(WeiXinUser user);

}
