package com.currencyconverter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import java.time.Duration;

import javax.swing.JOptionPane;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestingClock {
    private static ClockInOut clock;

    @BeforeClass
    public static void beforeClass() throws Exception {
        clock = new ClockInOut();
       
    }

    @Test
    public void testStart() {
        clock.start();
        assertTrue(clock.isRunning);
        assertNotNull(clock.startTime);
    }

    
    @Test
    public void testStop() throws Exception{
       try {
        clock.start();
        Duration elapsed = clock.stop();
        assertNotNull(clock.endTime);
        assertNotNull(elapsed);
        assertFalse(clock.isRunning);
       } catch (Exception e) {
        System.out.println("clock is already running");
       } 
        
    }

    @Test
    public void testElapsedTime() throws InterruptedException {
       
        try { clock.start();
        Thread.sleep(9000);
        Duration elapsed = clock.stop();
        assertTrue(elapsed.getSeconds() >= 3);
    } catch (Exception e) {
        System.out.println("clock is already running");
       }
    }

    
}

