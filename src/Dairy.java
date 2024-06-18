import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.JButton;

public class Dairy extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private String[] as;
	private String[] as1=new String[100];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dairy frame = new Dairy();
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
	public Dairy() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 160, 122));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(59, 27, 808, 132);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, "", null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"Product_ID", "Product_Name", "Product_Brand", "Quantity", "Price"
			}
		));
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/logindetails","root","velsrI@22");
			String sql="select * from dairy ";
			
			PreparedStatement pts=con.prepareStatement(sql);
			ResultSet rs = pts.executeQuery();
			DefaultTableModel dt=(DefaultTableModel)table.getModel();
			dt.setRowCount(0);
			int i=0;
			while(rs.next()) {
			as1[i]=new String(rs.getString("Product_ID"));
			Object o[]= {rs.getString("Product_ID"),rs.getString("Product_name"),rs.getString("Product_Brand"),rs.getString("Quantity"),rs.getString("Price")};
			dt.addRow(o);
			++i;
			}
			
	}
		catch(Exception ec) {
			JOptionPane.showMessageDialog(null,"it has not been registered");
			ec.printStackTrace();
		}
	}
}
