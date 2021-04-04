package top.bitqian.web.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 学生表
 * 
 * @author echo lovely
 * @email youngairye@163.com
 * @date 2021-04-04 16:47:16
 */
@Data
@TableName("student")
public class StudentEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * pk
	 */
	@TableId
	private Integer id;
	/**
	 * 姓名
	 */
	private String name;
	/**
	 * 年龄
	 */
	private Integer age;
	/**
	 * 生日
	 */
	private Date birthday;

}
