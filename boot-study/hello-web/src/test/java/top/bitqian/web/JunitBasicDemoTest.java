package top.bitqian.web;

import org.junit.jupiter.api.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author echo lovely
 * @description
 * <p>
 *     junit5 test demo
 *     <li>
 *         <a href="https://junit.org/junit5/docs/current/user-guide/#overview-getting-started">pls see junit5 doc</a>
 *     </li>
 *     <li>
 *          ExtendWith annotation pls see @SpringBootTest
 *     </li>
 * </p>
 * @date 2021/4/5 11:19
 */


@DisplayName("junit5测试类")
public class JunitBasicDemoTest {

    // 前置条件test
    @Test
    void test() {
        String str = "hhh";
        Assumptions.assumingThat(
            () -> true,
            () -> Assertions.assertEquals("hhh", str)
        );
        Assumptions.assumeTrue(true);
        System.out.println("Assumptions通过了会执行, 否则会被忽略, disabled..");
    }

    @Test
    void testExcepting() {
        Exception e = Assertions.assertThrows(IllegalArgumentException.class, () -> hh(""));
        Assertions.assertEquals("args illegal..", e.getMessage());
    }

    void hh(Object... args) {
        if (null == args || args.length <= 1)
            throw new IllegalArgumentException("args illegal..");
    }


    @Test
    void testFail() {
        // 断言失败, 后面的代码会停止执行.
        Assertions.fail("fast fail...");
    }

    @Test
    void dependentAssertions() {

        Map<String, String> personMap = new HashMap<>();
        personMap.put("firstName", "bit");
        personMap.put("lastName", "lel");

        Assertions.assertAll("props",
            () -> {
                String firstName = personMap.get("firstName");

                // 断言null
                Assertions.assertNotNull(firstName);
                Assertions.assertAll("firstName",
                    () -> Assertions.assertTrue(firstName.startsWith("b")),
                    () -> Assertions.assertTrue(firstName.endsWith("t"))
                );
            },
            () -> {
                String lastName = personMap.get("lastName");

                Assertions.assertNotNull(lastName);
                Assertions.assertAll("lastName",
                    () -> Assertions.assertTrue(lastName.startsWith("l")),
                    () -> Assertions.assertTrue(lastName.endsWith("l"))
                );
            }
        );

    }

    @Test
    void groupedAssertions() {
        Assertions.assertAll("grouped..",
            this::assertStandard,
            () -> Assertions.assertEquals("jack", "jack")
        );
    }

    @Test
    void assertStandard() {
        Assertions.assertTrue(true, "this is true!");
    }

    @Test
    void assertArrays() {
        Assertions.assertArrayEquals(new int[] {1, 2}, new int[]{1, 2}, "assert error...比较两数组值不等...");
        System.out.println("两数组值相同..");
    }

    @Test
    void assertSame() {
        Assertions.assertSame(new Object(), new Object(), "两个对象不想等...");
    }

    @Test
    void assertEqual() {
        Assertions.assertEquals(5, 5, "结果不是5..");
        System.out.println("assertEquals success!");
    }


    @Tag("once in init..")
    @BeforeAll
    static void testBeforeAll() {
        // 只运行一次, 所有方法的开头
        System.out.println("any of before all..");
    }

    @Test
    @DisplayName("测试方法1")
    void test1() {
        System.out.println("1");
    }

    @Test
    @DisplayName("测试方法2")
    void test2() {
        System.out.println("2");
    }

    private final int times = 5;

    @DisplayName("会测试" + times + "次")
    @RepeatedTest(value = times)
    void testAnyTimes() {
        System.out.println("测试ing... 多次测试次数：" + times);
    }

    @DisplayName("测试超时")
    @Timeout(value = 300, unit = TimeUnit.MILLISECONDS)
    @Test
    void testOutTime() {
        try {
            // if timeout--> java.util.concurrent.TimeoutException: testOutTime() timed out after 300 milliseconds
            TimeUnit.MILLISECONDS.sleep(200L);
            System.out.println(666);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Disabled("demo disable it..")
    @Test
    void testDisable() {
        System.out.println("disabled..");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("每个方法前都会执行..");
    }

    @AfterEach
    void afterEach() {
        System.out.println("每个方法后都会执行..");
    }

    @Tag("once in shutdown..")
    @AfterAll
    static void testAfterAll() {
        System.out.println("所有测试方法执行完成才会执行..");
    }


}
