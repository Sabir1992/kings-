package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DaoImplClass.SaleDaoImpl;
import DaoImplClass.LoginDaoImpl;
import DaoImplClass.MenuDaoImpl;
import DaoInterface.SaleDao;
import DaoInterface.LoginDao;
import DaoInterface.MenuDao;
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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MenuFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1,textField_2,textField_3,textField_4,textField_5,textField_6;
	        JLabel lblNewLabel,lblGdvd;
	public JButton button_1,button_2,button;
	private int selectedId;
	        MenuDao menuDao = new MenuDaoImpl();
	        KingService kingService = new KingServiceImpl(menuDao);
	        
	        public MenuFrame(int selectedId,KingService kingService) {
	            initialComponent();
	            lblNewLabel.setText(Users.getWhoIs());
	        	this.selectedId=selectedId;
	        	this.kingService=kingService;
	        }
	

	public MenuFrame() {
		initialComponent();
		lblNewLabel.setText(Users.getWhoIs());
	}
	private void initialComponent() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 374, 283);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(112, 128, 144));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblProductName = new JLabel("Product name");
		lblProductName.setForeground(new Color(255, 255, 255));
		lblProductName.setBounds(10, 11, 144, 21);
		contentPane.add(lblProductName);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(10, 36, 144, 20);
		contentPane.add(textField_1);
		
		JLabel lblProductType = new JLabel("Product type");
		lblProductType.setForeground(new Color(255, 255, 255));
		lblProductType.setBounds(10, 67, 144, 21);
		contentPane.add(lblProductType);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(10, 92, 144, 20);
		contentPane.add(textField_2);
		
		JLabel lblPaymentAmount = new JLabel("Payment amount");
		lblPaymentAmount.setForeground(new Color(255, 255, 255));
		lblPaymentAmount.setBounds(204, 11, 144, 21);
		contentPane.add(lblPaymentAmount);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(204, 36, 144, 20);
		contentPane.add(textField_3);
		
		JLabel lblDescription = new JLabel("Description");
		lblDescription.setForeground(new Color(255, 255, 255));
		lblDescription.setBounds(204, 67, 144, 21);
		contentPane.add(lblDescription);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(204, 92, 144, 20);
		contentPane.add(textField_4);
		
		JLabel lblActive = new JLabel("Active");
		lblActive.setForeground(new Color(255, 255, 255));
		lblActive.setBounds(204, 123, 144, 21);
		contentPane.add(lblActive);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(204, 148, 144, 20);
		contentPane.add(textField_5);
		
		JLabel lblPurchaseAmount = new JLabel("Purchase amount");
		lblPurchaseAmount.setForeground(new Color(255, 255, 255));
		lblPurchaseAmount.setBounds(10, 123, 144, 21);
		contentPane.add(lblPurchaseAmount);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(10, 148, 144, 20);
		contentPane.add(textField_6);
		
		button = new JButton("Add");
		button.setForeground(new Color(112, 128, 144));
		button.setBackground(new Color(255, 255, 255));
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String userName=lblNewLabel.getText();
				String productName=textField_1.getText();
				String productType=textField_2.getText();
				String purchaseAmount=textField_6.getText();
				String paymentAmount=textField_3.getText();
				String description=textField_4.getText();
				String active=textField_5.getText();
				
				Menu menu=new Menu();
			    menu.setUserName(userName);
				menu.setProductName(productName);
				menu.setProductType(productType);
				menu.setPurchaseAmount(Float.parseFloat(purchaseAmount));
				menu.setPaymentAmount(Float.parseFloat(paymentAmount));
				menu.setDescription(description);
				menu.setActive(Integer.parseInt(active));
				try {
					boolean isAdded = kingService.addMenu(menu);
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
		button.setBounds(259, 200, 89, 23);
		contentPane.add(button);
	    button_1 = new JButton("Update");
		button_1.setForeground(new Color(112, 128, 144));
		button_1.setBackground(new Color(255, 255, 255));
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				try {
				String userName=lblNewLabel.getText();
				String productName=textField_1.getText();
				String productType=textField_2.getText();
				String purchaseAmount=textField_6.getText();
				String paymentAmount=textField_3.getText();
				String description=textField_4.getText();
				String active=textField_5.getText();
				
				Menu menu=new Menu();
				menu.setUserName(userName);
				menu.setProductName(productName);
				menu.setProductType(productType);
				menu.setPurchaseAmount(Float.parseFloat(purchaseAmount));
				menu.setPaymentAmount(Float.parseFloat(paymentAmount));
				menu.setDescription(description);
				menu.setActive(Integer.parseInt(active));
				
				 boolean isUpdated = kingService.updateMenu(menu,selectedId);
		            if (isUpdated) {
		                JOptionPane.showMessageDialog(null, "Product has been successfully updated!");
		                dispose();
		            } else {
		                JOptionPane.showMessageDialog(null, "Problem! Product has not been successfully updated!");

		            }
		        } catch (Exception ex) {
		            ex.printStackTrace();
		        }

			}
		});
		button_1.setBounds(259, 200, 89, 23);
		contentPane.add(button_1);
		
		button_2 = new JButton("Delete");
		button_2.setForeground(new Color(112, 128, 144));
		button_2.setBackground(new Color(255, 255, 255));
		button_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				try {
					String userName=lblNewLabel.getText();
					String productName=textField_1.getText();
					String productType=textField_2.getText();
					String purchaseAmount=textField_6.getText();
					String paymentAmount=textField_3.getText();
					String description=textField_4.getText();
					String active=textField_5.getText();
					
					Menu menu=new Menu();
					menu.setUserName(userName);
					menu.setProductName(productName);
					menu.setProductType(productType);
					menu.setPurchaseAmount(Float.parseFloat(purchaseAmount));
					menu.setPaymentAmount(Float.parseFloat(paymentAmount));
					menu.setDescription(description);
					menu.setActive(Integer.parseInt(active));
					
					 boolean isDeleted = kingService.deleteMenu(selectedId);
			            if (isDeleted) {
			                JOptionPane.showMessageDialog(null, "Product has been successfully deleted!");
			                dispose();
			            } else {
			                JOptionPane.showMessageDialog(null, "Problem! Product has not been successfully deleted!");

			            }
			        } catch (Exception ex) {
			            ex.printStackTrace();
			        }
			}
		});
		button_2.setBounds(259, 200, 89, 23);
		contentPane.add(button_2);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel.setBounds(10, 200, 144, 37);
		contentPane.add(lblNewLabel);
	}

	
}
