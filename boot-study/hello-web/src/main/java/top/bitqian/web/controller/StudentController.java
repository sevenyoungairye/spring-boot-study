package top.bitqian.web.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import top.bitqian.web.common.PageUtils;
import top.bitqian.web.common.R;
import top.bitqian.web.entity.StudentEntity;
import top.bitqian.web.service.StudentService;



/**
 * 学生表
 *
 * @author echo lovely
 * @email youngairye@163.com
 * @date 2021-04-04 16:47:16
 */
@RestController
@RequestMapping("web/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = studentService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Integer id){
		StudentEntity student = studentService.getById(id);

        return R.ok().put("student", student);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody StudentEntity student){
		studentService.save(student);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody StudentEntity student){
		studentService.updateById(student);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
		studentService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
