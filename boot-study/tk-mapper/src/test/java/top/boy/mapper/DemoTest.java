package top.boy.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import tk.mybatis.mapper.entity.Example;
import top.boy.entity.Student;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author echo lovely
 * @date 2021/3/13 18:56
 */

@SpringBootTest
public class DemoTest {

    @Resource
    private StudentMapper studentMapper;

    @Test
    void contextLoads() {

        // demo01();

        // 根据主键id 修改
        // System.out.println(studentMapper.updateByPrimaryKey(new Student(1, "abc.abc", 19, new Date())));

        // studentMapper.getAllStudent().forEach(System.out::println);


        // example demo
        Example example = new Example(Student.class);
        // criteria 构造条件对象
        Example.Criteria criteria = example.createCriteria();

        criteria.andLike("name", "%abc%");

        studentMapper.selectByExample(example).forEach(System.out::println);

    }

    private void demo01() {
        // 根据主键查询
        System.out.println(studentMapper.selectByPrimaryKey(1));

        // 新增demo 返回收影响行数 参数为Null也会保存
        System.out.println(studentMapper.insert(new Student(null, "hh", 19, new Date())));

        // 新增api, 参数为空 便不会保存
        System.out.println(studentMapper.insertSelective(new Student(null, "catcher", 19, new Date())));
    }

}
