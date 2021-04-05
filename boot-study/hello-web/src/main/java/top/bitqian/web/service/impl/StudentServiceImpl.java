package top.bitqian.web.service.impl;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
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

    // public StudentServiceImpl() {}

    private final Counter counter;

    // 自定义metrics 统计queryPage方法的访问数量
    public StudentServiceImpl(MeterRegistry registry) {
        counter = registry.counter("stu.query.count", "id", "unsure times");
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        counter.increment();
        IPage<StudentEntity> page = this.page(
                new Query<StudentEntity>().getPage(params),
                new QueryWrapper<>()
        );

        return new PageUtils(page);
    }

}