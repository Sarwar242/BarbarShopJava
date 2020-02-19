package barbar_shop;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Add_delete extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add_delete frame = new Add_delete();
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
	public Add_delete() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 467, 496);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(245, 148, 56, 16);
		contentPane.add(label);
		
		JButton btnNewButton = new JButton("Add Shop");
		btnNewButton.setFocusable(false);
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ADD add=new ADD();
				add.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
		btnNewButton.setBounds(134, 148, 157, 35);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Edit Shops");
		btnNewButton_1.setFocusable(false);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Edit e=new Edit();
				Edit.main(null);
				dispose();
			}
		});
		btnNewButton_1.setForeground(Color.BLUE);
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
		btnNewButton_1.setBounds(134, 235, 157, 35);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_3 = new JButton("Back");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login llg=new login();
				llg.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
		btnNewButton_3.setBounds(403, 508, 97, 25);
		contentPane.add(btnNewButton_3);
		
		JButton btnBack = new JButton("back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				secondbox sb=new secondbox();
				secondbox.main(null);
				dispose();
			}
		});
		btnBack.setFocusable(false);
		btnBack.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		btnBack.setForeground(Color.RED);
		btnBack.setBounds(340, 411, 97, 25);
		contentPane.add(btnBack);
	}

}
