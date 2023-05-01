package com.currencyconverter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;
import  org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
// import org.junit.runners.Parameterized.Parameters;
// import org.junit.runners.Parameterized;
import java.awt.TextField;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import javax.swing.JOptionPane;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;

@RunWith(Parameterized.class)
public class TestingReturnbook {
    private ReturnBook frame;
     String text1, text2;
    JOptionPane mockOptionPane = mock(JOptionPane.class);
    
    @Before
    public void setUp() throws Exception {
        frame = new ReturnBook();
        frame.setVisible(true);
    }
    
    @After
    public void tearDown() throws Exception {
        frame.dispose();
    }

    @Test
    public void testUpdateBook() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/Files/Books.csv"));
        String line = null;
        boolean flag = false;
        // Test the case when the book is available
        frame.textField.setText("346");
        frame.textField_4.setText("1");
        frame.btnUpdateBook.doClick();
        while ((line = reader.readLine()) != null) {
            String[] array = line.split(",");
            if (array[0].equals("346")) {
                assertNotNull(array);
                assertEquals("346", array[0]);
                
                assertEquals("Available", array[5]);
                break;
            }
        // Test the case when the book is already returned
        frame.textField.setText("346");
        frame.textField_4.setText("1");
        frame.btnUpdateBook.doClick();
        while ((line = reader.readLine()) != null) {
            String[] array2 = line.split(",");
            if (array2[0].equals("346")) {
                assertNotNull(array);
                assertEquals("346", array[0]);
                
                assertEquals("Available", array[5]);
                break;
            }
       // reader.close();
        
        // // Test the case when the book is not in records
        frame.textField.setText("9087");
        frame.textField_4.setText("1");
        frame.btnUpdateBook.doClick();
        while ((line = reader.readLine()) != null) {
            String[] array3= line.split(",");
            
                if (array3[0].equals("9087")) {
                
                    flag=true;
                }
                
                break;
            }
            assertEquals(false, flag);
    
  

}
}}
public TestingReturnbook(String text1, String text2){
    this.text1 = text1;
    this.text2 = text2;
  }

  @Parameterized.Parameters
    public static Collection<String[]> data() {
        return Arrays.asList(new String[][]{
                {"679","1"},
                {"789","1"},
                {"345","1"},
                {"678","1"},
                {"4568","1"}
                

            });
    }
    @Test
    public void testBookAddpara(){
       
        frame.textField.setText(text1);
        frame.textField_4.setText(text2);
        frame.btnUpdateBook.doClick();
        assertEquals("2", String.valueOf(frame.flag));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/testingCsv.csv")
     void testcsvFile(String column1, String column2){
         frame.textField.setText(column1);
         frame.textField_4.setText(column2);
        frame.btnUpdateBook.doClick();
        String actualValue= String.valueOf(frame.flag);

        assertEquals("1",actualValue);
    }
  

}