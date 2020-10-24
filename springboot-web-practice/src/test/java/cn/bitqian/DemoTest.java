package cn.bitqian;

import org.junit.jupiter.api.Test;

import java.util.Locale;

/**
 * @author echo lovely
 * @date 2020/10/20 21:42
 */
public class DemoTest {

    @Test
    public void test1() {
        Locale locale = new Locale("ZH", "china");
        System.out.println(locale.getCountry());
    }

}
