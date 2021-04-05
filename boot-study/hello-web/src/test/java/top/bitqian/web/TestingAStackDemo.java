package top.bitqian.web;

import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.EmptyStackException;
import java.util.Stack;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * @author echo lovely
 * @date 2021/4/5 15:54
 * @description <p>
 *     嵌套测试demo
 * </p>
 */

@DisplayName("嵌套测试demo")
public class TestingAStackDemo {

    // 参数化设置, stream
    @ParameterizedTest
    @ValueSource(strings = {"a", "b", "c"})
    void testParam1(String p) {
        // 每个参数都会被传进来
        System.out.println(p);
    }

    @ParameterizedTest
    @MethodSource(value = {"myStream"}) // give a method name, stream type!
    void testParam2(String str) {
        System.out.println(str);
    }

    static Stream<String> myStream() {
        return Stream.of("apple", "banana");
    }


    Stack<Object> stack;

    // nested里面的beforeEach不影响外面的
    @Test
    @DisplayName("is instantiated with new Stack()")
    void isInstantiatedWithNew() {
        new Stack<>();
    }

    @Nested
    @DisplayName("when new")
    class WhenNew {

        // 这里创建下面会影响下面 -> AfterPushing
        @BeforeEach
        void createNewStack() {
            stack = new Stack<>();
        }

        @Test
        @DisplayName("is empty")
        void isEmpty() {
            // 断言元素为empty
            assertTrue(stack.isEmpty());
        }

        @Test
        @DisplayName("throws EmptyStackException when popped")
        void throwsExceptionWhenPopped() {
            // 断言空栈
            assertThrows(EmptyStackException.class, stack::pop);
        }

        @Test
        @DisplayName("throws EmptyStackException when peeked")
        void throwsExceptionWhenPeeked() {
            assertThrows(EmptyStackException.class, stack::peek);
        }

        @Nested
        @DisplayName("after pushing an element")
        class AfterPushing {

            String anElement = "an element";

            @BeforeEach
            void pushAnElement() {
                stack.push(anElement);
            }

            @Test
            @DisplayName("it is no longer empty")
            void isNotEmpty() {
                assertFalse(stack.isEmpty());
            }

            @Test
            @DisplayName("returns the element when popped and is empty")
            void returnElementWhenPopped() {
                assertEquals(anElement, stack.pop());
                assertTrue(stack.isEmpty());
            }

            @Test
            @DisplayName("returns the element when peeked but remains not empty")
            void returnElementWhenPeeked() {
                stack.forEach(System.out::println);
                assertEquals(anElement, stack.peek());
                assertFalse(stack.isEmpty());
            }
        }
    }

}
