package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import DaoImplClass.ExpenseDaoImpl;
import DaoImplClass.MenuDaoImpl;
import DaoImplClass.SaleDaoImpl;
import DaoImplClass.TableDaoImpl;
import DaoImplClass.UserDaoImpl;
import DaoInterface.ExpenseDao;
import DaoInterface.MenuDao;
import DaoInterface.SaleDao;
import DaoInterface.TableDao;
import DaoInterface.UserDao;
import Model.Expense;
import Model.Menu;
import Model.Sale;
import Model.Users;
import Service.KingService;
import Service.KingServiceImpl;
import Util.LogOut;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JToggleButton;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import javax.swing.JLabel;

public class AdminFrame extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private String globBtn="test";
    private ExpenseFrame ex;
    private MenuFrame menuFrame;
    private UserFrame us;
            JButton button_1,btnUpdate,btnAdd,btnDelete;
            JLabel lblGdvd;
	
     MenuDao menuDao = new MenuDaoImpl();
	 KingService kingService = new KingServiceImpl(menuDao);
	 UserDao userDao = new UserDaoImpl();
	 KingService kingServ = new KingServiceImpl(userDao);
	 ExpenseDao expenseDao = new ExpenseDaoImpl();
	 KingService kingSer = new KingServiceImpl(expenseDao);
	 SaleDao saleDao = new SaleDaoImpl();
	 KingService kingSale = new KingServiceImpl(saleDao);
	 TableDao tableDao = new TableDaoImpl();
	 KingService kingTable= new KingServiceImpl(tableDao);
	 
	 
	public AdminFrame() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				lblGdvd.setText(Users.getWhoIs());
			}
		});
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1100, 650);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(112, 128, 144));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(112, 128, 144));
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(0, 0, 1084, 58);
		contentPane.add(panel);
		panel.setLayout(null);
		
		btnDelete = new JButton("Delete");
		btnDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int selectedRow=table.getSelectedRow();
				int selectedId=(int)table.getValueAt(selectedRow,0);
				
				switch (globBtn) {
	            case "MenuList":
	            	menuFrame = new MenuFrame(selectedId,kingService);
	                menuFrame.button_1.setVisible(false);
	                menuFrame.button.setVisible(false);
	                menuFrame.lblProductName.setVisible(false);
	                menuFrame.textFieldProductName.setVisible(false);
	                menuFrame.lblProductType.setVisible(false);
	                menuFrame.textFieldProductType.setVisible(false);
	                menuFrame.lblPaymentAmount.setVisible(false);
	                menuFrame.textFieldPaymentAmount.setVisible(false);
	                menuFrame.lblDescription.setVisible(false);
	                menuFrame.textFieldDescription.setVisible(false);
	                menuFrame.lblPurchaseAmount.setVisible(false);
	                menuFrame.textFieldPurchaseAmount.setVisible(false);
	                menuFrame.lblActive.setVisible(false);
	                menuFrame.textFieldActive.setVisible(false);
	                //menuFrame.lblId.setVisible(true);
	                //menuFrame.textFieldId.setVisible(true);
	                menuFrame.setVisible(true);
	                if(ex!=null)
	                ex.dispose();
	                break;
	            case "UserList":
	            	us=new UserFrame();
	            	us.setVisible(true);
	            	ex.dispose();
	                break;
	            case "SaleList":

	                break;
	            case "ExpenseList":
	                 ex = new ExpenseFrame();
	                 ex.setVisible(true);
	                 menuFrame.dispose();
	                 us.dispose();
	                break;
//	            case "TableList":
//	            	TableFrame tbf=new TableFrame();
//	            	tbf.setVisible(true);
//	            	if(ex!=null)
//	            	ex.dispose();
//	            	if(us!=null)
//	            	us.dispose();
//	            	if(menuFrame!=null)
//	            	menuFrame.dispose();
//	                break;
	            default:
	                JOptionPane.showMessageDialog(null, "Please , select menu!", "Warning", JOptionPane.WARNING_MESSAGE);
	        }
			}
		});
		btnDelete.setBackground(new Color(255, 255, 255));
		btnDelete.setForeground(new Color(112, 128, 144));
		btnDelete.setBounds(256, 11, 113, 23);
		panel.add(btnDelete);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int selectedRow=table.getSelectedRow();
				int selectedId=(int)table.getValueAt(selectedRow,0);
				
				switch (globBtn) {
	            case "MenuList":
	            	menuFrame = new MenuFrame(selectedId,kingService);
	                menuFrame.button.setVisible(false);
	                menuFrame.button_2.setVisible(false);
	                menuFrame.lblId.setVisible(false);
	                menuFrame.textFieldId.setVisible(false);
	                menuFrame.setVisible(true);
	                if(ex!=null)
	                ex.dispose();
	                break;
	            case "UserList":
	            	us=new UserFrame();
	            	us.setVisible(true);
	            	if(ex!=null)
	            	ex.dispose();
	                break;
	            case "SaleList":

	                break;
	            case "ExpenseList":
	                ex = new ExpenseFrame();
	                ex.setVisible(true);
	                menuFrame.dispose();
	                if(us!=null)
	                us.dispose();
	                break;
	            case "TableList":
	            	TableFrame tbf=new TableFrame();
	            	TableFrame.btnAdd.setVisible(false);
	            	tbf.setVisible(true);
	            	if(ex!=null)
	            	ex.dispose();
	            	if(us!=null)
	            	us.dispose();
	            	if(menuFrame!=null)
	            	menuFrame.dispose();
	                break;
	            default:
	                JOptionPane.showMessageDialog(null, "Please , select menu!", "Warning", JOptionPane.WARNING_MESSAGE);
	        }
			}
		});
		btnUpdate.setBackground(new Color(255, 255, 255));
		btnUpdate.setForeground(new Color(112, 128, 144));
		btnUpdate.setBounds(133, 11, 113, 23);
		panel.add(btnUpdate);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBackground(new Color(255, 255, 255));
		btnAdd.setForeground(new Color(112, 128, 144));
		btnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				switch (globBtn) {
	            case "MenuList":
	                menuFrame = new MenuFrame();
	                menuFrame.button_1.setVisible(false);
	                menuFrame.button_2.setVisible(false);
	                menuFrame.lblId.setVisible(false);
	                menuFrame.textFieldId.setVisible(false);
	                menuFrame.setVisible(true);
	                if(ex!=null)
	                ex.dispose();
	                
	                break;
	            case "UserList":
	            	us=new UserFrame();
	            	us.setVisible(true);
	            	ex.dispose();
	                break;
	            case "TableList":
	            	TableFrame tbf=new TableFrame();
	            	TableFrame.btnUpdate.setVisible(false);
	            	tbf.setVisible(true);
	            	if(ex!=null)
	            	ex.dispose();
	            	if(us!=null)
	            	us.dispose();
	            	if(menuFrame!=null)
	            	menuFrame.dispose();
	                break;
	            case "ExpenseList":
	                ex = new ExpenseFrame();
	                ex.setVisible(true);
	                menuFrame.dispose();
	                us.dispose();
	                break;
	            default:
	                JOptionPane.showMessageDialog(null, "Please , select menu!", "Warning", JOptionPane.WARNING_MESSAGE);
	        }
			}
		});
		btnAdd.setBounds(10, 11, 113, 23);
		panel.add(btnAdd);
		
		lblGdvd = new JLabel("");
		lblGdvd.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblGdvd.setBackground(new Color(112, 128, 144));
		lblGdvd.setForeground(new Color(255, 255, 255));
		lblGdvd.setBounds(772, 8, 162, 36);
		panel.add(lblGdvd);
		
		JButton button = new JButton("Log out");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LogOut.LogOutMethod();
			}
		});
		button.setForeground(new Color(112, 128, 144));
		button.setFont(new Font("Tahoma", Font.BOLD, 20));
		button.setBackground(Color.WHITE);
		button.setBounds(944, 8, 130, 36);
		panel.add(button);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(112, 128, 144));
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_1.setBounds(0, 59, 201, 552);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton menuListBtn = new JButton("MenuList");
		menuListBtn.setForeground(new Color(112, 128, 144));
		menuListBtn.setBackground(new Color(255, 255, 255));
		menuListBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ShowMenu();
				globBtn="MenuList";
				btnDelete.setVisible(true);
			}
		});
		menuListBtn.setBounds(10, 11, 113, 23);
		panel_1.add(menuListBtn);
		
		JButton btnNewButton_1 = new JButton("UserList");
		btnNewButton_1.setForeground(new Color(112, 128, 144));
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ShowUser();
				globBtn="UserList";
				btnDelete.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(10, 43, 113, 23);
		panel_1.add(btnNewButton_1);
		
		JButton btnExpenselist = new JButton("ExpenseList");
		btnExpenselist.setForeground(new Color(112, 128, 144));
		btnExpenselist.setBackground(new Color(255, 255, 255));
		btnExpenselist.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ShowExpense();
				globBtn="ExpenseList";
				btnDelete.setVisible(true);
			}
		});
		btnExpenselist.setBounds(10, 77, 113, 23);
		panel_1.add(btnExpenselist);
		
		JButton btnSalelist = new JButton("SaleList");
		btnSalelist.setForeground(new Color(112, 128, 144));
		btnSalelist.setBackground(new Color(255, 255, 255));
		btnSalelist.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ShowSale();
				globBtn="SaleList";
				btnDelete.setVisible(true);
			}
		});
		btnSalelist.setBounds(10, 109, 113, 23);
		panel_1.add(btnSalelist);
		
		JButton btnTablelist = new JButton("TableList");
		btnTablelist.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ShowTables();
				globBtn="TableList";
				btnDelete.setVisible(false);
			}
		});
		btnTablelist.setForeground(new Color(112, 128, 144));
		btnTablelist.setBackground(Color.WHITE);
		btnTablelist.setBounds(10, 143, 113, 23);
		panel_1.add(btnTablelist);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(112, 128, 144));
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_2.setBounds(202, 59, 882, 552);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(112, 128, 144));
		scrollPane.setBounds(0, 0,880, 551);
		panel_2.add(scrollPane);
		
		table = new JTable();
		table.setForeground(new Color(255, 255, 255));
		scrollPane.setViewportView(table);
		table.setFont(new Font("Tahoma", Font.BOLD, 12));
		table.setBackground(new Color(112, 128, 144));
	}
	
	private void ShowMenu() {

		try {
			DefaultTableModel dtm = new DefaultTableModel();
			table.setModel(dtm);
			dtm.addColumn("Id");
			dtm.addColumn("UserName");
			dtm.addColumn("ProductName");
			dtm.addColumn("ProductType");
			dtm.addColumn("RecordDate");
			dtm.addColumn("PurchaseAmount");
			dtm.addColumn("PaymentAmount");
			dtm.addColumn("Description");
			dtm.addColumn("Active");

			List<Menu> menuList = kingService.getMenuList();
			for (Menu menu : menuList) {
				Object[] data = new Object[] { menu.getId(), menu.getUserName(), menu.getProductName(),
						menu.getProductType(), menu.getRecordDate(), menu.getPurchaseAmount(), menu.getPaymentAmount(),
						menu.getDescription(), menu.getActive() };
				dtm.addRow(data);
			}
			dtm.fireTableDataChanged();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void ShowSale() {
		try {
			DefaultTableModel dtm = new DefaultTableModel();
			table.setModel(dtm);
			dtm.addColumn("Id");
			dtm.addColumn("UserName");
			dtm.addColumn("ProductName");
			dtm.addColumn("ProductType");
			dtm.addColumn("PurchaseAmount");
			dtm.addColumn("PaymentAmount");
			dtm.addColumn("RecordDate");
			dtm.addColumn("Count");
			dtm.addColumn("Total");
			dtm.addColumn("TableNumber");
			dtm.addColumn("Income");
			dtm.addColumn("Active");

			List<Sale> saleList = kingSale.getSaleList();
			for (Sale sale : saleList) {
				Object[] data = new Object[] { sale.getId(), sale.getUserName(), sale.getProductName(),
						sale.getProductType(), sale.getPurchaseAmount(), sale.getPaymentAmount(),
						sale.getPurchaseAmount(), sale.getPaymentAmount(), sale.getRecordDate(), sale.getCount(),
						sale.getTotal(), sale.getTableNumber(), sale.getIncome(), sale.getActive() };
				dtm.addRow(data);
			}
			dtm.fireTableDataChanged();
		} catch (Exception ec) {
			ec.printStackTrace();
		}

	}
	
	private void ShowUser() {
		try {
			DefaultTableModel dtm = new DefaultTableModel();
			table.setModel(dtm);
			dtm.addColumn("Id");
			dtm.addColumn("UserName");
			dtm.addColumn("RecordDate");
			dtm.addColumn("Position");
			dtm.addColumn("ChangeUser");
			dtm.addColumn("ChangeRecordDate");
			dtm.addColumn("Password");
			dtm.addColumn("Phone");
			dtm.addColumn("Address");
			dtm.addColumn("Active");
			List<Users> userList = kingServ.getUserList();
			for (Users user : userList) {
				Object[] data = new Object[] { user.getId(), user.getUserName(), user.getRecordDate(),
						user.getPosition(), user.getChangeUser(), user.getChangeRecordDate(), user.getPassword(),
						user.getPhone(), user.getAddress(), user.getActive() };
				dtm.addRow(data);
			}
			dtm.fireTableDataChanged();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void ShowExpense() {
		try {
			DefaultTableModel dtm = new DefaultTableModel();
			table.setModel(dtm);
			dtm.addColumn("Id");
			dtm.addColumn("RecordDate");
			dtm.addColumn("UserName");
			dtm.addColumn("ExpenseType");
			dtm.addColumn("Amount");
			dtm.addColumn("ChangeUser");
			dtm.addColumn("ChangeRecordDate");
			dtm.addColumn("Active");

			List<Expense> ExpenseList = kingSer.getExpenseList();
			for (Expense expense : ExpenseList) {
				Object[] data = new Object[] { expense.getId(), expense.getRecordDate(), expense.getUserName(),
						expense.getExpenseType(), expense.getAmount(), expense.getChangeUser(),
						expense.getChangeRecordDate(), expense.getActive() };
				dtm.addRow(data);
			}
			dtm.fireTableDataChanged();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	private void ShowTables() {

		try {
			DefaultTableModel dtm = new DefaultTableModel();
			table.setModel(dtm);
			dtm.addColumn("Id");
			dtm.addColumn("TableNumber");
			dtm.addColumn("TableStatus");
			dtm.addColumn("TableName");
			dtm.addColumn("RecordDate");
			dtm.addColumn("Active");

			List<Model.Tables> tableList = kingTable.getTableList();
			for (Model.Tables tab : tableList) {
				Object[] tableData = new Object[] { tab.getId(), tab.getTableNumber(), tab.getTableStatus(),
						tab.getTableName(),tab.getRecordDate(), tab.getActive() };
				dtm.addRow(tableData);
			}
			dtm.fireTableDataChanged();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
