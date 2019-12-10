package com.example.spring.study.autoCloseable;

import org.junit.Test;

/**
 * Created by jianglei on 2019/12/6.
 */
public class AutoCloseableTest {

    @Test
    public void test1() {
        try (AutoCloseableApp autoCloseableApp = new AutoCloseableApp()){
            System.out.println("execute");
            int i = 1 /0;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("called finally");
        }
    }

    @Test
    public void test2() {
        try {
            AutoCloseableApp autoCloseableApp = new AutoCloseableApp();
            System.out.println("execute");
            int i = 1 /0;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("called finally");
        }
    }

    //execute
    /// by zero
    //called finally

    //execute
    //AutoCloseableApp#close() called
    /// by zero
    //called finally

    public static class AutoCloseableApp implements AutoCloseable {

        @Override
        public void close() throws Exception {
            System.out.println("AutoCloseableApp#close() called");
        }
    }
}
