package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DaoImplClass.ExpenseDaoImpl;
import DaoImplClass.SaleDaoImpl;
import DaoInterface.ExpenseDao;
import DaoInterface.SaleDao;
import Model.Expense;
import Model.Menu;
import Model.Users;
import Service.KingService;
import Service.KingServiceImpl;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Timestamp;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Font;

public class ExpenseFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	JLabel label_1;
	
	
	 ExpenseDao ex=new ExpenseDaoImpl();
	 KingService kingService=new KingServiceImpl(ex);
	

	public ExpenseFrame() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				label_1.setText(Users.getWhoIs());
			}
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 360, 226);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(112, 128, 144));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Username");
		label.setForeground(new Color(255, 255, 255));
		label.setBounds(10, 11, 144, 21);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(10, 36, 144, 20);
		contentPane.add(textField);
		
		JLabel lblExpenseType = new JLabel("Expense type");
		lblExpenseType.setForeground(new Color(255, 255, 255));
		lblExpenseType.setBounds(10, 67, 144, 21);
		contentPane.add(lblExpenseType);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(10, 92, 144, 20);
		contentPane.add(textField_1);
		
		JLabel lblAmount = new JLabel("Amount");
		lblAmount.setForeground(new Color(255, 255, 255));
		lblAmount.setBounds(188, 11, 144, 21);
		contentPane.add(lblAmount);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(188, 36, 144, 20);
		contentPane.add(textField_2);
		
		JLabel lblActive = new JLabel("Active");
		lblActive.setForeground(new Color(255, 255, 255));
		lblActive.setBounds(188, 67, 144, 21);
		contentPane.add(lblActive);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(188, 92, 144, 20);
		contentPane.add(textField_3);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAdd.setBackground(new Color(255, 255, 255));
		btnAdd.setForeground(new Color(112, 128, 144));
		btnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String userName=textField.getText();
				String expenseType=textField_1.getText();
				String amount=textField_2.getText();
				String active=textField_3.getText();
				//ChangeUser
				//ChangeRecordDate
				
				Expense exp=new Expense();
				exp.setUserName(userName);
				exp.setExpenseType(expenseType);
				exp.setAmount(Float.parseFloat(amount));
				exp.setActive(Integer.parseInt(active));
				//
				//
				try {
					boolean isAdded = kingService.addExpense(exp);
					if(isAdded) {
						JOptionPane.showMessageDialog(null, "Success!");
						dispose();
					}else {
						JOptionPane.showMessageDialog(null, "Error!");
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btnAdd.setBounds(243, 136, 89, 23);
		contentPane.add(btnAdd);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBackground(new Color(255, 255, 255));
		btnUpdate.setForeground(new Color(112, 128, 144));
		btnUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				
			}
		});
		btnUpdate.setBounds(243, 136, 89, 23);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBackground(new Color(255, 255, 255));
		btnDelete.setForeground(new Color(112, 128, 144));
		btnDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				
				
			}
		});
		btnDelete.setBounds(243, 136, 89, 23);
		contentPane.add(btnDelete);
		
		label_1 = new JLabel("");
		label_1.setForeground(new Color(255, 255, 255));
		label_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		label_1.setBounds(10, 140, 144, 40);
		contentPane.add(label_1);
	}
}
