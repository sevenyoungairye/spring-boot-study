package cn.bitqian.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 员工表
 * @author echo lovely
 * @date 2020/10/21 18:24
 */
@Data
@NoArgsConstructor
public class Employee {

    // ctrl alt u / ctrl alt shift u

    // ctrl f12 得到类的方法 属性

    private Integer id;
    private String lastName;
    private String email;
    private Integer gender; // 0男 1女
    private Department department;
    private Date birth;

    public Employee(Integer id, String lastName, String email, Integer gender, Department department) {
        this.id = id;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.department = department;
        this.birth = new Date(); // 日期为当前时间
    }


}
