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
	        JTextField textFieldProductName,textFieldProductType,textFieldPaymentAmount,
	        textFieldDescription,textFieldActive,textFieldPurchaseAmount,textFieldId,textField;
	        JLabel lblNewLabel,lblGdvd,lblProductType,lblProductName,lblPaymentAmount,
	        lblDescription,lblActive,lblPurchaseAmount,lblId;
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
		
		lblProductName = new JLabel("Product name");
		lblProductName.setForeground(new Color(255, 255, 255));
		lblProductName.setBounds(10, 11, 144, 21);
		contentPane.add(lblProductName);
		
		textFieldProductName = new JTextField();
		textFieldProductName.setColumns(10);
		textFieldProductName.setBounds(10, 36, 144, 20);
		contentPane.add(textFieldProductName);
		
		lblProductType= new JLabel("Product type");
		lblProductType.setForeground(new Color(255, 255, 255));
		lblProductType.setBounds(10, 67, 144, 21);
		contentPane.add(lblProductType);
		
		textFieldProductType = new JTextField();
		textFieldProductType.setColumns(10);
		textFieldProductType.setBounds(10, 92, 144, 20);
		contentPane.add(textFieldProductType);
		
		lblPaymentAmount = new JLabel("Payment amount");
		lblPaymentAmount.setForeground(new Color(255, 255, 255));
		lblPaymentAmount.setBounds(204, 11, 144, 21);
		contentPane.add(lblPaymentAmount);
		
		textFieldPaymentAmount = new JTextField();
		textFieldPaymentAmount.setColumns(10);
		textFieldPaymentAmount.setBounds(204, 36, 144, 20);
		contentPane.add(textFieldPaymentAmount);
		
		lblDescription = new JLabel("Description");
		lblDescription.setForeground(new Color(255, 255, 255));
		lblDescription.setBounds(204, 67, 144, 21);
		contentPane.add(lblDescription);
		
		textFieldDescription = new JTextField();
		textFieldDescription.setColumns(10);
		textFieldDescription.setBounds(204, 92, 144, 20);
		contentPane.add(textFieldDescription);
		
		lblActive = new JLabel("Active");
		lblActive.setForeground(new Color(255, 255, 255));
		lblActive.setBounds(204, 123, 144, 21);
		contentPane.add(lblActive);
		
		textFieldActive = new JTextField();
		textFieldActive.setColumns(10);
		textFieldActive.setBounds(204, 148, 144, 20);
		contentPane.add(textFieldActive);
		
		lblPurchaseAmount = new JLabel("Purchase amount");
		lblPurchaseAmount.setForeground(new Color(255, 255, 255));
		lblPurchaseAmount.setBounds(10, 123, 144, 21);
		contentPane.add(lblPurchaseAmount);
		
		textFieldPurchaseAmount = new JTextField();
		textFieldPurchaseAmount.setColumns(10);
		textFieldPurchaseAmount.setBounds(10, 148, 144, 20);
		contentPane.add(textFieldPurchaseAmount);
		
		button = new JButton("Add");
		button.setForeground(new Color(112, 128, 144));
		button.setBackground(new Color(255, 255, 255));
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String userName=lblNewLabel.getText();
				String productName=textFieldProductName.getText();
				String productType=textFieldProductType.getText();
				String purchaseAmount=textFieldPurchaseAmount.getText();
				String paymentAmount=textFieldPaymentAmount.getText();
				String description=textFieldDescription.getText();
				String active=textFieldActive.getText();
				
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
				String productName=textFieldProductName.getText();
				String productType=textFieldProductType.getText();
				String purchaseAmount=textFieldPurchaseAmount.getText();
				String paymentAmount=textFieldPaymentAmount.getText();
				String description=textFieldDescription.getText();
				String active=textFieldActive.getText();
				
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
					String productName=textFieldProductName.getText();
					String productType=textFieldProductType.getText();
					String purchaseAmount=textFieldPurchaseAmount.getText();
					String paymentAmount=textFieldPaymentAmount.getText();
					String description=textFieldDescription.getText();
					String active=textFieldActive.getText();
					
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
		lblNewLabel.setBounds(10, 196, 144, 37);
		contentPane.add(lblNewLabel);
		
		lblId = new JLabel("Id");
		lblId.setForeground(Color.WHITE);
		lblId.setBounds(10, 11, 144, 21);
		contentPane.add(lblId);
		
		textFieldId = new JTextField();
		textFieldId.setColumns(10);
		textFieldId.setBounds(10, 36, 144, 20);
		contentPane.add(textFieldId);
	}

	
}
