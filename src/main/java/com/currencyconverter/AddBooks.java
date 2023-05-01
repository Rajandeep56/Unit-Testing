package com.currencyconverter;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.CSVWriterBuilder;
import com.opencsv.ICSVWriter;


import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;


    

public class AddBooks extends JFrame {
	static AddBooks frame;
	private JPanel contentPane;
	JTextField textField;
	 JTextField textField_1;
	 JTextField textField_2;
	 JTextField textField_3;
	 JTextField textField_4;
     JTextField textField_5;
     JButton btnAddBooks ;
     Boolean flag ;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new AddBooks();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public AddBooks() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setBackground(Color.black);
		JLabel lblAddBooks = new JLabel("Add Books");
		lblAddBooks.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblAddBooks.setForeground(Color.white);
		
		JLabel lblCallNo = new JLabel("Call No:");
		lblCallNo.setForeground(Color.white);

		JLabel lblName = new JLabel("Name:");
		lblName.setForeground(Color.white);

		JLabel lblAuthor = new JLabel("Author:");
		lblAuthor.setForeground(Color.white);

		JLabel lblPublisher = new JLabel("Publisher:");
		lblPublisher.setForeground(Color.white);

		JLabel lblQuantity = new JLabel("Quantity:");
		lblQuantity.setForeground(Color.white);

        JLabel status = new JLabel("Status:");
		status.setForeground(Color.white);

		textField = new JTextField();
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);

        textField_5 = new JTextField();
		textField_5.setColumns(10);
		
		 btnAddBooks = new JButton("Add Books");
		btnAddBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String callno=textField_2.getText();
			String name=textField_1.getText();
			String author=textField_3.getText();
			String publisher=textField_4.getText();
			String squantity=textField_5.getText();
			String statusOf=textField.getText();

            File file = new File("src/Files/Books.csv");
            try {
                FileWriter outputfile = new FileWriter(file,true);
                ICSVWriter writer = new CSVWriterBuilder(outputfile).withSeparator(',').withQuoteChar(CSVWriter.NO_QUOTE_CHARACTER).build();

                // // add data to csv
                
                String[] data1 = { callno, name,author,publisher,squantity,statusOf };
                if (textField.getText() != null && !textField.getText().isEmpty() 
                        &&textField_1.getText() != null && !textField_1.getText().isEmpty()
                        &&textField_2.getText() != null && !textField_2.getText().isEmpty()
                        &&textField_3.getText() != null && !textField_3.getText().isEmpty()
                        &&textField_4.getText() != null && !textField_4.getText().isEmpty()
                        &&textField_5.getText() != null && !textField_5.getText().isEmpty()
                        ) {
                            flag=true;
                writer.writeNext(data1);
                JOptionPane.showMessageDialog(AddBooks.this,"Books added successfully!");
            }
                else{
                    flag=false;
                    JOptionPane.showMessageDialog(AddBooks.this,"please do not leave any field empty!!!!");
                }
                writer.close();
            
               
                AddBooks.main(new String[]{});
                //frame.dispose();
                        
                    
            }
            catch (IOException test) {
                test.printStackTrace();
                JOptionPane.showMessageDialog(AddBooks.this,"Sorry, unable to save!");
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
gl_contentPane.setHorizontalGroup(
    gl_contentPane.createParallelGroup(Alignment.CENTER)
        .addGroup(gl_contentPane.createSequentialGroup()
            .addGroup(gl_contentPane.createParallelGroup(Alignment.CENTER)
			.addGap(120)
               // .addComponent(lblAddBooks)
                .addGroup(gl_contentPane.createSequentialGroup()
                    .addGap(120)
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.CENTER)
					
                        .addComponent(lblName)
                        .addComponent(lblCallNo)
                        .addComponent(lblAuthor)
                        .addComponent(lblPublisher)
                        .addComponent(lblQuantity)
                        .addComponent(status))
                    .addGap(50)
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.CENTER)
					.addComponent(lblAddBooks)
                        .addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
                        .addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
                        .addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
                        .addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
                        .addComponent(textField_5, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
                        .addComponent(textField, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)))
                .addGroup(gl_contentPane.createSequentialGroup()
                    .addGap(200)
                    .addComponent(btnAddBooks, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
                    .addGap(18)
                    .addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)))
            .addContainerGap(101, Short.MAX_VALUE))
);
gl_contentPane.setVerticalGroup(
    gl_contentPane.createParallelGroup(Alignment.CENTER)
        .addGroup(gl_contentPane.createSequentialGroup()
            .addGap(60)
            .addComponent(lblAddBooks)
            .addGap(50)
            .addGroup(gl_contentPane.createParallelGroup(Alignment.CENTER)
                .addComponent(lblName)
                .addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
            .addGap(18)
            .addGroup(gl_contentPane.createParallelGroup(Alignment.CENTER)
                .addComponent(lblCallNo)
                .addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
            .addGap(18)
            .addGroup(gl_contentPane.createParallelGroup(Alignment.CENTER)
                .addComponent(lblAuthor)
                .addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
            .addGap(18)
            .addGroup(gl_contentPane.createParallelGroup(Alignment.CENTER)
                .addComponent(lblPublisher)
                .addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
            .addGap(18)
            .addGroup(gl_contentPane.createParallelGroup(Alignment.CENTER)
                .addComponent(lblQuantity)
                .addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
            .addGap(18)
            .addGroup(gl_contentPane.createParallelGroup(Alignment.CENTER)
                .addComponent(status)
                .addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
            .addGap(50)
            .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                .addComponent(btnAddBooks)
                .addComponent(btnBack))
            .addContainerGap(94, Short.MAX_VALUE))
);

		contentPane.setLayout(gl_contentPane);
	}

}


