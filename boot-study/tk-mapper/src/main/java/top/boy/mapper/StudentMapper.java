package top.boy.mapper;

import tk.mybatis.mapper.common.Mapper;
import top.boy.entity.Student;

import java.util.List;

public interface StudentMapper extends Mapper<Student> {

    // 批量修改
    void batchUpdateStu(List<Student> list);

}