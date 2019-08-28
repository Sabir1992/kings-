package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DaoImplClass.LoginDaoImpl;
import DaoInterface.LoginDao;
import Model.Users;
import Service.KingService;
import Service.KingServiceImpl;
import Service.LoginService;
import Service.LoginServiceImpl;
import Util.SelectedComboIndex;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Tables extends JFrame {

	private JPanel contentPane;
	JLabel lblLogOn;

	
	public Tables() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				lblLogOn.setText(Users.getWhoIs());
			}
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(400, 200, 648, 412);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(112, 128, 144));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JComboBox comboBox = new JComboBox();
		comboBox.setForeground(new Color(112, 128, 144));
		comboBox.setBackground(new Color(255, 255, 255));
		comboBox.setBounds(10, 137, 264, 56);
		contentPane.add(comboBox);

		lblLogOn = new JLabel("");
		lblLogOn.setForeground(new Color(255, 255, 255));
		lblLogOn.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblLogOn.setBounds(10, 11, 264, 38);
		contentPane.add(lblLogOn);

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setForeground(new Color(112, 128, 144));
		comboBox_1.setBackground(new Color(255, 255, 255));
		comboBox_1.setBounds(358, 137, 264, 56);
		contentPane.add(comboBox_1);

		JLabel lblZal = new JLabel("                 Zal-1");
		lblZal.setForeground(new Color(255, 255, 255));
		lblZal.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblZal.setBounds(10, 88, 264, 38);
		contentPane.add(lblZal);

		JLabel lblZal_1 = new JLabel("                Zal-2");
		lblZal_1.setForeground(new Color(255, 255, 255));
		lblZal_1.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblZal_1.setBounds(358, 88, 264, 38);
		contentPane.add(lblZal_1);

		JButton btnYeniMasa = new JButton("Yeni Masa");
		btnYeniMasa.setForeground(new Color(105, 105, 105));
		btnYeniMasa.setBackground(new Color(255, 255, 255));
		btnYeniMasa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				OrderFrame frame = new OrderFrame();
          	    frame.setVisible(true);
           	    String username=lblLogOn.getText();
        	    Users.setWhoIs(username);
			}
		});
		btnYeniMasa.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnYeniMasa.setBounds(325, 237, 143, 56);
		contentPane.add(btnYeniMasa);

		JButton btnHesab = new JButton("Hesab");
		btnHesab.setForeground(new Color(105, 105, 105));
		btnHesab.setBackground(new Color(255, 255, 255));
		btnHesab.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnHesab.setBounds(478, 304, 144, 58);
		contentPane.add(btnHesab);

		JButton btnSifaris = new JButton("Sifaris");
		btnSifaris.setForeground(new Color(105, 105, 105));
		btnSifaris.setBackground(new Color(255, 255, 255));
		btnSifaris.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				OrderFrame frame = new OrderFrame();
          	    frame.setVisible(true);
           	    String username=lblLogOn.getText();
        	    Users.setWhoIs(username);
			}
		});
		btnSifaris.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSifaris.setBounds(478, 237, 144, 56);
		contentPane.add(btnSifaris);

		JButton btnReserv = new JButton("Rezerv");
		btnReserv.setForeground(new Color(105, 105, 105));
		btnReserv.setBackground(new Color(255, 255, 255));
		btnReserv.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnReserv.setBounds(325, 304, 143, 58);
		contentPane.add(btnReserv);
		
		JButton adminBtn = new JButton("Admin");
		adminBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AdminFrame mf=new AdminFrame();
				mf.setVisible(true);
			}
		});
		adminBtn.setBackground(new Color(255, 255, 255));
		adminBtn.setForeground(new Color(112, 128, 144));
		adminBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		adminBtn.setBounds(10, 237, 143, 58); 
		contentPane.add(adminBtn);
		
		JButton button = new JButton("Log out");
		button.setForeground(new Color(112, 128, 144));
		button.setFont(new Font("Tahoma", Font.BOLD, 15));
		button.setBackground(Color.WHITE);
		button.setBounds(10, 304, 143, 54);
		contentPane.add(button);
		
	}
}
