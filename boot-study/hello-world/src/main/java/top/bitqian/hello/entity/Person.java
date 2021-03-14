package top.bitqian.hello.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author echo lovely
 * @date 2021/3/7 22:26
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    private Integer id;

    private String name;

    // 人有一宠物
    private Pet pet;

    public Person(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
