package top.bitqian.web.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author echo lovely
 * @date 2021/3/21 17:20
 */

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Person {

    private Integer id;

    private String name;

    private Pet pet;

}
