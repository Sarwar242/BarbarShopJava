package barbar_shop;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
public static Connection getCon() throws SQLException {
		
		Connection con=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/barbardb","root","");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;}

	/**
	 * Create the frame.
	 */
	public login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 438, 445);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setForeground(Color.BLUE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUserName = new JLabel("user name");
		lblUserName.setForeground(Color.BLUE);
		lblUserName.setBackground(Color.DARK_GRAY);
		lblUserName.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
		lblUserName.setBounds(74, 78, 104, 32);
		contentPane.add(lblUserName);
		
		textField = new JTextField();
		textField.setBackground(Color.WHITE);
		textField.setBounds(72, 116, 309, 49);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("password");
		lblPassword.setForeground(Color.BLUE);
		lblPassword.setBackground(Color.BLUE);
		lblPassword.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
		lblPassword.setBounds(74, 178, 104, 27);
		contentPane.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBackground(Color.WHITE);
		passwordField.setBounds(72, 207, 309, 49);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setForeground(Color.DARK_GRAY);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user=textField.getText();
				
				String pass=String.valueOf(passwordField.getPassword());
				String query="select*from admin where username='"+user+"' and password='"+pass+"'";
				Statement st;
				ResultSet rs=null;
				try {
					Connection con=getCon();
					st=con.createStatement();
					rs=st.executeQuery(query);
					if(rs.next()){
						Add_delete ad=new Add_delete();
						ad.setVisible(true);
						setVisible(false);
					}
					else{
						JOptionPane.showMessageDialog(null, "Incorrect Details");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
		btnNewButton.setBounds(70, 269, 97, 33);
		contentPane.add(btnNewButton);
		
		JButton btnBack = new JButton("back");
		btnBack.setForeground(Color.RED);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				secondbox sb=new secondbox();
				sb.setVisible(true);
				setVisible(false);
			}
		});
		btnBack.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
		btnBack.setBounds(284, 269, 97, 32);
		contentPane.add(btnBack);
	}
}
