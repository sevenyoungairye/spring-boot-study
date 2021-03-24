package top.boy.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import tk.mybatis.mapper.entity.Example;
import top.boy.entity.Student;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.stream.Collectors;

/**
 * tk-mapper single table crud api demo...
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

    @Test
    public void demo01() {
        // 根据主键查询
        System.out.println(studentMapper.selectByPrimaryKey(1));

        // 新增demo 返回收影响行数 参数为Null也会保存
        System.out.println(studentMapper.insert(new Student(null, "hh", 19, new Date())));

        // 新增api, 参数为空 便不会保存
        System.out.println(studentMapper.insertSelective(new Student(null, "catcher", 19, new Date())));
    }

    @Test
    public Object get02() {

        Example example = new Example(Student.class);


        Example.Criteria criteria = example.createCriteria();

        // andCondition 用于构造sql语句
        criteria.orBetween("birthday", "2021-01-01", "2021-03-22").
                andCondition("id=", 1).andLike("name", "%ble%");

        //  SELECT * FROM student WHERE ( birthday between ? and ? and id= ? and name like ? or name like ? )
        // criteria.orLike("name", "tony");

        // Preparing: SELECT * student WHERE ( birthday between ? and ? and id= ? and name like ? ) or ( name like ? )
        example.or().orLike("name", "%to%");

        // 日期小->大 排序
        example.orderBy("birthday").asc();

        return studentMapper.selectByExample(example);
    }

    @Test
    public Object get03() {

        return studentMapper.
                selectAll().
                stream().
                sorted(Comparator.comparing(Student::getBirthday).reversed()).
                collect(Collectors.toList());
    }

    @Test
    public Object get04() {

        Example example = new Example(Student.class);

        // 标准
        Example.Criteria criteria = example.createCriteria();

        criteria.andIn("age", Arrays.asList(1, 2, 3, 10, 100));

        // criteria.andAllEqualTo("hh");

        criteria.andIsNull("name");

        return studentMapper.selectByExample(example);
    }
}
