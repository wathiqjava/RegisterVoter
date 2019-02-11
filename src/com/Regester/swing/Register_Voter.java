package com.Regester.swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JScrollBar;
import javax.swing.border.BevelBorder;
import java.awt.Toolkit;

public class Register_Voter  {

	public JFrame frame;
	private JTextField textVidS;
	private JTextField textNameS;
	private JTextField txtvid;
	private JTextField textName;
	private JTextField textAge;
	private JTextField textEmail;
	private JTextField textType;
	private JTextField textPcid;
	private JTextField textVidU;
	private JTextField textNameU;
	private JTextField textageU;
	private JTextField textEmailU;
	private JTextField textTypeU;
	private JTextField textPcidU;
	private JTextField textVidD;
	private JTextField textNameD;
	private static int userid;
    private JTextField txtvote;
    
    Operation op;
    LocalDate d = java.time.LocalDate.now();
    private JTable table;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register_Voter window = new Register_Voter(userid);
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
	public Register_Voter(int userid2) {
		userid=userid2;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Zara'a\\Downloads\\Edit-validated-icon.png"));
		frame.setBounds(100, 100, 835, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(new Color(218, 165, 32));
		frame.getContentPane().add(tabbedPane, "name_105973954100531");
		

		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(new Color(255, 255, 255));
		panel_1.setBackground(new Color(255, 248, 220));
		tabbedPane.addTab("NewRegister", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Voter Number");
		lblNewLabel_1.setBounds(10, 48, 105, 21);
		panel_1.add(lblNewLabel_1);
		
		txtvid = new JTextField();
		txtvid.setBounds(125, 41, 187, 35);
		panel_1.add(txtvid);
		txtvid.setColumns(10);
		
		JLabel lblFullName_1 = new JLabel("Full Name");
		lblFullName_1.setBounds(10, 87, 105, 21);
		panel_1.add(lblFullName_1);
		
		textName = new JTextField();
		textName.setColumns(10);
		textName.setBounds(125, 80, 187, 35);
		panel_1.add(textName);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setBounds(10, 126, 87, 21);
		panel_1.add(lblAge);
		
		textAge = new JTextField();
		textAge.setColumns(10);
		textAge.setBounds(125, 119, 187, 35);
		panel_1.add(textAge);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 165, 87, 21);
		panel_1.add(lblEmail);
		
		textEmail = new JTextField();
		textEmail.setColumns(10);
		textEmail.setBounds(125, 158, 187, 35);
		panel_1.add(textEmail);
		
		JLabel lblType = new JLabel("Type");
		lblType.setBounds(10, 204, 87, 21);
		panel_1.add(lblType);
		
		textType = new JTextField();
		textType.setColumns(10);
		textType.setBounds(125, 197, 187, 35);
		panel_1.add(textType);
		
		JLabel lblPcid = new JLabel("PCId");
		lblPcid.setBounds(10, 243, 87, 21);
		panel_1.add(lblPcid);
		
		textPcid = new JTextField();
		textPcid.setColumns(10);
		textPcid.setBounds(125, 236, 187, 35);
		panel_1.add(textPcid);
		
		JButton btnNewButton = new JButton("Register");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (!(textName.getText().isEmpty()) || !(txtvid.getText().isEmpty()) || !(textAge.getText().isEmpty())|| !(textEmail.getText().isEmpty())|| !(textPcid.getText().isEmpty())|| !(textType.getText().isEmpty())) 
				{
				
				op=new Operation();
				int chk= op.Insert(Integer.parseInt(txtvid.getText().trim()),textName.getText().trim(),Integer.parseInt(textAge.getText().trim()),textEmail.getText().trim(),textType.getText().trim(),Integer.parseInt(textPcid.getText().trim()),userid,d.toString());
			 	
		     	JOptionPane.showMessageDialog(null, chk);
				if (chk ==1) {
					JOptionPane.showMessageDialog(null, "Inserted successfully ");
				}else 
				{
					JOptionPane.showMessageDialog(null, "Inserted Failed !");
				}
				}else {
					JOptionPane.showMessageDialog(null, "Please Fill Text !");
				}
			}
		});
		btnNewButton.setBounds(413, 273, 89, 23);
		panel_1.add(btnNewButton);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Update", null, panel_2, null);
		panel_2.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("Update");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		btnNewButton_1.setBounds(405, 271, 89, 23);
		panel_2.add(btnNewButton_1);
		
		textVidU = new JTextField();
		textVidU.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!(textNameU.getText().isEmpty()) || !(textVidU.getText().isEmpty()) || !(textageU.getText().isEmpty())|| !(textEmailU.getText().isEmpty())|| !(textPcidU.getText().isEmpty())|| !(textTypeU.getText().isEmpty()) ||(txtvote.getText().isEmpty())) {
					
			try {
					op=new Operation();
					ResultSet rs=	op.get(Integer.parseInt(textVidU.getText().trim()));
					System.out.println(rs);
					textNameU.setText(rs.getString(3));
				    textageU.setText((String.valueOf(rs.getInt(4))));
				    textEmailU.setText(rs.getString(5));
				    textTypeU.setText(String.valueOf(rs.getInt(6)));
				    textPcidU.setText(String.valueOf(rs.getInt(7)));
				    txtvote.setText(String.valueOf(rs.getInt(8)));
				    rs.close();
				}catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Error update  "+ex.getMessage());
				}
			}}
		});


				

