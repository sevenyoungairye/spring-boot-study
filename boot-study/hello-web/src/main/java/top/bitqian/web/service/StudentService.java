package top.bitqian.web.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.bitqian.web.common.PageUtils;
import top.bitqian.web.entity.StudentEntity;

import java.util.Map;

/**
 * 学生表
 *
 * @author echo lovely
 * @email youngairye@163.com
 * @date 2021-04-04 16:47:16
 */
public interface StudentService extends IService<StudentEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

