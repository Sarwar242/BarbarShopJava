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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class ADD extends JFrame {

	private JPanel contentPane;
	private JTextField nf;
	private JTextField lf;
	private JTextField pf;
	private JTextField hf;
	private JTextField sf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ADD frame = new ADD();
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
	public ADD() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 651, 575);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblShopName = new JLabel("Shop Name");
		lblShopName.setForeground(new Color(0, 0, 255));
		lblShopName.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblShopName.setBounds(73, 162, 107, 26);
		contentPane.add(lblShopName);
		
		JLabel lblShopLocation = new JLabel("Shop location");
		lblShopLocation.setForeground(Color.BLUE);
		lblShopLocation.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblShopLocation.setBounds(73, 235, 123, 26);
		contentPane.add(lblShopLocation);
		
		JLabel lblNewLabel = new JLabel("Phone no");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setBounds(73, 319, 107, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("hair cut");
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1.setBounds(73, 393, 85, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("shave");
		lblNewLabel_2.setForeground(Color.BLUE);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_2.setBounds(445, 388, 56, 26);
		contentPane.add(lblNewLabel_2);
		
		nf = new JTextField();
		nf.setBounds(203, 154, 259, 47);
		contentPane.add(nf);
		nf.setColumns(10);
		
		lf = new JTextField();
		lf.setBounds(203, 224, 259, 47);
		contentPane.add(lf);
		lf.setColumns(10);
		
		pf = new JTextField();
		pf.setBounds(203, 306, 259, 47);
		contentPane.add(pf);
		pf.setColumns(10);
		
		
		
		JButton btnBack = new JButton("back");
		btnBack.setFocusable(false);
		btnBack.setForeground(Color.RED);
		btnBack.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Add_delete ad=new Add_delete();
				ad.setVisible(true);
				setVisible(false);
			}
		});
		btnBack.setBounds(326, 490, 74, 25);
		contentPane.add(btnBack);
		
		hf = new JTextField();
		hf.setBounds(64, 422, 85, 33);
		contentPane.add(hf);
		hf.setColumns(10);
		
		sf = new JTextField();
		sf.setBounds(437, 422, 85, 33);
		contentPane.add(sf);
		sf.setColumns(10);
		
		
		
		
		JLabel AddLabel = new JLabel("Add New Barbar Shop");
		AddLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		AddLabel.setForeground(Color.ORANGE);
		AddLabel.setBounds(203, 40, 298, 41);
		contentPane.add(AddLabel);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setFocusable(false);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name=nf.getText();
				String location=lf.getText();
				String phone=pf.getText();
				String hair=hf.getText();
				String shave=sf.getText();
				
				BarBarShop b= new BarBarShop();
				b.setName(name);
				b.setLocation(location);
				b.setPhone(phone);
				b.setHp(hair);
				b.setSp(shave);
				
				int status=connection_database.insert(b);
				if(status>0){
					JOptionPane.showMessageDialog(null, "You have Successfully Added a Shop.");
					Add_delete ad=new Add_delete();
					ad.setVisible(true);
					setVisible(false);
				}
				else {
					JOptionPane.showMessageDialog(null, "Unable to Add the Shop!");
					Add_delete ad=new Add_delete();
					ad.setVisible(true);
					setVisible(false);
				}
			}
		});
		btnAdd.setForeground(Color.RED);
		btnAdd.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		btnAdd.setBounds(203, 490, 79, 25);
		contentPane.add(btnAdd);
	}
}
