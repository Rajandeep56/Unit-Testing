package com.currencyconverter;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.CSVWriterBuilder;
import com.opencsv.ICSVWriter;
import com.opencsv.exceptions.CsvException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.awt.event.ActionEvent;


    

public class ReturnBook extends JFrame {
	static ReturnBook frame;
	private JPanel contentPane;
	 JTextField textField;
	 JTextField textField_4;
     JButton btnUpdateBook;
     int flag; // flag 0 : no value found, flag1: value found and updated, flag2: value is already updated thus no need to update again (status def)
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new ReturnBook();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
        
	}

	
	public ReturnBook() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 700);
		contentPane = new JPanel();
		contentPane.setForeground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		contentPane.setBackground(Color.black);
		setContentPane(contentPane);
		
		JLabel lblAddBooks = new JLabel("Return Book");
		lblAddBooks.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblAddBooks.setForeground(Color.white);
		
		JLabel lblCallNo = new JLabel("Call No:");
		lblCallNo.setForeground(Color.white);

		JLabel lblQuantity = new JLabel("Quantity:");
		lblQuantity.setForeground(Color.white);

		textField = new JTextField();
		textField.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);

		
		 btnUpdateBook = new JButton("Update Books");
		btnUpdateBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Boolean updated = false;
			Boolean found = false;
			String callno=textField.getText();
			String squantity=textField_4.getText();
            int qty = Integer.parseInt(squantity);

            File file = new File("src/Files/Books.csv");
            try {
                FileWriter outputfile = new FileWriter(file,true);
                ICSVWriter writer = new CSVWriterBuilder(outputfile).withSeparator(',').withQuoteChar(CSVWriter.NO_QUOTE_CHARACTER).build();

                CSVReader reader = new CSVReader(new FileReader(file));
				
                 List<String[]> rows = reader.readAll();
				 Set<String> duplicatesRemove = new HashSet<>();
                 for (String[] cols : rows) {

          // int availableQty = Integer.parseInt(cols[4]);
                if(cols[5].equals( "Issued") && cols[0].equals(callno)){
                   cols[5] = "Available";
                   //int totalQuantity = qty+availableQty;
                  // cols[4] = String.valueOf(totalQuantity);
                writer.writeAll(rows);
				updated=true;
				

			}
			if(cols[5].equals( "Available") && cols[0].equals(callno)){
				found = true;}
			// else{
			// writer.writeAll(rows);}
			duplicatesRemove.add(String.join(",", cols));
			
		
			
        }
		CSVWriter writer2 = new CSVWriter(new FileWriter(file,false));
		for (String row : duplicatesRemove) {
			writer2.writeNext(row.split(","));
		}

		
		if(updated && found){
		JOptionPane.showMessageDialog(ReturnBook.this,"Books updated successfully!");
		flag =1;
	}
		else if (!found){
			writer.writeAll(rows);
			JOptionPane.showMessageDialog(ReturnBook.this,"Book is not in records!!");
            flag=0;
		 }
		 else{
			writer.writeAll(rows);
			JOptionPane.showMessageDialog(ReturnBook.this,"Book is already returned!!");
            flag=2;
		 }
       reader.close();
	   writer.close();
      
        ReturnBook.main(new String[]{});
                       // frame.dispose();
         }
            catch (IOException test) {
                test.printStackTrace();
                JOptionPane.showMessageDialog(ReturnBook.this,"Sorry, unable to save!");
            } catch (CsvException e1) {
                e1.printStackTrace();
            }
                    }
                });
              
                
        JButton btnBack = new JButton("Back");
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            LibLoggedIn.main(new String[]{});
            frame.dispose();
            }
        });
        
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
gl_contentPane.setAutoCreateContainerGaps(true);
gl_contentPane.setAutoCreateGaps(true);

gl_contentPane.setHorizontalGroup(
    gl_contentPane.createParallelGroup(Alignment.CENTER)
        .addGroup(gl_contentPane.createSequentialGroup()
            .addComponent(lblAddBooks)
        )
        .addGroup(gl_contentPane.createSequentialGroup()
            .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                .addComponent(lblCallNo)
                .addComponent(lblQuantity)
            )
            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                .addComponent(textField)
                .addComponent(textField_4)
            )
        )
        .addComponent(btnUpdateBook)
        .addComponent(btnBack)
);

gl_contentPane.setVerticalGroup(
    gl_contentPane.createSequentialGroup()
        .addGap(30)
        .addComponent(lblAddBooks)
        .addGap(30)
        .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
            .addComponent(lblCallNo)
            .addComponent(textField)
        )
        .addGap(18)
        .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
            .addComponent(lblQuantity)
            .addComponent(textField_4)
        )
        .addGap(30)
        .addComponent(btnUpdateBook)
        .addGap(18)
        .addComponent(btnBack)
);

contentPane.setLayout(gl_contentPane);

		contentPane.setLayout(gl_contentPane);
	}


    

}


