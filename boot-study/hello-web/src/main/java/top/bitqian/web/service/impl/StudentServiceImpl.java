package top.bitqian.web.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


import top.bitqian.web.common.PageUtils;
import top.bitqian.web.common.Query;
import top.bitqian.web.dao.StudentDao;
import top.bitqian.web.entity.StudentEntity;
import top.bitqian.web.service.StudentService;


@Service("studentService")
public class StudentServiceImpl extends ServiceImpl<StudentDao, StudentEntity> implements StudentService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<StudentEntity> page = this.page(
                new Query<StudentEntity>().getPage(params),
                new QueryWrapper<>()
        );

        return new PageUtils(page);
    }

}