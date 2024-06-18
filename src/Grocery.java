import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JComboBox;
import javax.swing.AbstractButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import java.awt.Color;

public class Grocery extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private JScrollPane scrollPane;
	private String[] a=new String[10];
	private ResultSet rs;
    private int hg;
    private JTextField searchField;
    private final JSeparator separator = new JSeparator();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Grocery frame = new Grocery();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Grocery() throws NumberFormatException, SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 607, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setBounds(175, 20, 0, 0);
		contentPane.add(table);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 336, 557, 144);
		contentPane.add(scrollPane);
		
		table_1 = new JTable();
		scrollPane.setViewportView(table_1);
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"Product_ID", "Product_name", "product_Brand", "Quantity", "Price"
			}
		));
		
		searchField = new JTextField();
		searchField.setBounds(75, 74, 331, 19);
		contentPane.add(searchField);
		searchField.setColumns(10);
		
		JButton searchButton = new JButton("search");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchgrocery();
				
			}
		});
		searchButton.setBounds(434, 73, 85, 21);
		contentPane.add(searchButton);
		
		JLabel image = new JLabel("");
		image.setBounds(10, 139, 230, 144);
		contentPane.add(image);
		separator.setBackground(new Color(0, 0, 0));
		separator.setBounds(0, 54, 603, 2);
		contentPane.add(separator);
		
		JLabel txtid = new JLabel("Product ID:");
		txtid.setBounds(279, 164, 210, 13);
		contentPane.add(txtid);
		
		JLabel txtn = new JLabel("Product Name:");
		txtn.setBounds(279, 187, 210, 13);
		contentPane.add(txtn);
		
		JLabel txtb = new JLabel("Brand:");
		txtb.setBounds(279, 222, 210, 13);
		contentPane.add(txtb);
		
		JLabel txtq = new JLabel("Quantity:");
		txtq.setBounds(279, 250, 210, 13);
		contentPane.add(txtq);
		
		JLabel txtp = new JLabel("Price:");
		txtp.setBounds(279, 273, 210, 13);
		contentPane.add(txtp);
		try {
			int i=0;
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/logindetails","root","velsrI@22");
			Statement st=con.createStatement();
			String sql="select * from grocery";
			
			PreparedStatement pts=con.prepareStatement(sql);
			//PreparedStatement pts=con.prepareStatement(login.sq1);
			rs= pts.executeQuery();
			DefaultTableModel dt=(DefaultTableModel)table_1.getModel();
			dt.setRowCount(0);
			while(rs.next()) {
			a[i]=new String(rs.getString("Product_id"));
			System.out.println(a[i]);
			Object o[]= {rs.getString("Product_id"),rs.getString("Product_name"),rs.getString("product_Brand"),rs.getString("Quantity"),rs.getString("Price")};
			dt.addRow(o);
			++i;
			}
			
	}
		catch(Exception ec) {
			JOptionPane.showMessageDialog(null,"it has not been registered");
			ec.printStackTrace();
		}
	
	}
	private void searchgrocery() {
        String productname = searchField.getText().trim();
        if (!movieName.isEmpty()) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/logindetails", "root", "velsrI@22");
                String sql = "SELECT * FROM grocery WHERE Product_name LIKE ?";
                PreparedStatement pst = con.prepareStatement(sql);
                pst.setString(1, "%" + productname + "%");
                ResultSet rs = pst.executeQuery();

                if (rs.next()) {
                    AbstractButton txtid;
					txtid.setText("Product ID: " + rs.getInt("Product_id"));
                    AbstractButton txtn;
					txtn.setText("Product Name: " + rs.getString("Product_name"));
                    AbstractButton txtb;
					txtb.setText("Brand:" + rs.getString("product_Brand"));
                    AbstractButton txtq;
					txtq.setText("Quantity: " + rs.getString("Quantity"));
                    AbstractButton txtp;
					txtp.setText("Price: " + rs.getDouble("Price"));
                    
                    // Load and display the image
                    String imageName = rs.getString("Product_name").replace(" ", "") + ".jpg";
                    ImageIcon icon = new ImageIcon("image/" + imageName);
                    Image image = icon.getImage().getScaledInstance(image.getWidth(), image.getHeight(), image.SCALE_SMOOTH);
                    image.setIcon(new ImageIcon(image));

                    // Enable the Book Ticket button
                   // btnBookTicket.setEnabled(true);
                } else {
                    JOptionPane.showMessageDialog(null, "No movie found.");
                  //  clearLabels();
                    //btnBookTicket.setEnabled(false); // Disable the Book Ticket button
                }
                con.close();
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error occurred while searching.");
               // clearLabels();
                //btnBookTicket.setEnabled(false); // Disable the Book Ticket button
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please enter a movie name.");
            //clearLabels();
            //btnBookTicket.setEnabled(false); // Disable the Book Ticket button
        }
    }
}
