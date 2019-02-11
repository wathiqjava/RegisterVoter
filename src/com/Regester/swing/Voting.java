package com.Regester.swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Voting {

	private JFrame frame;
	private JTextField txtvid;
	private JLabel lblbarcode;
    Operation op;
    LocalDate d = java.time.LocalDate.now();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Voting window = new Voting();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Voting() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtvid = new JTextField();
		txtvid.setBounds(215, 36, 161, 42);
		frame.getContentPane().add(txtvid);
		txtvid.setColumns(10);
		
		JLabel lblVoterNumber = new JLabel("Voter Number");
		lblVoterNumber.setBounds(30, 42, 116, 31);
		frame.getContentPane().add(lblVoterNumber);
		
		JButton btnVerfication = new JButton("Verfication");
		btnVerfication.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!(txtvid.getText().isEmpty()))	{
				op=new Operation();
				int x = Integer.parseInt(txtvid.getText().trim());
				ResultSet chk= op.get(x);
				
				try {
				
		     	if (chk !=null) {
					JOptionPane.showMessageDialog(null,"ok");
					lblbarcode.setText("|||||||||||||||");	
									
				}else 
				{
					JOptionPane.showMessageDialog(null, "Failed if !");
				}
				}catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Failed voter !");
				}

			}
			else {
				JOptionPane.showMessageDialog(null, "Text Empty please Enter VoterId  !");
			}}
		});
		btnVerfication.setBounds(296, 105, 89, 23);
		frame.getContentPane().add(btnVerfication);
		
		lblbarcode = new JLabel("Barcode");
		lblbarcode.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblbarcode.setBounds(30, 85, 154, 43);
		frame.getContentPane().add(lblbarcode);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("PARTY 1");
		rdbtnNewRadioButton.setBounds(30, 135, 109, 23);
		frame.getContentPane().add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("PARTY 2");
		rdbtnNewRadioButton_1.setBounds(30, 170, 109, 23);
		frame.getContentPane().add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("PARTY 3");
		rdbtnNewRadioButton_2.setBounds(30, 210, 109, 23);
		frame.getContentPane().add(rdbtnNewRadioButton_2);
		
		JButton btnVote = new JButton("Vote");
		btnVote.setBounds(317, 210, 89, 23);
		frame.getContentPane().add(btnVote);
	}
}
