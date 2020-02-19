package barbar_shop;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Home_page extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home_page frame = new Home_page();
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
	public Home_page() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 471, 491);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWelcomeToThis = new JLabel("welcome to this project");
		lblWelcomeToThis.setBackground(Color.MAGENTA);
		lblWelcomeToThis.setForeground(Color.DARK_GRAY);
		lblWelcomeToThis.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblWelcomeToThis.setBounds(107, 170, 303, 41);
		contentPane.add(lblWelcomeToThis);
		
		JButton btnEnter = new JButton("ENTER");
		btnEnter.setFocusable(false);
		btnEnter.setForeground(Color.RED);
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				secondbox second=new secondbox();
				second.setVisible(true);
				setVisible(false);
			}
		});
		btnEnter.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		btnEnter.setBounds(176, 333, 109, 25);
		contentPane.add(btnEnter);
		
		JLabel lblBarbarShop = new JLabel("barbar shop");
		lblBarbarShop.setForeground(Color.BLUE);
		lblBarbarShop.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 23));
		lblBarbarShop.setBounds(176, 266, 134, 34);
		contentPane.add(lblBarbarShop);
	}
}
