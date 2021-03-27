package top.boy.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.boy.entity.Student;
import top.boy.mapper.StudentMapper;

import javax.annotation.Resource;
import java.util.Arrays;

/**
 * @author echo lovely
 * @version 0.0.1
 * @date 2021/03/11/16:43
 * @description your desc
 */

@RestController
public class StudentController {

    @Resource
    private StudentMapper studentMapper;

    @GetMapping("/one")
    public Student getOne() {


        return studentMapper.selectOne(null);
    }

    @GetMapping("/batch/upd")
    public String studentList() {

        studentMapper.batchUpdateStu(Arrays.asList(
                new Student(1, "one", 18, null),
                new Student(2, "two", 19, null),
                new Student(3, "three", 20, null)
        ));

        return "ok";
    }

}
