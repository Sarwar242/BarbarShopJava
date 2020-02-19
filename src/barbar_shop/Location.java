package barbar_shop;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.RowSorter;
import javax.swing.JScrollPane;

public class Location extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JLabel lblSearch;
	private JTextField search;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Location frame = new Location();
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
	public Location() {
		setMinimumSize(new Dimension(1100, 650));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 517, 490);
		contentPane = new JPanel();
		contentPane.setMinimumSize(new Dimension(1100, 600));
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 81, 1058, 509);
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
		) );
		show_Shops();
		//for Search
		TableRowSorter<TableModel>rowSorter=new TableRowSorter<>(table.getModel());
		table.setRowSorter(rowSorter);
		
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
				secondbox sec=new secondbox();
				sec.setVisible(true);
				dispose();
			}
		});
		btnBack_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		btnBack_1.setForeground(Color.RED);
		btnBack_1.setBounds(12, 13, 97, 25);
		contentPane.add(btnBack_1);
		
		
		//search filter
		lblSearch = new JLabel("Search:");
		lblSearch.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSearch.setBounds(734, 19, 77, 19);
		contentPane.add(lblSearch);
		
		search = new JTextField(){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			@Override
			protected void paintComponent(Graphics g){
				if(!isOpaque()&&getBorder() instanceof RoundedCornerBorder){
					Graphics2D g2=(Graphics2D) g.create();
					g2.setPaint(getBackground());
					g2.fill(((RoundedCornerBorder)getBorder()).getBorderShape(0, 0, getWidth()-1, getHeight()-1));
					g2.dispose();
				}
				super.paintComponent(g);
			}
			@Override
			public void updateUI() {
				super.updateUI();
				setOpaque(false);
				setBorder(new RoundedCornerBorder());

			}
		};
		search.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				String text=search.getText();
				if(text.trim().length()==0){
					rowSorter.setRowFilter(null);
				}
				else{
					rowSorter.setRowFilter(RowFilter.regexFilter("(?i)"+text));
				}
				
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				String text=search.getText();
				if(text.trim().length()==0){
					rowSorter.setRowFilter(null);
				}
				else{
					rowSorter.setRowFilter(RowFilter.regexFilter("(?i)"+text));
				}
				
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				throw new UnsupportedOperationException("Not Supported Yet");
				
			}
		});
		search.setFont(new Font("Tahoma", Font.PLAIN, 15));
		search.setBounds(836, 13, 199, 33);
		contentPane.add(search);
		search.setColumns(10);
	}
}
