package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import DaoImplClass.MenuDaoImpl;
import DaoInterface.MenuDao;
import Model.Users;
import Service.KingService;
import Service.KingServiceImpl;
import Util.ComboPopulate;
import Util.LogOut;
import Util.RemoveTableRow;
import Util.SelectedComboIndex;
import Util.TablePlusMinus;
import Util.TotalPrice;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DefaultComboBoxModel;

public class OrderFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;
	JLabel lblLogOn, label, lblSfsfsf;
	JComboBox comboBox,comboBox_1,comboBox_2;
	String[] columnNames= {"Name","Price","Count","Total"};
	DefaultTableModel dtm=new DefaultTableModel();
	
	MenuDao md=new MenuDaoImpl();
	KingService ks=new KingServiceImpl(md);

	
	public OrderFrame() {
		initialComponents();
	
	}
	
	private void initialComponents() {
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				label.setText(Users.getWhoIs());

				try {
                    comboBox   = ComboPopulate.getMenuProducTypeListCombo(comboBox,   ks.comboadd("Piveler"));
					comboBox_1 = ComboPopulate.getMenuProducTypeListCombo(comboBox_1, ks.comboadd("Cerezler"));
					comboBox_2 = ComboPopulate.getMenuProducTypeListCombo(comboBox_2, ks.comboadd("Yemekler"));
                } catch (Exception e1) {
					e1.printStackTrace();
				}
				dtm.setColumnIdentifiers(columnNames);
				table.setModel(dtm);
            }
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(50, 50, 1000, 650);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(112, 128, 144));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(143, 188, 143));
		scrollPane.setBounds(0, 0, 571, 391);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(112, 128, 144));
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("Piveler");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(790, 11, 184, 25);
		contentPane.add(lblNewLabel);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {""}));
		comboBox.setBackground(new Color(255, 255, 255));
		comboBox.setBounds(680, 40, 294, 25);
		contentPane.add(comboBox);
		
		JLabel lblCerezler = new JLabel("Cerezler");
		lblCerezler.setForeground(new Color(255, 255, 255));
		lblCerezler.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCerezler.setBounds(790, 76, 184, 25);
		contentPane.add(lblCerezler);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {""}));
		comboBox_1.setBackground(new Color(255, 255, 255));
		comboBox_1.setBounds(680, 105, 294, 25);
		contentPane.add(comboBox_1);
		
		////khjhjjkjkjk
		
		JLabel lblYemekler = new JLabel("Yemekler");
		lblYemekler.setForeground(new Color(255, 255, 255));
		lblYemekler.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblYemekler.setBounds(790, 141, 184, 25);
		contentPane.add(lblYemekler);
		
		comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {""}));
		comboBox_2.setBackground(new Color(255, 255, 255));
		comboBox_2.setBounds(680, 170, 294, 25);
		contentPane.add(comboBox_2);
		
		JLabel lblSalatlar = new JLabel("Salatlar");
		lblSalatlar.setForeground(new Color(255, 255, 255));
		lblSalatlar.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblSalatlar.setBounds(790, 206, 184, 25);
		contentPane.add(lblSalatlar);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {""}));
		comboBox_3.setBackground(new Color(255, 255, 255));
		comboBox_3.setBounds(680, 235, 294, 25);
		contentPane.add(comboBox_3);
		
		JLabel lblIckiler = new JLabel("Ickiler");
		lblIckiler.setForeground(new Color(255, 255, 255));
		lblIckiler.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblIckiler.setBounds(790, 271, 184, 25);
		contentPane.add(lblIckiler);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setModel(new DefaultComboBoxModel(new String[] {""}));
		comboBox_4.setBackground(new Color(255, 255, 255));
		comboBox_4.setBounds(680, 300, 294, 25);
		contentPane.add(comboBox_4);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				SelectedComboIndex.DtmAdd(comboBox, table, dtm);
				lblSfsfsf.setText(TotalPrice.GetTotalPrice(table));
			}
		});
		btnNewButton.setForeground(new Color(112, 128, 144));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(581, 40, 89, 25);
		contentPane.add(btnNewButton);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SelectedComboIndex.DtmAdd(comboBox_1, table, dtm);
				lblSfsfsf.setText(TotalPrice.GetTotalPrice(table));
			}
		});
		btnAdd.setForeground(new Color(112, 128, 144));
		btnAdd.setBackground(new Color(255, 255, 255));
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAdd.setBounds(581, 105, 89, 25);
		contentPane.add(btnAdd);
		
		JButton btnAdd_1 = new JButton("Add");
		btnAdd_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SelectedComboIndex.DtmAdd(comboBox_2, table, dtm);
			}
		});
		btnAdd_1.setForeground(new Color(112, 128, 144));
		btnAdd_1.setBackground(new Color(255, 255, 255));
		btnAdd_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAdd_1.setBounds(581, 171, 89, 25);
		contentPane.add(btnAdd_1);
		
		JButton btnAdd_2 = new JButton("Add");
		btnAdd_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SelectedComboIndex.DtmAdd(comboBox, table, dtm);
			}
		});
		btnAdd_2.setForeground(new Color(112, 128, 144));
		btnAdd_2.setBackground(new Color(255, 255, 255));
		btnAdd_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAdd_2.setBounds(581, 236, 89, 25);
		contentPane.add(btnAdd_2);
		
		JButton btnAdd_3 = new JButton("Add");
		btnAdd_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SelectedComboIndex.DtmAdd(comboBox, table, dtm);
			}
		});
		btnAdd_3.setForeground(new Color(112, 128, 144));
		btnAdd_3.setBackground(new Color(255, 255, 255));
		btnAdd_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAdd_3.setBounds(581, 300, 89, 25);
		contentPane.add(btnAdd_3);
		
		JLabel lblDiger = new JLabel("Elave sifaris");
		lblDiger.setForeground(new Color(255, 255, 255));
		lblDiger.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDiger.setBounds(718, 336, 143, 25);
		contentPane.add(lblDiger);
		
		JButton button = new JButton("Add");
		button.setForeground(new Color(112, 128, 144));
		button.setBackground(new Color(255, 255, 255));
		button.setFont(new Font("Tahoma", Font.BOLD, 15));
		button.setBounds(581, 366, 89, 25);
		contentPane.add(button);
		
		textField = new JTextField();
		textField.setBounds(680, 366, 210, 25);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(900, 366, 74, 25);
		contentPane.add(textField_1);
		
		JLabel lblTotal = new JLabel("  Total:");
		lblTotal.setForeground(new Color(255, 255, 255));
		lblTotal.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTotal.setBounds(376, 402, 80, 33);
		contentPane.add(lblTotal);
		
		lblSfsfsf = new JLabel("");
		lblSfsfsf.setForeground(new Color(255, 255, 255));
		lblSfsfsf.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblSfsfsf.setBounds(466, 402, 105, 33);
		contentPane.add(lblSfsfsf);
		
		JButton button_2 = new JButton("+");
		button_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TablePlusMinus.plus(comboBox, table);
				lblSfsfsf.setText(TotalPrice.GetTotalPrice(table));
			}
		});
		button_2.setForeground(new Color(112, 128, 144));
		button_2.setBackground(new Color(255, 255, 255));
		button_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		button_2.setBounds(899, 438, 75, 33);
		contentPane.add(button_2);
		
		JButton btnYaddaSaxla = new JButton("Yadda saxla");
		btnYaddaSaxla.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				for (int i = 0; i < dtm.getRowCount(); i++) {
					System.out.println(dtm.getValueAt(i, 3));
				}
			}
		});
		btnYaddaSaxla.setForeground(new Color(112, 128, 144));
		btnYaddaSaxla.setBackground(new Color(255, 255, 255));
		btnYaddaSaxla.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnYaddaSaxla.setBounds(815, 482, 159, 33);
		contentPane.add(btnYaddaSaxla);
		
		JButton btnLegvEt = new JButton("Legv et");
		btnLegvEt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				RemoveTableRow.RemoveRow(table, dtm);
			}
		});
		btnLegvEt.setForeground(new Color(112, 128, 144));
		btnLegvEt.setBackground(new Color(255, 255, 255));
		btnLegvEt.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnLegvEt.setBounds(815, 526, 159, 33);
		contentPane.add(btnLegvEt);
		
		JButton button_1 = new JButton("-");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TablePlusMinus.Minus( table,table.getSelectedRow());
				lblSfsfsf.setText(TotalPrice.GetTotalPrice(table));
			}
		});
		button_1.setForeground(new Color(112, 128, 144));
		button_1.setBackground(new Color(255, 255, 255));
		button_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		button_1.setBounds(815, 438, 75, 33);
		contentPane.add(button_1);
		
		label = new JLabel("");
		label.setForeground(new Color(255, 255, 255));
		label.setFont(new Font("Tahoma", Font.BOLD, 20));
		label.setBounds(10, 562, 264, 38);
		contentPane.add(label);
		
		JLabel lblQiymet = new JLabel("Qiymet");
		lblQiymet.setForeground(new Color(255, 255, 255));
		lblQiymet.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblQiymet.setBounds(902, 336, 72, 25);
		contentPane.add(lblQiymet);
		
		JButton btnNewButton_1 = new JButton("Log out");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LogOut.LogOutMethod();
			}
		});
		btnNewButton_1.setForeground(new Color(112, 128, 144));
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_1.setBounds(815, 570, 159, 33);
		contentPane.add(btnNewButton_1);
	}
}
