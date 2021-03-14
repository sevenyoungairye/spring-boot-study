package top.boy.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.boy.entity.Student;
import top.boy.mapper.StudentMapper;

import javax.annotation.Resource;

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


}
