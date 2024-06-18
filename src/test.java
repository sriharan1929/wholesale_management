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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;
import javax.swing.JTable;

public class test extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField searchField;
    private JLabel lblMovieName;
    private JLabel lblGenre;
    private JLabel lblCountry;
    private JLabel lblRating;
    private JLabel lblMovieID;
    private JLabel lblImage;
    private JTable table;
    private JPanel panel_1;
    private JScrollPane scrollPane;
    private JButton btnExit;
    private JButton btnBookTicket;
    private String a, b, c, d, e1;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    test frame = new test();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public test() {
        setTitle("Grocery Application");
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
        panel.setBounds(0, 10, 1120, 760);
        contentPane.add(panel);

        JLabel lblNewLabel = new JLabel("Product");
        lblNewLabel.setBackground(new Color(0, 0, 0));
        lblNewLabel.setForeground(new Color(0, 0, 0));
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblNewLabel.setBounds(221, 84, 50, 22);
        panel.add(lblNewLabel);

        searchField = new JTextField();
        searchField.setFont(new Font("Tahoma", Font.PLAIN, 12));
        searchField.setColumns(10);
        searchField.setBounds(281, 86, 188, 19);
        panel.add(searchField);
        JButton searchButton = new JButton("Select");
        searchButton.setForeground(Color.WHITE);
        searchButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
        searchButton.setBorder(new EtchedBorder());
        searchButton.setBackground(new Color(0, 128, 64));
        searchButton.setBounds(486, 83, 85, 22);
        panel.add(searchButton);

        lblMovieID = new JLabel("PRODUCT ID: ");
        lblMovieID.setForeground(new Color(0, 0, 0));
        lblMovieID.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblMovieID.setBounds(432, 284, 282, 22);
        panel.add(lblMovieID);

        lblMovieName = new JLabel("PRODUCT NAME: ");
        lblMovieName.setForeground(new Color(0, 0, 0));
        lblMovieName.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblMovieName.setBounds(432, 316, 282, 22);
        panel.add(lblMovieName);
        lblGenre = new JLabel("BRAND: ");
        lblGenre.setForeground(new Color(0, 0, 0));
        lblGenre.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblGenre.setBounds(432, 348, 282, 22);
        panel.add(lblGenre);

        lblCountry = new JLabel("QUANTITY: ");
        lblCountry.setForeground(new Color(0, 0, 0));
        lblCountry.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblCountry.setBounds(432, 380, 282, 22);
        panel.add(lblCountry);

        lblRating = new JLabel("PRICE: ");
        lblRating.setForeground(new Color(0, 0, 0));
        lblRating.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblRating.setBounds(432, 412, 282, 22);
        panel.add(lblRating);

        lblImage = new JLabel();
        lblImage.setBounds(581, 65, 373, 209);
        panel.add(lblImage);

        JLabel HOME = new JLabel("Grocery's");
        HOME.setHorizontalAlignment(SwingConstants.CENTER);
        HOME.setForeground(new Color(128, 0, 0));
        HOME.setFont(new Font("OCR A Extended", Font.BOLD, 31));
        HOME.setBounds(10, 0, 1006, 45);
        panel.add(HOME);

        JSeparator separator = new JSeparator();
        separator.setBounds(10, 53, 986, 2);
        panel.add(separator);

        panel_1 = new JPanel();
        panel_1.setBounds(10, 177, 343, 288);
        panel.add(panel_1);
        panel_1.setLayout(null);

        scrollPane = new JScrollPane();
        scrollPane.setBounds(0, 0, 343, 288);
        panel_1.add(scrollPane);

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
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
            },
            new String[] {
                "Product_ID", "Product_name", "product_Brand", "Quantity", "Price"
            }
        ));
        table.getColumnModel().getColumn(0).setPreferredWidth(55);
        table.getColumnModel().getColumn(1).setPreferredWidth(109);
        table.getColumnModel().getColumn(4).setPreferredWidth(61);

        JButton btnUpdate = new JButton("Show");
        btnUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/logindetails", "root", "velsrI@22");
                    Statement st = con.createStatement();
                    String sql = "select * from grocery";
                    
                    PreparedStatement pts = con.prepareStatement(sql);
                    ResultSet rs = pts.executeQuery();
                    DefaultTableModel dt = (DefaultTableModel)table.getModel();
                    dt.setRowCount(0);
                    while (rs.next()) {
                        Object o[] = {
                            rs.getString("Product_ID"), 
                            rs.getString("Product_name"), 
                            rs.getString("product_Brand"), 
                            rs.getString("Quantity"), 
                            rs.getString("Price")
                        };
                        dt.addRow(o);
                    }
                    con.close();
                } catch (Exception ec) {
                    JOptionPane.showMessageDialog(null, "Error occurred while showing the data.");
                    ec.printStackTrace();
                }
            }
        });
        btnUpdate.setForeground(Color.WHITE);
        btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnUpdate.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
        btnUpdate.setBackground(new Color(30, 144, 255));
        btnUpdate.setBounds(10, 475, 85, 22);
        panel.add(btnUpdate);

        btnExit = new JButton("Back");
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Replace homepage with the actual class you want to navigate to
                // homepage info = new homepage();
                // homepage.main(null);
                dispose();
            }
        });
        btnExit.setForeground(Color.WHITE);
        btnExit.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnExit.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
        btnExit.setBackground(new Color(178, 34, 34));
        btnExit.setBounds(612, 472, 82, 28);
        panel.add(btnExit);

        btnBookTicket = new JButton("Add");
        btnBookTicket.setEnabled(false); // Initially disable the button
        btnBookTicket.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/logindetails", "root", "velsrI@22");
                    String sql = "INSERT INTO add1 VALUES (?, ?, ?, ?, ?)";
                    PreparedStatement pts = con.prepareStatement(sql);
                    pts.setString(1, a);
                    pts.setString(2, b);
                    pts.setString(3, c);
                    pts.setString(4, d);
                    pts.setString(5, e1);

                    pts.executeUpdate();
                    JOptionPane.showMessageDialog(null, "It has been registered");
                    con.close();
                } catch (Exception ef) {
                    JOptionPane.showMessageDialog(null, "It has not been registered");
                    ef.printStackTrace();
                }
            }
        });
        btnBookTicket.setForeground(Color.WHITE);
        btnBookTicket.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnBookTicket.setBorder(new EtchedBorder());
        btnBookTicket.setBackground(new Color(124, 252, 0));
        btnBookTicket.setBounds(411, 473, 111, 26);
        panel.add(btnBookTicket);

        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                searchMovie();
            }
        });
    }

    private void searchMovie() {
        String productname = searchField.getText().trim();
        if (!productname.isEmpty()) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/logindetails", "root", "velsrI@22");
                String sql = "SELECT * FROM grocery WHERE Product_name LIKE ?";
                PreparedStatement pst = con.prepareStatement(sql);
                pst.setString(1, "%" + productname + "%");
                ResultSet rs = pst.executeQuery();

                if (rs.next()) {
                    a = rs.getString("Product_ID");
                    b = rs.getString("Product_name");
                    c = rs.getString("product_Brand");
                    d = rs.getString("Quantity");
                    e1 = rs.getString("Price");
                    lblMovieID.setText("Product Id: " + a);
                    lblMovieName.setText("Product Name: " + b);
                    lblGenre.setText("Brand: " + c);
                    lblCountry.setText("Quantity: " + d);
                    lblRating.setText("Price: " + e1);

                    // Enable the Book Ticket button
                    btnBookTicket.setEnabled(true);
                } else {
                    JOptionPane.showMessageDialog(null, "No item found.");
                    clearLabels();
                    btnBookTicket.setEnabled(false); // Disable the Book Ticket button
                }
                con.close();
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error occurred while searching.");
                clearLabels();
                btnBookTicket.setEnabled(false); // Disable the Book Ticket button
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please enter a product name.");
            clearLabels();
            btnBookTicket.setEnabled(false); // Disable the Book Ticket button
        }
    }

    private void clearLabels() {
        lblMovieID.setText("PRODUCT ID: ");
        lblMovieName.setText("PRODUCT NAME: ");
        lblGenre.setText("BRAND: ");
        lblCountry.setText("QUANTITY: ");
        lblRating.setText("PRICE: ");
        lblImage.setIcon(null);
    }
}