/*					int	chk=	op.update(Integer.parseInt(textVidU.getText().trim()),textNameU.getText().trim(),Integer.parseInt(textageU.getText().trim()),textEmailU.getText().trim(),textTypeU.getText().trim(),Integer.parseInt(textPcidU.getText().trim()),userid,d.toString(),txtvote.getText().trim());
				if (chk ==1) {
					JOptionPane.showMessageDialog(null, "Inserted successfully ");
				}else 
				{
					JOptionPane.showMessageDialog(null, "Inserted Failed !");
				}
				}
			else {
				JOptionPane.showMessageDialog(null, "Please Fill Text !");
			}*/
			

		textVidU.setColumns(10);
		textVidU.setBounds(150, 25, 187, 35);
		panel_2.add(textVidU);
		
		JLabel label = new JLabel("Voter Number");
		label.setBounds(35, 32, 87, 21);
		panel_2.add(label);
		
		textNameU = new JTextField();
		textNameU.setColumns(10);
		textNameU.setBounds(150, 64, 187, 35);
		panel_2.add(textNameU);
		
		JLabel label_1 = new JLabel("Full Name");
		label_1.setBounds(35, 71, 87, 21);
		panel_2.add(label_1);
		
		JLabel label_2 = new JLabel("Age");
		label_2.setBounds(35, 110, 87, 21);
		panel_2.add(label_2);
		
		textageU = new JTextField();
		textageU.setColumns(10);
		textageU.setBounds(150, 103, 187, 35);
		panel_2.add(textageU);
		
		textEmailU = new JTextField();
		textEmailU.setColumns(10);
		textEmailU.setBounds(150, 142, 187, 35);
		panel_2.add(textEmailU);
		
		JLabel label_3 = new JLabel("Email");
		label_3.setBounds(35, 149, 87, 21);
		panel_2.add(label_3);
		
		JLabel label_4 = new JLabel("Type");
		label_4.setBounds(35, 188, 87, 21);
		panel_2.add(label_4);
		
		textTypeU = new JTextField();
		textTypeU.setColumns(10);
		textTypeU.setBounds(150, 181, 187, 35);
		panel_2.add(textTypeU);
		
		textPcidU = new JTextField();
		textPcidU.setColumns(10);
		textPcidU.setBounds(150, 220, 187, 35);
		panel_2.add(textPcidU);
		
		JLabel label_5 = new JLabel("PCId");
		label_5.setBounds(35, 227, 87, 21);
		panel_2.add(label_5);
		
		txtvote = new JTextField();
		txtvote.setColumns(10);
		txtvote.setBounds(150, 259, 187, 35);
		panel_2.add(txtvote);
		
		JLabel lblvote = new JLabel("Vote");
		lblvote.setBounds(35, 269, 87, 21);
		panel_2.add(lblvote);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(128, 128, 128));
		tabbedPane.addTab("Delete", null, panel_3, null);
		panel_3.setLayout(null);
		
		textVidD = new JTextField();
		textVidD.setColumns(10);
		textVidD.setBounds(207, 31, 187, 39);
		panel_3.add(textVidD);
		
		JLabel label_6 = new JLabel("Voter Number");
		label_6.setBounds(47, 38, 97, 25);
		panel_3.add(label_6);
		
		textNameD = new JTextField();
		textNameD.setColumns(10);
		textNameD.setBounds(207, 81, 187, 39);
		panel_3.add(textNameD);
		
		JLabel label_7 = new JLabel("Full Name");
		label_7.setBounds(67, 93, 46, 14);
		panel_3.add(label_7);
		
		JButton button = new JButton("Search");
		button.setBounds(316, 200, 89, 23);
		panel_3.add(button);
		
		
		JButton btnNewButton_2 = new JButton("Delete");
		btnNewButton_2.setBounds(35, 200, 89, 23);
		panel_3.add(btnNewButton_2);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Search", null, panel, null);
		panel.setLayout(null);
		
		textVidS = new JTextField();
		textVidS.setBounds(193, 22, 187, 39);
		panel.add(textVidS);
		textVidS.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Voter Number");
		lblNewLabel.setBounds(33, 29, 97, 25);
		panel.add(lblNewLabel);
		
		JLabel lblFullName = new JLabel("Full Name");
		lblFullName.setBounds(53, 84, 46, 14);
		panel.add(lblFullName);
		
		textNameS = new JTextField();
		textNameS.setBounds(193, 72, 187, 39);
		textNameS.setColumns(10);
		panel.add(textNameS);
		table = new JTable();
		table.setBounds(22, 198, 481, 97);
		panel.add(table);
		JButton btnsearch = new JButton("SearchPerson");
		btnsearch.setBounds(418, 120, 125, 39);
		btnsearch.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
			
				op=new Operation();
				int x = Integer.parseInt(textVidS.getText().trim());
				ResultSet chk= op.get(x);
		     	if (chk !=null) {
					JOptionPane.showMessageDialog(null, "Login successfully ! \n"+ "Hi "+chk);
					table.setModel(DbUtils.resultSetToTableModel(chk));
					//table.addMouseListener(new java.awt.event.MouseAdapter() {}
						
					
					
				}else 
				{
					JOptionPane.showMessageDialog(null, "Failed successfully !");
				}
		}});
		panel.add(btnsearch);
		


	}
}
