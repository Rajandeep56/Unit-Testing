package com.currencyconverter;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.TextArea;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewBooks extends JFrame {
	private JPanel contentPane;
	static ViewBooks frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 frame = new ViewBooks();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException
	 */
	public ViewBooks() throws IOException {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 700, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(50, 50, 50, 50));
		contentPane.setLayout(new BorderLayout(250, 10));
		contentPane.setBackground(Color.black);
		setContentPane(contentPane);
		
		JLabel lblAvailable = new JLabel("Available Books");
		lblAvailable.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblAvailable.setForeground(Color.white);
		
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
		BufferedReader reader = new BufferedReader(new FileReader("src/Files/Books.csv"));
        String line = "";
       
        while ((line = reader.readLine()) != null) {
            String[] cols = line.split(",");
            if(cols[5].equals( "Available")){
            textArea.append(cols[0]+" " +cols[1] +" "+cols[2]+" "+cols[3]+" "+cols[4]+"\n");}

        }
        reader.close();
        JButton btnBack = new JButton("Back");
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            LibLoggedIn.main(new String[]{});
            frame.dispose();
            }
        });
		Dimension btnSize = new Dimension(10, btnBack.getPreferredSize().height);
		btnBack.setPreferredSize(btnSize);
		JScrollPane sp=new JScrollPane(textArea);
		
		contentPane.add(sp, BorderLayout.CENTER);
        contentPane.add(btnBack, BorderLayout.SOUTH);
		contentPane.add(lblAvailable, BorderLayout.NORTH);
       
	}

}
