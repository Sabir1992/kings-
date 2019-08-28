package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DaoImplClass.SaleDaoImpl;
import DaoImplClass.LoginDaoImpl;
import DaoInterface.SaleDao;
import DaoInterface.LoginDao;
import Model.Users;
import Service.KingService;
import Service.KingServiceImpl;
import Service.LoginService;
import Service.LoginServiceImpl;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginFrame extends JFrame {
	private JTextField textField;
	private JPasswordField passwordField;
	
	
	 SaleDao kingDao = new SaleDaoImpl();
     KingService kingService = new KingServiceImpl(kingDao);
	 LoginDao loginDao = new LoginDaoImpl();
	 LoginService loginService = new LoginServiceImpl(loginDao);
	 private JLabel lblInvalidLoginOr,lblLogOn;
	 private JPanel contentPane;
	 JButton adminBtn;
	 

	public LoginFrame() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(112, 128, 144));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setForeground(new Color(255, 255, 255));
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblLogin.setBounds(35, 44, 119, 28);
		contentPane.add(lblLogin);
		
		textField = new JTextField();
		textField.setBounds(164, 44, 222, 28);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setForeground(new Color(255, 255, 255));
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblPassword.setBounds(35, 83, 119, 28);
		contentPane.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(164, 83, 222, 28);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setForeground(new Color(112, 128, 144));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String username = textField.getText();
		        String password = passwordField.getText();
		        String position=null;
		        try {
		            if (username != null && !username.isEmpty() && password != null && !password.isEmpty()) {
		              Users login = loginService.login(username, password,position);
		              if (login != null) {
		            	  Tables frame = new Tables();
		            	  Users.setWhoIs(username);
		            	  frame.setVisible(true);
		                  dispose();
		              } else {
		            	  lblInvalidLoginOr.setVisible(true);
		            	  lblInvalidLoginOr.setText("Username or password is invalid!");
		            	  textField.setText("");
		            	  passwordField.setText("");
		              }
		         } else {
		        	 lblInvalidLoginOr.setVisible(true);
		        	 lblInvalidLoginOr.setText("Username or password is empty!");
		           	 String user=lblLogOn.getText();
		        	 Users.setWhoIs(username);
		         } 
		         } catch(Exception ex) {
		             ex.printStackTrace();
		         }
		        
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton.setBounds(281, 137, 105, 40);
		contentPane.add(btnNewButton);
		
		lblInvalidLoginOr = new JLabel("Invalid login or password!");
		lblInvalidLoginOr.setForeground(new Color(255, 255, 255));
		lblInvalidLoginOr.setBounds(210, 113, 193, 21);
		contentPane.add(lblInvalidLoginOr);
		lblInvalidLoginOr.setVisible(false);
		
		
	}
}
