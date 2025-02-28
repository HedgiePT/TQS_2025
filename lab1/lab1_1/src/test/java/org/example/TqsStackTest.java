package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

public class TqsStackTest {
    private TqsStack<Double> stack = null;

    @BeforeEach
    void setup() {
        stack = new TqsStack<>();
    }

    @Test
    void testInitialState() {
        Assertions.assertTrue(stack.isEmpty());
        Assertions.assertEquals(0, stack.size());
    }

    @Test
    void testPushPop() {
        stack.push(4.5);
        Assertions.assertEquals(4.5, stack.pop());

        stack.push(1.0);
        stack.push(2.0);
        stack.push(3.0);
        Assertions.assertEquals(3.0, stack.pop());
        Assertions.assertEquals(2.0, stack.pop());
        Assertions.assertEquals(1.0, stack.pop());
    }

    @Test
    void testPeek() {
        stack.push(1.0);
        stack.push(2.0);

        Assertions.assertEquals(2.0, stack.peek());
        Assertions.assertEquals(2.0, stack.peek());
        Assertions.assertEquals(2.0, stack.peek());

        Assertions.assertEquals(2, stack.size(), "Size was wrong after peeking!");
        Assertions.assertFalse(stack.isEmpty());
    }

    @Test
    void testPeekAfterPop() {
        stack.push(1.0);
        stack.push(2.0);
        stack.pop();
        Assertions.assertEquals(1.0, stack.peek());

        Assertions.assertEquals(1, stack.size(), "Size was wrong after pop & peeking!");
        Assertions.assertFalse(stack.isEmpty());
    }

    @Test
    void testStateAfterPush() {
        stack.push(11.1);
        Assertions.assertFalse(stack.isEmpty());
        Assertions.assertEquals(1, stack.size());

        stack.push(22.2); Assertions.assertEquals(2, stack.size());
        stack.push(33.3); Assertions.assertEquals(3, stack.size());
        stack.push(44.4); Assertions.assertEquals(4, stack.size());
        Assertions.assertFalse(stack.isEmpty());
    }

    @Test
    void testStateAfterPop() {
        stack.push(11.1);
        stack.push(22.2);
        stack.push(33.3);
        stack.push(44.4);

        stack.pop();
        Assertions.assertFalse(stack.isEmpty(), "Stack was empty after only one pop!");
        Assertions.assertEquals(3, stack.size(), "Stack size was wrong after one pop!");

        stack.pop(); Assertions.assertEquals(2, stack.size());
        stack.pop(); Assertions.assertEquals(1, stack.size());
        stack.pop();
        // Stack should now be empty.

        Assertions.assertTrue(stack.isEmpty());
        Assertions.assertEquals(0, stack.size());
    }

    @AfterEach
    void teardown() {
        stack = null;
    }
}
