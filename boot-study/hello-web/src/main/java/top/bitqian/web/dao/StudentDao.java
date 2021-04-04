package top.bitqian.web.dao;

import top.bitqian.web.entity.StudentEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 学生表
 * 
 * @author echo lovely
 * @email youngairye@163.com
 * @date 2021-04-04 16:47:16
 */
@Mapper
public interface StudentDao extends BaseMapper<StudentEntity> {
	
}
