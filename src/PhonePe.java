import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class PhonePe extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PhonePe frame = new PhonePe();
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
	public PhonePe() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1063, 723);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 230, 140));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("Online Payment");
		lblNewLabel_1_1.setBounds(360, 10, 328, 55);
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 46));
		contentPane.add(lblNewLabel_1_1);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(220, 20, 60));
		separator.setForeground(new Color(178, 34, 34));
		separator.setBounds(10, 75, 1029, 7);
		contentPane.add(separator);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\balaj\\Downloads\\WhatsApp Image 2024-06-11 at 1.43.14 PM (1).jpeg"));
		lblNewLabel.setBounds(731, 81, 308, 468);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Send the Amount Through UPI ");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(52, 104, 553, 39);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("NAME");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(88, 211, 61, 28);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("ENTER TRANSACTION ID:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(88, 274, 201, 21);
		contentPane.add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBounds(193, 211, 182, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(311, 268, 252, 28);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("SUBMIT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/logindetails", "root", "velsrI@22");
                    Statement st = con.createStatement();
                    String sql = "insert into upi values('"+textField.getText()+"','"+textField_1.getText()+"')";
                    PreparedStatement pst = con.prepareStatement(sql);
                    //pst.setString(1, textField.getText());
                    //pst.setString(2, textField_1.getText());
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Information stored Successfully");
                    
                    con.close();
                } catch (Exception ed) {
                    JOptionPane.showMessageDialog(null, "Error: " + ed.getMessage());
                }
				try {
    	            Class.forName("com.mysql.cj.jdbc.Driver");
    	            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/logindetails", "root", "velsrI@22");
    	            String sql = "SELECT * FROM upi";
    	            PreparedStatement pts = con.prepareStatement(sql);
    	            ResultSet rs = pts.executeQuery();
    	            DefaultTableModel dt = (DefaultTableModel) table.getModel();
    	            dt.setRowCount(0);

    	            while (rs.next()) {
    	                Object[] row = {
    	                    rs.getString("name"),
    	                    rs.getString("transaction_id"),
    	                };
    	                dt.addRow(row);
    	            }
    	        } catch (Exception e1) {
    	            JOptionPane.showMessageDialog(null, "Data loading error");
    	            e1.printStackTrace();
    	        }
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(233, 352, 182, 21);
		contentPane.add(btnNewButton);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 10));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"Name", "Transaction_ID"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(89);
		table.getColumnModel().getColumn(1).setPreferredWidth(249);
		table.setBounds(88, 402, 517, 106);
		contentPane.add(table);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(193, 168, 136, 21);
		lblNewLabel_4.setText("0.0");
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_2_1 = new JLabel("Total Price");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_1.setBounds(88, 166, 108, 28);
		contentPane.add(lblNewLabel_2_1);
		
		JButton btnNewButton_1 = new JButton("Complete Payment");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try {
	                    homepage sf1 = new homepage();
	                    sf1.setVisible(true);
	                    SwingUtilities.windowForComponent(btnNewButton_1).dispose();
	                } catch (Exception rt) {
	                    rt.printStackTrace();
	                }
			}
		});
		btnNewButton_1.setBounds(360, 565, 263, 39);
		contentPane.add(btnNewButton_1);
	}
}
