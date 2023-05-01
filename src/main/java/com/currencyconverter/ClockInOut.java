package com.currencyconverter;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.Duration;
import java.time.Instant;
import java.awt.event.ActionEvent;

//import org.apache.commons.lang.time.StopWatch;

public class ClockInOut extends JFrame {
	static ClockInOut frame;
	private JPanel contentPane;
	boolean status = false;
	
	Instant startTime, endTime;
    Duration duration;
    boolean isRunning = false;
	long totalTime, minutes, secs;
	JLabel lblNewLabel3 = new JLabel("Note: You Are Not Clocked In Yet");
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new ClockInOut();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void start() {
        if (isRunning) {
            throw new RuntimeException("Stopwatch is already running.");
        }
        this.isRunning = true;
       startTime = Instant.now();
    }

    public Duration stop() {
        this.endTime = Instant.now();
        if (!isRunning) {
            throw new RuntimeException("Stopwatch has not been started yet");
        }
        isRunning = false;
        Duration result = Duration.between(startTime, endTime);
        if (this.duration == null) {
            this.duration = result;
        } else {
            this.duration = duration.plus(result);
        }

        return this.getElapsedTime();
    }

    public Duration getElapsedTime() {
        return this.duration;
    }

    public void reset() {
        if (this.isRunning) {
            this.stop();
        }
        this.duration = null;
    }

	
	public ClockInOut() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setBackground(Color.black);

		JLabel lblNewLabel = new JLabel("Clock Time ");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblNewLabel.setForeground(Color.white);
		
		
		JButton btnClockIn = new JButton("Clock In");
		btnClockIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			
			status = true;
			start() ;
			
			}
		});
		
		JButton breakTime = new JButton("Break Time");

		breakTime.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if(status == true){
					
					stop() ;
					totalTime=getElapsedTime().toMillis()/1000L;
					minutes = (totalTime % 360)/60;
					 secs = totalTime %60;
					System.out.println( secs);
					//String test = Long.toString(minutes); 
					// lblNewLabel3.setText("Your total hours of work till now are: "+minutes +" minutes and "+secs +"seconds");
					// lblNewLabel3.setFont(new Font("Time New Roman", Font.PLAIN, 13));
					// lblNewLabel3.setForeground(Color.white);
					JOptionPane.showMessageDialog(ClockInOut.this,"Your total hours of work till now are: "+minutes +" minutes and "+secs +"seconds");


		
	}
				else{
					JOptionPane.showMessageDialog(ClockInOut.this,"Clockin first");
				}
				
	}
	
	});
	JButton ClockOut = new JButton("Clock Out");
	ClockOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(status ==true){
				status =false;
				reset();
				lblNewLabel3.setText("You Are Not Clocked In Yet");
				lblNewLabel3.setForeground(Color.RED);

				JOptionPane.showMessageDialog(ClockInOut.this,"your total hours has been send to Payroll Department");}
				else {
					JOptionPane.showMessageDialog(ClockInOut.this,"Clockin first");

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
					.addGap(190)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.CENTER)
					.addGap(120)
						.addComponent(lblNewLabel)
						.addGap(190)
						.addComponent(btnClockIn, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
						.addComponent(breakTime, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
						.addComponent(ClockOut, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel3, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
                      //  .addComponent(clockinBtn, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
					  

                        )
					.addContainerGap(101, Short.MAX_VALUE))
		);

		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGap(120)
					.addComponent(lblNewLabel)
					.addGap(50)
					.addComponent(btnClockIn, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(breakTime, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(ClockOut, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
                    .addComponent(lblNewLabel3, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                    .addGap(18)
                    .addGap(18)
				//	.addComponent(btnLogout, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					

                    .addContainerGap(16, Short.MAX_VALUE))
		);

		contentPane.setLayout(gl_contentPane);
	}
}
