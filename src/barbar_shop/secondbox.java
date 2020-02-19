package barbar_shop;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class secondbox extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					secondbox frame = new secondbox();
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
	public secondbox() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 415, 458);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("welcome");
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 40));
		lblNewLabel.setBounds(105, 85, 154, 39);
		contentPane.add(lblNewLabel);
		
		JButton btnView = new JButton("View");
		btnView.setFocusable(false);
		btnView.setForeground(Color.BLUE);
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Location l=new Location();
				l.setVisible(true);
				setVisible(false);
			}
		
		});
		btnView.setBounds(127, 184, 97, 25);
		contentPane.add(btnView);
		
		JButton btnAdmin = new JButton("Admin");
		btnAdmin.setFocusable(false);
		btnAdmin.setForeground(Color.BLUE);
		btnAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login lg=new login();
				lg.setVisible(true);
				setVisible(false);
			}
		});
		btnAdmin.setBounds(127, 248, 97, 25);
		contentPane.add(btnAdmin);
		
		JButton btnAbout = new JButton("About");
		btnAbout.setFocusable(false);
		btnAbout.setForeground(Color.BLUE);
		btnAbout.setBounds(127, 318, 97, 25);
		contentPane.add(btnAbout);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Home_page home=new Home_page();
				home.setVisible(true);
				setVisible(false);
			}
		});
		btnBack.setBounds(557, 363, 97, 25);
		contentPane.add(btnBack);
		
		JButton btnBack_1 = new JButton("Back");
		btnBack_1.setFocusable(false);
		btnBack_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home_page h=new Home_page();
				Home_page.main(null);
				dispose();
				
			}
		});
		btnBack_1.setForeground(Color.RED);
		btnBack_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
		btnBack_1.setBounds(274, 363, 97, 25);
		contentPane.add(btnBack_1);
	}
}
