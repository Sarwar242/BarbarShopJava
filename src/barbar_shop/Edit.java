package barbar_shop;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JScrollPane;

public class Edit extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField name;
	private JTextField hair;
	private JTextField shave;
	int id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Edit frame = new Edit();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void show_Shops(){
		DefaultTableModel model=(DefaultTableModel) table.getModel();
		List<BarBarShop> list=connection_database.getAllShops();
		Object[] row=new Object[5];
		for(BarBarShop b:list){
			row[0]=b.getName();
			row[1]=b.getLocation();
			row[2]=b.getPhone();
			row[3]=b.getHp();
			row[4]=b.getSp();
			
			model.addRow(row);
			
		}
	}

	/**
	 * Create the frame.
	 */
	public Edit() {
		setMinimumSize(new Dimension(1300, 650));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 517, 490);
		contentPane = new JPanel();
		contentPane.setMinimumSize(new Dimension(1300, 650));
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		shave = new JTextField();
		shave.setBounds(1062, 273, 208, 35);
		contentPane.add(shave);
		shave.setColumns(10);
		
		hair = new JTextField();
		hair.setBounds(1062, 188, 208, 35);
		contentPane.add(hair);
		hair.setColumns(10);
		
		name = new JTextField();
		name.setEditable(false);
		name.setBounds(1053, 113, 217, 35);
		contentPane.add(name);
		name.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 69, 923, 521);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setRowMargin(2);
		table.setRowHeight(25);
		table.setFont(new Font("Arial Black", Font.PLAIN, 15));
		table.setBackground(Color.YELLOW);
		table.setModel(new DefaultTableModel(
			new Object[][] {

			},
			new String[] {
				"Name", "Location", "Phone No", "HairCut", "Shave"
			}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e){
				
				int i=table.getSelectedRow();
				DefaultTableModel model=(DefaultTableModel) table.getModel();
				List<BarBarShop> list=connection_database.getAllShops();
				id=(int)list.get(i).getId();
				name.setText(list.get(i).getName().toString());
				hair.setText(list.get(i).getHp().toString());
				shave.setText(list.get(i).getSp().toString());
				
			}
		});
		show_Shops();
		
		JLabel lblLocation = new JLabel("Barbar Shops");
		lblLocation.setBackground(SystemColor.activeCaptionBorder);
		lblLocation.setHorizontalAlignment(SwingConstants.CENTER);
		lblLocation.setHorizontalTextPosition(SwingConstants.CENTER);
		lblLocation.setForeground(Color.DARK_GRAY);
		lblLocation.setFont(new Font("Times New Roman", Font.BOLD, 38));
		lblLocation.setBounds(399, 0, 292, 58);
		contentPane.add(lblLocation);
		
		/*JButton btnBack = new JButton("back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				secondbox sec=new secondbox();
				sec.setVisible(true);
				dispose();
			}
		});
		btnBack.setBounds(680, 524, 97, 25);
		contentPane.add(btnBack);*/
		
		JButton btnBack_1 = new JButton("back");
		btnBack_1.setFocusable(false);
		btnBack_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Add_delete sec=new Add_delete();
				sec.setVisible(true);
				dispose();
			}
		});
		btnBack_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		btnBack_1.setForeground(Color.RED);
		btnBack_1.setBounds(1100, 481, 97, 25);
		contentPane.add(btnBack_1);
		
		JLabel lblName = new JLabel("Name :");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblName.setBounds(985, 116, 66, 32);
		contentPane.add(lblName);
		
		JLabel lblNewLabel = new JLabel("HairCut:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(974, 191, 82, 32);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Shave:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(985, 276, 66, 32);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Update");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String h=hair.getText();
				String s=shave.getText();			
				BarBarShop b= new BarBarShop();
				b.setId(id);	
				b.setHp(h);
				b.setSp(s);
				
				int status=connection_database.update(b);
				
				if(status>0){
					JOptionPane.showMessageDialog(null, "You have Successfully Updated a Shop.");
					Edit ad=new Edit();
					ad.setVisible(true);
					setVisible(false);
				}
				else {
					JOptionPane.showMessageDialog(null, "Unable to Update the Shop!");
					Edit ad=new Edit();
					ad.setVisible(true);
					setVisible(false);
				}
			}
		});
		btnNewButton.setBounds(1032, 421, 97, 25);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Delete");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				connection_database.delete(id);
				JOptionPane.showMessageDialog(null, "A shop Has Been Deleted!");
				Edit e=new Edit();
				Edit.main(null);
				dispose();
			}
		});
		btnNewButton_1.setBounds(1173, 421, 97, 25);
		contentPane.add(btnNewButton_1);
	}
}
