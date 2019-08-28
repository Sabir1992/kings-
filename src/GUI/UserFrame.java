package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DaoImplClass.SaleDaoImpl;
import DaoImplClass.LoginDaoImpl;
import DaoImplClass.UserDaoImpl;
import DaoInterface.SaleDao;
import DaoInterface.LoginDao;
import DaoInterface.UserDao;
import Model.Menu;
import Model.Users;
import Service.KingService;
import Service.KingServiceImpl;
import Service.LoginService;
import Service.LoginServiceImpl;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Color;
import java.awt.Font;

public class UserFrame extends JFrame {

	 private JPanel contentPane;
	 private JTextField textField,textField_1,textField_2,textField_3,textField_4,textField_5;
	 JLabel label;
	
	 UserDao userDao = new UserDaoImpl();
     KingService kingService = new KingServiceImpl(userDao);

	
	public UserFrame() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				label.setText(Users.getWhoIs());
			}
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 381, 278);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(112, 128, 144));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(10, 11, 144, 21);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(10, 36, 144, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblPosition = new JLabel("Position");
		lblPosition.setForeground(new Color(255, 255, 255));
		lblPosition.setBounds(10, 67, 144, 21);
		contentPane.add(lblPosition);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(10, 92, 144, 20);
		contentPane.add(textField_1);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(new Color(255, 255, 255));
		lblPassword.setBounds(10, 123, 144, 21);
		contentPane.add(lblPassword);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(10, 148, 144, 20);
		contentPane.add(textField_2);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setForeground(new Color(255, 255, 255));
		lblPhone.setBounds(211, 11, 144, 21);
		contentPane.add(lblPhone);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(211, 36, 144, 20);
		contentPane.add(textField_3);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setForeground(new Color(255, 255, 255));
		lblAddress.setBounds(211, 67, 144, 21);
		contentPane.add(lblAddress);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(211, 92, 144, 20);
		contentPane.add(textField_4);
		
		JLabel lblActive = new JLabel("Active");
		lblActive.setForeground(new Color(255, 255, 255));
		lblActive.setBounds(211, 123, 144, 21);
		contentPane.add(lblActive);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(211, 148, 144, 20);
		contentPane.add(textField_5);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAdd.setForeground(new Color(112, 128, 144));
		btnAdd.setBackground(new Color(255, 255, 255));
		btnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String userName=textField.getText();
				String position=textField_1.getText();
				String password=textField_2.getText();
				String phone=textField_3.getText();
				String address=textField_4.getText();
				String active=textField_5.getText();
				
				Users user=new Users();
				user.setUserName(userName);
				user.setPosition(position);
				user.setPassword(password);
				user.setPhone(Integer.parseInt(phone));
				user.setAddress(address);
				user.setActive(Integer.parseInt(active));
				
				try {
					boolean isAdded = kingService.addUser(user);
					if(isAdded) {
						JOptionPane.showMessageDialog(null, "User has been successfully added!");
						dispose();
					}else {
						JOptionPane.showMessageDialog(null, "Problem! User has not been successfully added!");
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnAdd.setBounds(266, 208, 89, 23);
		contentPane.add(btnAdd);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setForeground(new Color(112, 128, 144));
		btnUpdate.setBackground(new Color(255, 255, 255));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String userName=textField.getText();
					String position=textField_1.getText();
					String password=textField_2.getText();
					String phone=textField_3.getText();
					String address=textField_4.getText();
					String active=textField_5.getText();
					
					Users user=new Users();
					user.setUserName(userName);
					user.setPosition(position);
					user.setPassword(password);
					user.setPhone(Integer.parseInt(phone));
					user.setAddress(address);
					user.setActive(Integer.parseInt(active));
					
					 boolean isUpdated = kingService.updateUser(user);
			            if (isUpdated) {
			                JOptionPane.showMessageDialog(null, "User has been successfully updated!");
			                dispose();
			            } else {
			                JOptionPane.showMessageDialog(null, "Problem! User has not been successfully updated!");
			            }
			        } catch (Exception ex) {
			            ex.printStackTrace();
			        }
			}
		});
		btnUpdate.setBounds(266, 197, 89, 23);
		contentPane.add(btnUpdate);
		
		label = new JLabel("");
		label.setForeground(new Color(255, 255, 255));
		label.setFont(new Font("Tahoma", Font.BOLD, 25));
		label.setBounds(10, 192, 203, 39);
		contentPane.add(label);
	}
}
