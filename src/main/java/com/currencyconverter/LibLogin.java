package com.currencyconverter;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class LibLogin extends JFrame {
	static LibLogin frame;
	private JPanel contentPane;
	JTextField textField;
	JPasswordField passwordField;
	public JButton btnLogin;
	boolean testResult;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new LibLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LibLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 700);
	
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.black);
		setContentPane(contentPane);
		
		JLabel lblAdminLoginForm = new JLabel("Librarian Login Form");
		lblAdminLoginForm.setForeground(Color.white);
		lblAdminLoginForm.setFont(new Font("Tahoma", Font.PLAIN, 32));
		
		JLabel lblEnterName = new JLabel("Enter Name:");
		
		JLabel lblEnterPassword = new JLabel("Enter Password:");
		lblEnterName.setForeground(Color.white);
		lblEnterPassword.setForeground(Color.white);

		textField = new JTextField();
		textField.setColumns(10);
		
		 btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String name=textField.getText();
			String password=String.valueOf(passwordField.getPassword());
			
			//System.out.println(name+" "+password);
			if(ValidateLibrarian.validate(name, password)){
				testResult=true;
				LibLoggedIn.main(new String[]{});
				//frame.dispose();
			}else{
				testResult=false;
				JOptionPane.showMessageDialog(LibLogin.this, "Sorry, Username or Password Error","Login Error!", JOptionPane.ERROR_MESSAGE);
				// textField.setText("");
				// passwordField.setText("");
			}
			}
		});
		
		passwordField = new JPasswordField();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.CENTER)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.CENTER)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(190)
							.addComponent(lblAdminLoginForm))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(190)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.CENTER)
								.addComponent(lblEnterName)
								.addComponent(lblEnterPassword))
							.addGap(47)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.CENTER, false)
								.addComponent(passwordField)
								.addComponent(textField, GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE))))
					.addContainerGap(107, Short.MAX_VALUE))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.CENTER, false)
					
					.addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
					.addGap(151))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.CENTER)
				.addGroup(gl_contentPane.createSequentialGroup()
				.addGap(150)
					.addComponent(lblAdminLoginForm)
					.addGap(50)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.CENTER)
						.addComponent(lblEnterName)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEnterPassword)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(80, Short.MAX_VALUE)
					)
		);
		contentPane.setLayout(gl_contentPane);
	}
}

