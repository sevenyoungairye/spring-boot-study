package cn.bitqian.controller;

import cn.bitqian.dao.DepartmentDao;
import cn.bitqian.dao.EmployeeDao;
import cn.bitqian.entity.Department;
import cn.bitqian.entity.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.Collection;

/**
 * @author echo lovely
 * @date 2020/10/21 19:10
 */
@Controller
public class EmployeeController {

    @Resource
    private EmployeeDao employeeDao;

    @Resource
    private DepartmentDao departmentDao;

    @RequestMapping(value = "/emps")
    public String getAllEmployee(Model model) {

        model.addAttribute("emps", employeeDao.getAllEmployee());

        return "emps/list";
    }

    // get
    @GetMapping(value = "/add")
    public String toAddPage(Model model) {

        Collection<Department> departmentList = departmentDao.getAllDepartment();
        model.addAttribute("departmentList", departmentList);

        return "emps/add";
    }

    // post
    @PostMapping(value = "/add")
    public String addEmployee(Employee employee) {
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    // restful
    @GetMapping(value = "/emps/{id}")
    public String toUpdatePage(Model model, @PathVariable(value = "id") Integer id) {

        // 查询部门
        Collection<Department> departmentList = departmentDao.getAllDepartment();
        model.addAttribute("departmentList", departmentList);

        // 查询员工
        Employee employee = employeeDao.getAllEmployeeById(id);
        model.addAttribute("employee", employee);

        return "/emps/update";
    }

    @PostMapping(value = "/updateEmp")
    public String updateEmployee(Employee employee) {

        employeeDao.update(employee);
        return "redirect:/emps";
    }

    @GetMapping(value = "/del/{id}")
    public String deleteEmployee(@PathVariable(value = "id") Integer id) {

        employeeDao.deleteEmployeeById(id);

        return "redirect:/emps"; // 跳转查询
    }
}
