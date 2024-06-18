import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class MyCart extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable table;
    private JTextArea textArea;
    private JButton btnBillItems;
    private JScrollPane textScrollPane;
    private JButton btnNewButton;
    private JButton btnNewButton_1;
    private JComboBox<String> comboBox;
    private JButton btnRemoveProduct;
	static double totalPrice;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MyCart frame = new MyCart();
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
    public MyCart() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1412, 730);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 160, 122));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        
        btnNewButton_1 = new JButton("PRINT BILL");
        btnNewButton_1.setBounds(364, 626, 237, 30);
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		try {
					textArea.print();
				}
				catch(PrinterException e1) {
					e1.printStackTrace();
				}
        	}
        });
        contentPane.setLayout(null);
        btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 20));
        contentPane.add(btnNewButton_1);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 10, 598, 240);
        contentPane.add(scrollPane);

        table = new JTable();
        scrollPane.setViewportView(table);
        table.setModel(new DefaultTableModel(
        	new Object[][] {
        		{null, null, null, null, null, null},
        	},
        	new String[] {
        		"Product_ID", "Product_Name", "Product_Brand", "Quantity", "Price", "NO s"
        	}
        ));

        textArea = new JTextArea();
        textScrollPane = new JScrollPane(textArea);
        textScrollPane.setBounds(641, 11, 750, 600);
        contentPane.add(textScrollPane);

        btnBillItems = new JButton("BILL ITEMS");
        btnBillItems.setBounds(364, 515, 188, 35);
        btnBillItems.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnBillItems.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                billItems();
            }
        });
        contentPane.add(btnBillItems);
        
        btnNewButton = new JButton("Back to home page");
        btnNewButton.setBounds(33, 608, 208, 48);
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		try {
  				  homepage sf1 = new  homepage();
  				sf1.setVisible(true);
  				SwingUtilities.windowForComponent(btnNewButton).dispose();
        		} catch (Exception rt) {
  					rt.printStackTrace();
        		}
          }
        });
        contentPane.add(btnNewButton);
        
        JButton btnNewButton_2 = new JButton("Shipping");
        btnNewButton_2.setBounds(760, 626, 200, 30);
        btnNewButton_2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		new delivery().setVisible(true);
        		SwingUtilities.windowForComponent(btnNewButton_2).dispose();
        	}
        });
        btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 25));
        contentPane.add(btnNewButton_2);
        
        JButton btnNewButton_1_1 = new JButton("Delete cart");
        btnNewButton_1_1.setBounds(420, 260, 188, 42);
        btnNewButton_1_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) { 
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/logindetails", "root", "velsrI@22");
                    Statement st = con.createStatement();
                    String sql = "truncate table add1";
                    st.executeUpdate(sql);
                    JOptionPane.showMessageDialog(null, "Deleted Cart");
                    con.close();
                    loadData();
                    loadProductsToComboBox();
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, "Error: " + e1.getMessage());
                }
        	}
        });
        btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 25));
        contentPane.add(btnNewButton_1_1);
        
        comboBox = new JComboBox<>();
        comboBox.setBounds(33, 338, 147, 35);
        comboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
        contentPane.add(comboBox);
        
        JButton refreshButton = new JButton("Refresh");
        refreshButton.setBounds(10, 277, 111, 21);
        refreshButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                loadData();
                loadProductsToComboBox();
            }
        });
        contentPane.add(refreshButton);
        
        btnRemoveProduct = new JButton("Remove Product");
        btnRemoveProduct.setBounds(205, 338, 167, 35);
        btnRemoveProduct.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnRemoveProduct.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                removeSelectedProduct();
            }
        });
        contentPane.add(btnRemoveProduct);

        loadData();
        loadProductsToComboBox();
    }

    private void loadData() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/logindetails", "root", "velsrI@22");
            String sql = "SELECT * FROM add1";
            PreparedStatement pts = con.prepareStatement(sql);
            ResultSet rs = pts.executeQuery();
            DefaultTableModel dt = (DefaultTableModel) table.getModel();
            dt.setRowCount(0);

            while (rs.next()) {
                Object[] row = {
                    rs.getString("Product_ID"),
                    rs.getString("Product_Name"),
                    rs.getString("Product_Brand"),
                    rs.getString("Quantity"),
                    rs.getString("Nos"),
                    rs.getString("Price")
                };
                dt.addRow(row);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data loading error");
            e.printStackTrace();
        }
    }

    private void loadProductsToComboBox() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/logindetails", "root", "velsrI@22");
            String sql = "SELECT Product_Name FROM add1";
            PreparedStatement pts = con.prepareStatement(sql);
            ResultSet rs = pts.executeQuery();
            
            comboBox.removeAllItems();
            while (rs.next()) {
                comboBox.addItem(rs.getString("Product_Name"));
            }
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error loading products into combobox");
            e.printStackTrace();
        }
    }

    private void removeSelectedProduct() {
        String selectedProduct = (String) comboBox.getSelectedItem();
        if (selectedProduct == null) {
            JOptionPane.showMessageDialog(null, "No product selected");
            return;
        }

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/logindetails", "root", "velsrI@22");
            String sql = "DELETE FROM add1 WHERE Product_Name = ?";
            PreparedStatement pts = con.prepareStatement(sql);
            pts.setString(1, selectedProduct);
            int rowsAffected = pts.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Product removed");
            } else {
                JOptionPane.showMessageDialog(null, "Product not found");
            }
            con.close();
            loadData();
            loadProductsToComboBox();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error removing product");
            e.printStackTrace();
        }
    }

    private void billItems() {
    	try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/logindetails", "root", "velsrI@22");
            String sql = "SELECT Product_ID, Product_Name, Product_Brand, Quantity, Nos, Price FROM add1";
            PreparedStatement pts = con.prepareStatement(sql);
            ResultSet rs = pts.executeQuery();

            textArea.setText("");

            // Generate bill number
            int billNumber = generateBillNumber();
            textArea.append(String.format("BILL NO: %06d\n", billNumber));

            // Add shop name and address
            textArea.append(String.format("%100s","DBMS Whole Sale Store\n "));
            textArea.append(String.format("%100s","44,Near Sona College, Junction\n "));

            textArea.append(String.format("%-15s %-30s  %-25s %-15s %-15s    %-15s\n",
                "PRODUCT_ID", "PRODUCT_NAME", "PRODUCT_BRAND", "QUANTITY", "NOS", "PRICE"));
            textArea.append("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");

            totalPrice = 0.0;
            while (rs.next()) {
                String productID = rs.getString("Product_ID");
                String productName = rs.getString("Product_Name");
                String productBrand = rs.getString("Product_Brand");
                String quantity = rs.getString("Quantity");
                String nos = rs.getString("Nos");
                double price = rs.getDouble("Price");
                double itemTotal = price * rs.getInt("Nos");
                totalPrice += itemTotal;

                String row = String.format("%-15s\t    %-30s\t  %-25s\t%-15s\t%-10s\t%-15.2f\n",
                    productID, productName, productBrand, quantity, nos, itemTotal);
                textArea.append(row);
            }

            textArea.append("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
            textArea.append(String.format("%160s %15.2f\n", "TOTAL PRICE: ", totalPrice));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Billing error");
            e.printStackTrace();
        }
    }

    private int generateBillNumber() {
        // Implement your logic to generate a unique bill number
        // This is a simple example, you may want to use a more robust solution
        return (int) (Math.random() * 1000000);
    }

    public double getTotalPrice() {
        // TODO Auto-generated method stub
        return 0;
    }
}
