package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DaoImplClass.MenuDaoImpl;
import DaoImplClass.TableDaoImpl;
import DaoInterface.MenuDao;
import DaoInterface.TableDao;
import Model.Menu;
import Service.KingService;
import Service.KingServiceImpl;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TableFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	static JButton btnAdd;
	static JButton btnUpdate;
	JComboBox comboBox,comboBox_1,comboBox_2;

	TableDao tableDao = new TableDaoImpl();
    KingService kingTable = new KingServiceImpl(tableDao);
    private JLabel lblTablename;
    
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TableFrame frame = new TableFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TableFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 315, 242);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(112, 128, 144));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(10, 44, 135, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("TableNumber");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(10, 11, 135, 22);
		contentPane.add(lblNewLabel);
		
		JLabel lblTablestatus = new JLabel("TableStatus");
		lblTablestatus.setForeground(new Color(255, 255, 255));
		lblTablestatus.setBounds(10, 75, 135, 22);
		contentPane.add(lblTablestatus);
		
		JLabel lblActive = new JLabel("Active");
		lblActive.setForeground(new Color(255, 255, 255));
		lblActive.setBounds(155, 75, 135, 22);
		contentPane.add(lblActive);
		
		btnUpdate = new JButton("Update");
		btnUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		btnUpdate.setForeground(new Color(112, 128, 144));
		btnUpdate.setBackground(new Color(255, 255, 255));
		btnUpdate.setBounds(204, 156, 86, 36);
		contentPane.add(btnUpdate);
		
		btnAdd = new JButton("Add");
		btnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int tableNumber = Integer.parseInt(textField.getText());
				String tableStatus = (String) comboBox.getSelectedItem();
				String tableName=(String) comboBox_2.getSelectedItem();
				int active = Integer.parseInt((String) comboBox_1.getSelectedItem());

				Model.Tables tables = new Model.Tables();
				tables.setTableNumber(tableNumber);
				tables.setTableStatus(tableStatus);
				tables.setTableName(tableName);
				tables.setActive(active);
				try {
					boolean isAdded = kingTable.addTable(tables);
					if (isAdded) {
						JOptionPane.showMessageDialog(null, "Success!");
						dispose();
					} else {
						JOptionPane.showMessageDialog(null, "Error!");
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnAdd.setForeground(new Color(112, 128, 144));
		btnAdd.setBackground(new Color(255, 255, 255));
		btnAdd.setBounds(204, 156, 86, 36);
		contentPane.add(btnAdd);
		
		JLabel label = new JLabel("");
		label.setBackground(new Color(112, 128, 144));
		label.setBounds(10, 156, 184, 36);
		contentPane.add(label);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "Open", "Closed", "Reserved"}));
		comboBox.setBounds(10, 107, 135, 22);
		contentPane.add(comboBox);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"", "0", "1"}));
		comboBox_1.setBounds(155, 107, 135, 22);
		contentPane.add(comboBox_1);
		
		lblTablename = new JLabel("TableName");
		lblTablename.setForeground(Color.WHITE);
		lblTablename.setBounds(155, 11, 135, 22);
		contentPane.add(lblTablename);
		
		comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"", "Zal-1", "Zal-2", "Otaq"}));
		comboBox_2.setBounds(155, 43, 135, 22);
		contentPane.add(comboBox_2);
	}
}
