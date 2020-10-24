package cn.bitqian.dao;

import cn.bitqian.entity.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * 模拟部门dao
 * @author echo lovely
 * @date 2020/10/21 18:36
 */
@Repository
public class DepartmentDao {

    private static Map<Integer, Department> departmentsMap = null;

    static {
        // 创建一个部门表
        departmentsMap = new HashMap<Integer, Department>();
        departmentsMap.put(101, new Department(101, "教学部"));
        departmentsMap.put(102, new Department(102, "市场部"));
        departmentsMap.put(103, new Department(103, "人事部"));
        departmentsMap.put(104, new Department(104, "技术部"));
        departmentsMap.put(105, new Department(105, "后勤部"));
    }

    /**
     * 查询所有部门
     * @return 返回所有部门
     */
    public Collection<Department> getAllDepartment() {

        return departmentsMap.values();
    }

    /**
     * 根据id查询对应的部门
     * @param departmentId 部门id
     * @return 对应的部门
     */
    public Department getDepartmentById(Integer departmentId) {

        Department department = departmentsMap.get(departmentId);
        return department;
    }

}
