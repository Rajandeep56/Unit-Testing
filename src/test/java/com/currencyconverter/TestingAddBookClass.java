package com.currencyconverter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;




public class TestingAddBookClass {
    private static AddBooks frame;

    @BeforeClass
    public static void beforeClass() throws Exception {
        frame = new AddBooks();
       
    }

    @AfterClass
    public static void afterClass() throws Exception {
        frame.dispose();
    }

    @Before
    public void visibility() throws Exception {
        frame.setVisible(true);
    }
    @Test
    public void testingAdd() throws InterruptedException, IOException {
        // Add a book to the CSV file
        //frame.textField.setText(null);
        frame.textField_2.setText("456756 ");
        frame.textField_1.setText("name");
        frame.textField_3.setText("author");
        frame.textField_4.setText("publication");
        frame.textField_5.setText("2");
        frame.textField.setText("Available");
        frame.btnAddBooks.doClick();

        // Verify that the book was added to the CSV file
        BufferedReader reader = new BufferedReader(new FileReader("src/Files/Books.csv"));
        String line = null;
        while ((line = reader.readLine()) != null) {
            String[] array = line.split(",");
            if (array[0].equals("456756")) {
                assertNotNull(array);
                assertEquals("456756", array[0]);
                assertEquals("test1", array[1]);
                assertEquals("test2", array[2]);
                assertEquals("test3", array[3]);
                assertEquals("2", array[4]);
                assertEquals("Available", array[5]);
                break;
            }
        }
        reader.close();
    }
//whitebox testing
@Test
    public void booksAdd() throws IOException{
       
        frame.textField.setText("Available");
        frame.textField_1.setText("name");
        frame.textField_2.setText("456756");
        frame.textField_3.setText("test2");
        frame.textField_4.setText("publish");
        frame.textField_5.setText("2");
        frame.btnAddBooks.doClick();
    
    File file = new File("src/Files/Books.csv");
        String text = Files.readString(file.toPath());
         assertTrue(text.contains("456756,name,test2,publish,2,Available"));

 }
//atleast one field null
 @Test
 public void testingAddnull() throws InterruptedException, IOException {
    // Add a book to the CSV file
    //frame.textField.setText(null);
    frame.textField_2.setText("");
    frame.textField_1.setText("");
    frame.textField_3.setText("");
    frame.textField_4.setText("publication");
    frame.textField_5.setText("2");
    frame.textField.setText("Available");
    frame.btnAddBooks.doClick();
    assertEquals(false, frame.flag);}
    //atleast all field null
 @Test
 public void testingAddnullall() throws InterruptedException, IOException {
    // Add a book to the CSV file
    //frame.textField.setText(null);
    frame.textField_2.setText("");
    frame.textField_1.setText("");
    frame.textField_3.setText("");
    frame.textField_4.setText("");
    frame.textField_5.setText("");
    frame.textField.setText("");
    frame.btnAddBooks.doClick();
    assertEquals(false, frame.flag);}

}
