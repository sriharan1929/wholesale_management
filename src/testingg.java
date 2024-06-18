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
import javax.swing.JTextArea;

public class my_cart extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private String[] as;
	private String[] as1=new String[100];
	private JButton btnNewButton;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					my_cart frame = new my_cart();
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
	public my_cart() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1287, 730);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 160, 122));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 594, 345);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"Product_ID", "Product_Name", "Product_Brand", "Quantity","Nos", "Price"
			}
		));
		 textArea = new JTextArea();
		textArea.setBounds(641, 11, 600, 519);
		contentPane.add(textArea);
		
		btnNewButton = new JButton("BILL ITEMS");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try {
			            Class.forName("com.mysql.cj.jdbc.Driver");
			            Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/logindetails","root","velsrI@22");
			            String sql="select * from add1 ";
			            
			            PreparedStatement pts=con.prepareStatement(sql);
			            ResultSet rs = pts.executeQuery();
			            
			            StringBuilder bill = new StringBuilder();
			            double totalPrice = 0.0;
			            
			            while(rs.next()) {
			                String productID = rs.getString("Product_ID");
			                String productName = rs.getString("Product_name");
			                String productBrand = rs.getString("Product_Brand");
			                int quantity = rs.getInt("Quantity");
			                int nos = rs.getInt("Nos");
			                double price = rs.getDouble("Price");
			                
			                double itemTotal = price * nos;
			                totalPrice += itemTotal;
			                
			                bill.append("Product ID: ").append(productID).append("\n");
			                bill.append("Product Name: ").append(productName).append("\n");
			                bill.append("Product Brand: ").append(productBrand).append("\n");
			                bill.append("Quantity: ").append(quantity).append("\n");
			                bill.append("Nos: ").append(nos).append("\n");
			                bill.append("Price: ").append(price).append("\n");
			                bill.append("Item Total: ").append(itemTotal).append("\n\n");
			            }
			            
			            bill.append("Total Price: ").append(totalPrice);
			            
			            textArea.setText(bill.toString());
			        }
			        catch(Exception ec) {
			            JOptionPane.showMessageDialog(null,"it has not been registered");
			            ec.printStackTrace();
			        }
			}
		});
		btnNewButton.setBounds(258, 415, 85, 21);
		contentPane.add(btnNewButton);
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/logindetails","root","velsrI@22");
			String sql="select * from add1 ";
			
			PreparedStatement pts=con.prepareStatement(sql);
			ResultSet rs = pts.executeQuery();
			DefaultTableModel dt=(DefaultTableModel)table.getModel();
			dt.setRowCount(0);
			int i=0;
			while(rs.next()) {
			as1[i]=new String(rs.getString("Product_ID"));
			Object o[]= {rs.getString("Product_ID"),rs.getString("Product_name"),rs.getString("Product_Brand"),rs.getString("Quantity"),rs.getString("Nos"), rs.getString("Price")};
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