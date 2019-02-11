package com.Regester.swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.CardLayout;
import javax.swing.JTabbedPane;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class Login  {

	public JFrame frame;
	private JTextField txtname;
	private JTextField txtname2;
	private static Login Window;
	Operation op;
	LocalDate d = java.time.LocalDate.now();
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 Window = new Login();
					Window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("LoginPage");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Zara'a\\Downloads\\Slack_Icon.png"));
		frame.getContentPane().setBackground(new Color(173, 216, 230));
		frame.setBackground(new Color(0, 206, 209));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(Color.ORANGE);
		frame.getContentPane().add(tabbedPane, "name_105455233975931");
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(135, 206, 235));
		tabbedPane.addTab("Register", null, panel_1, null);
		panel_1.setLayout(null);
		
		txtname2 = new JTextField();
		txtname2.setBounds(178, 25, 86, 20);
		panel_1.add(txtname2);
		txtname2.setColumns(10);
		
		JPasswordField txtpass2 = new JPasswordField();
		txtpass2.setBounds(178, 65, 86, 20);
		panel_1.add(txtpass2);
		txtpass2.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("User Name");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(34, 27, 104, 17);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Password");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(34, 66, 91, 14);
		panel_1.add(lblNewLabel_3);
		
		JButton btnRegisterUser = new JButton("Register User");
		btnRegisterUser.setForeground(new Color(165, 42, 42));
		btnRegisterUser.setBackground(new Color(176, 196, 222));
		btnRegisterUser.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnRegisterUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!(txtname2.getText().isEmpty()) || !(txtpass2.getText().isEmpty())) {
				
				op=new Operation();
		     	int chk= op.Insert(txtname2.getText().trim(), txtpass2.getText().trim(),d.toString());
		     	if (chk ==1) {
					JOptionPane.showMessageDialog(null, "Inserted successfully ");
				}else 
				{
					JOptionPane.showMessageDialog(null, "Inserted Failed !");
				}
			}else {
				JOptionPane.showMessageDialog(null, "Please Fill TextField!");
			}
			}
		});
		btnRegisterUser.setBounds(257, 159, 126, 37);
		panel_1.add(btnRegisterUser);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(32, 178, 170));
		tabbedPane.addTab("Login", null, panel, null);
		panel.setLayout(null);
		
		txtname = new JTextField();
		txtname.setBounds(129, 11, 86, 20);
		panel.add(txtname);
		txtname.setColumns(10);
		
		JPasswordField txtpass = new JPasswordField();
		txtpass.setBounds(129, 55, 86, 20);
		panel.add(txtpass);
		txtpass.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("User Name");
		lblNewLabel.setBounds(10, 14, 86, 17);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(10, 58, 75, 14);
		panel.add(lblNewLabel_1);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (!(txtname.getText().isEmpty()) || !(txtpass.getText().isEmpty())) {
				op=new Operation();
		     	int chk= op.login(txtname.getText().trim(), txtpass.getText().trim());
		   	if (chk >0) {
					JOptionPane.showMessageDialog(null, "Login successfully ! \n"+ "Hi "+txtname.getText().trim());
					Window.frame.setVisible(false);
					 Register_Voter Window2 =new Register_Voter(chk);
					 System.out.println(chk);
					Window2.frame.setVisible(true);
				}else 
				{
					JOptionPane.showMessageDialog(null, "Login Failed  !");
				}
				
			}
			else {
				JOptionPane.showMessageDialog(null, "Please Fill Text!");
			}
			
			}});
		btnLogin.setBounds(242, 174, 89, 23);
		panel.add(btnLogin);
	}
}
