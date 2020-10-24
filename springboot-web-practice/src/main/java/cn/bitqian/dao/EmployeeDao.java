package cn.bitqian.dao;

import cn.bitqian.entity.Department;
import cn.bitqian.entity.Employee;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * 员工dao
 * @author echo lovely
 * @date 2020/10/21 18:42
 */
@Repository
public class EmployeeDao {

    private static Map<Integer, Employee> employeesMap = null;

    @Resource
    private DepartmentDao departmentDao;

    // 加载所有的员工
    static {
        employeesMap = new HashMap<>();

        employeesMap.put(101, new Employee(101, "jack", "j88999@demo.com", 0, new Department(101, "教学部")));
        employeesMap.put(102, new Employee(102, "rose", "r88999@demo.com", 1, new Department(102, "市场部")));
        employeesMap.put(103, new Employee(103, "tom", "t88999@demo.com", 0, new Department(103, "人事部")));
        employeesMap.put(104, new Employee(104, "jerry", "j88999@demo.com", 0, new Department(104, "技术部")));
        employeesMap.put(105, new Employee(105, "lucy", "l88999@demo.com", 1, new Department(105, "后勤部")));

    }

    // 员工id
    private static Integer initId = 105;

    // 新增员工
    public void save(Employee employee) {

        if (employee.getId() == null) {
            employee.setId(++initId);
        }

        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));
        employeesMap.put(initId, employee);

    }

    // 修改员工
    public void update(Employee employee) {
        // 设置部门
        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));
        employeesMap.put(employee.getId(), employee);
    }

    // 查询所有
    public Collection<Employee> getAllEmployee() {

        return employeesMap.values();
    }

    // 查询单个
    public Employee getAllEmployeeById(Integer employeeId) {
        return employeesMap.get(employeeId);
    }

    // 删除
    public void deleteEmployeeById(Integer employeeId) {
        employeesMap.remove(employeeId);
    }

}
