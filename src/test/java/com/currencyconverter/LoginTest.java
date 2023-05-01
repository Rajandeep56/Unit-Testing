package com.currencyconverter;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import java.awt.event.ActionEvent;

/**
 * Unit test for simple App.
 */
public class LoginTest 
{
    private static LibLogin frame;

    @BeforeClass
    public static void beforeClass() throws Exception {
        frame = new LibLogin();
       
    }

    @AfterClass
    public static void afterClass() throws Exception {
        frame.dispose();
    }

    @Before
    public void visibility() throws Exception {
        frame.setVisible(true);
    }
    static {
        System.setProperty("java.awt.headless", "false");
    }
    

   

    // to test putting if login button is taking the value right
    @Test
    public void testLogin() {
        frame.textField.setText("Rajan");
        frame.passwordField.setText("password");
        String pswd = String.valueOf(frame.passwordField.getPassword());
        frame.btnLogin.getActionListeners()[0].actionPerformed(new ActionEvent(frame.btnLogin, ActionEvent.ACTION_PERFORMED, null));
        assertEquals("Rajan password", frame.textField.getText()+" "+pswd);
    }
    @Test
    public void testLoginValid() {
        
        frame.textField.setText("Rajan");
        frame.passwordField.setText("test");
        frame.btnLogin.doClick();
        assertEquals(true, frame.testResult);
    }
    @Test
    public void testLoginInValid() {
        LibLogin login = new LibLogin();
        login.textField.setText("Rajan");
        login.passwordField.setText("password");
        String pswd = String.valueOf(login.passwordField.getPassword());
        frame.btnLogin.doClick();
                assertEquals(false, frame.testResult);
    }
    

}
