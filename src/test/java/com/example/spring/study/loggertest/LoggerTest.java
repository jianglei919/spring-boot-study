package com.example.spring.study.loggertest;

import org.junit.Test;

import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by jianglei on 2019/12/20.
 */
public class LoggerTest {

    @Test
    public void testLogger() {
        Logger logger = Logger.getLogger("com.example.spring.study.loggertest.LoggerTest");
        logger.setLevel(Level.FINE);
        logger.setUseParentHandlers(false);
        Handler hd = new ConsoleHandler();
        hd.setLevel(Level.FINE);
        logger.addHandler(hd);
        logger.info("start log");
    }
}
