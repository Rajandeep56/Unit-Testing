package com.currencyconverter;
import java.awt.Font;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class IssuedBooks extends JFrame {
	private JPanel contentPane;
	static IssuedBooks frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new IssuedBooks();
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
	public IssuedBooks() throws IOException {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 700, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(50, 50, 50, 50));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.setBackground(Color.black);
		JLabel lblAvailable = new JLabel("Issued Books");
		lblAvailable.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblAvailable.setForeground(Color.white);
		
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
		BufferedReader reader = new BufferedReader(new FileReader("src/Files/Books.csv"));
        String line = "";
       
        while ((line = reader.readLine()) != null) {
            String[] cols = line.split(",");
			
			if(cols[5].equals( "Issued")){
                   // textArea.append("test");}
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
		JScrollPane sp=new JScrollPane(textArea);
		
		contentPane.add(sp, BorderLayout.CENTER);
        contentPane.add(btnBack, BorderLayout.SOUTH);
		contentPane.add(lblAvailable, BorderLayout.NORTH);
       
	}

}

