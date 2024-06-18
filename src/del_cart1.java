import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;
import java.awt.SystemColor;

public class del_cart1 extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField searchField;
    private JLabel p_name;
    private JLabel p_brand;
    private JLabel p_qua;
    private JLabel p_pri;
    private JLabel p_id;
    private JPanel panel_1;
    private JButton btnExit;
    private JButton btnaddcart;
    private String a;
    private String b;
    private String c;
    private String d;
    private String e1;
    private JTextField q;
    private int i;
    private JButton btnNewButton;
    private JTable table_1;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    del_cart1 frame = new del_cart1();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public del_cart1() {
        setTitle("Add");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1020, 670);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 222, 173));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setForeground(new Color(255, 222, 173));
        panel.setLayout(null);
        panel.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
        panel.setBackground(new Color(255, 222, 173));
        panel.setBounds(-11, 0, 1120, 760);
        contentPane.add(panel);

        JLabel lblNewLabel = new JLabel("Search Product Name :");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBackground(new Color(0, 0, 0));
        lblNewLabel.setForeground(new Color(0, 0, 0));
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblNewLabel.setBounds(63, 84, 241, 22);
        panel.add(lblNewLabel);

        searchField = new JTextField();
        searchField.setFont(new Font("Tahoma", Font.PLAIN, 12));
        searchField.setColumns(10);
        searchField.setBounds(281, 86, 188, 19);
        panel.add(searchField);

        JButton searchButton = new JButton("Search");
        searchButton.setForeground(Color.WHITE);
        searchButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
        searchButton.setBorder(new EtchedBorder());
        searchButton.setBackground(new Color(0, 128, 64));
        searchButton.setBounds(486, 83, 85, 22);
        panel.add(searchButton);

        p_id = new JLabel("PRODUCT ID: ");
        p_id.setForeground(new Color(0, 0, 0));
        p_id.setFont(new Font("Tahoma", Font.BOLD, 12));
        p_id.setBounds(45, 178, 377, 28);
        panel.add(p_id);

        p_name = new JLabel("PRODUCT NAME: ");
        p_name.setForeground(new Color(0, 0, 0));
        p_name.setFont(new Font("Tahoma", Font.BOLD, 12));
        p_name.setBounds(45, 244, 377, 28);
        panel.add(p_name);
        
        p_brand = new JLabel("BRAND: ");
        p_brand.setForeground(new Color(0, 0, 0));
        p_brand.setFont(new Font("Tahoma", Font.BOLD, 12));
        p_brand.setBounds(45, 314, 377, 28);
        panel.add(p_brand);

        p_qua = new JLabel("QUANTITY: ");
        p_qua.setForeground(new Color(0, 0, 0));
        p_qua.setFont(new Font("Tahoma", Font.BOLD, 12));
        p_qua.setBounds(45, 378, 377, 28);
        panel.add(p_qua);

        p_pri = new JLabel("PRICE: ");
        p_pri.setForeground(new Color(0, 0, 0));
        p_pri.setFont(new Font("Tahoma", Font.BOLD, 12));
        p_pri.setBounds(45, 447, 377, 28);
        panel.add(p_pri);

        JSeparator separator = new JSeparator();
        separator.setBounds(10, 53, 986, 2);
        panel.add(separator);

        btnExit = new JButton("Back To Home");
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    homepage sf1 = new homepage();
                    sf1.setVisible(true);
                    SwingUtilities.windowForComponent(btnNewButton).dispose();
                } catch (Exception rt) {
                    rt.printStackTrace();
                }
            }
        });

        JTextPane textPane = new JTextPane();
        textPane.setBounds(411, 555, 449, 74);
        panel.add(textPane);

        btnExit.setForeground(Color.WHITE);
        btnExit.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnExit.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
        btnExit.setBackground(new Color(178, 34, 34));
        btnExit.setBounds(29, 601, 241, 28);
        panel.add(btnExit);

        btnaddcart = new JButton("Add To Cart");
        btnaddcart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String qs = q.getText();
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/logindetails", "root", "velsrI@22");
                    int r1 = Integer.parseInt(qs);
                    String sql = "INSERT INTO add1 (Product_ID, Product_name, product_Brand, Quantity, Nos, Price) VALUES (?, ?, ?, ?, ?, ?)";
                    PreparedStatement pts = con.prepareStatement(sql);
                    pts.setString(1, a);
                    pts.setString(2, b);
                    pts.setString(3, c);
                    pts.setString(4, d);
                    pts.setString(5, q.getText());
                    int ty = Integer.parseInt(q.getText()) * Integer.parseInt(e1);
                    String j = "" + ty;
                    pts.setString(6, j);
                    pts.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Item has been registered");
                    con.close();
                    
                    // Append the product name to the JTextPane
                    textPane.setText(textPane.getText() + "\n" + b + " successfully added to cart.");
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, "Error: " + e1.getMessage());
                }
            }
        });
        btnaddcart.setForeground(new Color(220, 20, 60));
        btnaddcart.setFont(new Font("Tempus Sans ITC", Font.BOLD, 16));
        btnaddcart.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
        btnaddcart.setBackground(SystemColor.activeCaption);
        btnaddcart.setBounds(45, 551, 343, 31);
        panel.add(btnaddcart);

        JLabel label_3 = new JLabel("Enter Number of items");
        label_3.setForeground(Color.BLACK);
        label_3.setFont(new Font("Tahoma", Font.BOLD, 13));
        label_3.setBounds(45, 504, 157, 22);
        panel.add(label_3);

        q = new JTextField();
        q.setFont(new Font("Tahoma", Font.PLAIN, 12));
        q.setColumns(10);
        q.setBounds(249, 506, 37, 19);
        panel.add(q);

        btnNewButton = new JButton("Clear");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                searchField.setText("");
                p_id.setText("PRODUCT ID:");
                p_name.setText("PRODUCT NAME:");
                p_brand.setText("BRAND:");
                p_qua.setText("QUANTITY:");
                p_pri.setText("PRICE:");
                textPane.setText("");
            }
        });

        btnNewButton.setForeground(Color.WHITE);
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnNewButton.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
        btnNewButton.setBackground(new Color(0, 128, 64));
        btnNewButton.setBounds(631, 83, 85, 22);
        panel.add(btnNewButton);
        
        JButton btnNewButton_1 = new JButton("\r\n");
        btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\balaj\\Downloads\\shopping-cart.png"));
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		try{
					MyCart sf1 = new  MyCart();
				sf1.setVisible(true);
				SwingUtilities.windowForComponent(btnNewButton).dispose();}
				catch(Exception rt) {
					rt.printStackTrace();				}
        	}
        });
        btnNewButton_1.setBounds(905, 52, 104, 99);
        panel.add(btnNewButton_1);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(358, 178, 557, 211);
        panel.add(scrollPane);
        
        table_1 = new JTable();
        scrollPane.setViewportView(table_1);
        table_1.setModel(new DefaultTableModel(
        	new Object[][] {
        		{null, null, null, null, null, null},
        		{null, null, null, null, null, null},
        		{null, null, null, null, null, null},
        		{null, null, null, null, null, null},
        		{null, null, null, null, null, null},
        		{null, null, null, null, null, null},
        		{null, null, null, null, null, null},
        		{null, null, null, null, null, null},
        		{null, null, null, null, null, null},
        		{null, null, null, null, null, null},
        		{null, null, null, null, null, null},
        	},
        	new String[] {
        		"Product ID", "Product Name ", "Brand", "Quantity", "NO s", "Total Price"
        	}
        ));
        
        JButton btnNewButton_2 = new JButton("Show Cart");
        btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnNewButton_2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		   try {
        	            Class.forName("com.mysql.cj.jdbc.Driver");
        	            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/logindetails", "root", "velsrI@22");
        	            String sql = "SELECT * FROM add1";
        	            PreparedStatement pts = con.prepareStatement(sql);
        	            ResultSet rs = pts.executeQuery();
        	            DefaultTableModel dt = (DefaultTableModel) table_1.getModel();
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
        	        } catch (Exception e1) {
        	            JOptionPane.showMessageDialog(null, "Data loading error");
        	            e1.printStackTrace();
        	        }
        	}
        });
        btnNewButton_2.setBounds(769, 397, 146, 21);
        panel.add(btnNewButton_2);

        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                searchProduct();
            }
        });
    }

    private void searchProduct() {
        String search = searchField.getText();
        String[] tables = {"grocery", "dairy", "choco", "fruit", "bites", "homes", "personal", "sta"};
        boolean found = false;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/logindetails", "root", "velsrI@22");

            for (String table : tables) {
                String sql = "SELECT * FROM " + table + " WHERE Product_name = ?";
                PreparedStatement pts = con.prepareStatement(sql);
                pts.setString(1, search);
                ResultSet rs = pts.executeQuery();
                if (rs.next()) {
                    a = rs.getString("Product_ID");
                    b = rs.getString("Product_name");
                    c = rs.getString("product_Brand");
                    d = rs.getString("Quantity");
                    e1 = rs.getString("Price");
                    p_id.setText("PRODUCT ID: " + a);
                    p_name.setText("PRODUCT NAME: " + b);
                    p_brand.setText("BRAND: " + c);
                    p_qua.setText("QUANTITY: " + d);
                    p_pri.setText("PRICE: " + e1);
                    btnaddcart.setEnabled(true); // Enable the "Add to Cart" button
                    found = true;
                    break;
                }
            }
            if (!found) {
                JOptionPane.showMessageDialog(null, "Product not found");
            }
            con.close();
        } catch (Exception e1) {
            JOptionPane.showMessageDialog(null, "Error: " + e1.getMessage());
        }
    }
}
