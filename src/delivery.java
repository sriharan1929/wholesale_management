import java.awt.EventQueue;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.JTextPane;

public class delivery extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField textField_5;
    private JTextPane textPane1;
    private JComponent btnNewButton;
	private double totalPrice;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    delivery frame = new delivery();
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
    public delivery() {
    	totalPrice = MyCart.totalPrice;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1248, 753);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 228, 181));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JSeparator separator = new JSeparator();
        separator.setBounds(0, 75, 1224, 7);
        contentPane.add(separator);

        JLabel lblNewLabel = new JLabel("Name:");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lblNewLabel.setBounds(75, 112, 173, 29);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Address :");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lblNewLabel_1.setBounds(75, 171, 173, 29);
        contentPane.add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("City:");
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lblNewLabel_2.setBounds(75, 238, 173, 29);
        contentPane.add(lblNewLabel_2);

        JLabel lblNewLabel_2_1 = new JLabel("State:");
        lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2_1.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lblNewLabel_2_1.setBounds(75, 295, 173, 29);
        contentPane.add(lblNewLabel_2_1);

        JLabel lblNewLabel_2_1_1 = new JLabel("Pincode:");
        lblNewLabel_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2_1_1.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lblNewLabel_2_1_1.setBounds(61, 360, 173, 29);
        contentPane.add(lblNewLabel_2_1_1);

        JLabel lblNewLabel_2_1_1_1 = new JLabel("Mobile NO:");
        lblNewLabel_2_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2_1_1_1.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lblNewLabel_2_1_1_1.setBounds(50, 420, 173, 29);
        contentPane.add(lblNewLabel_2_1_1_1);

        textField = new JTextField();
        textField.setBounds(212, 112, 261, 34);
        contentPane.add(textField);
        textField.setColumns(10);

        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(212, 171, 261, 34);
        contentPane.add(textField_1);

        textField_2 = new JTextField();
        textField_2.setColumns(10);
        textField_2.setBounds(212, 238, 261, 34);
        contentPane.add(textField_2);

        textField_3 = new JTextField();
        textField_3.setColumns(10);
        textField_3.setBounds(212, 305, 261, 34);
        contentPane.add(textField_3);

        textField_4 = new JTextField();
        textField_4.setColumns(10);
        textField_4.setBounds(212, 363, 261, 34);
        contentPane.add(textField_4);

        // Apply DocumentFilter to textField_4 for 6-digit number constraint
        ((AbstractDocument) textField_4.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
                if (isValidInput(fb.getDocument().getLength(), string, 6)) {
                    super.insertString(fb, offset, string, attr);
                } else {
                    JOptionPane.showMessageDialog(null, "Pincode must be 6 digits");
                }
            }

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                if (isValidInput(fb.getDocument().getLength() - length, text, 6)) {
                    super.replace(fb, offset, length, text, attrs);
                } else {
                    JOptionPane.showMessageDialog(null, "Pincode must be 6 digits");
                }
            }

            private boolean isValidInput(int currentLength, String input, int maxLength) {
                return (currentLength + input.length() <= maxLength) && input.chars().allMatch(Character::isDigit);
            }
        });

        textField_5 = new JTextField();
        textField_5.setColumns(10);
        textField_5.setBounds(212, 423, 261, 34);
        contentPane.add(textField_5);

        // Apply DocumentFilter to textField_5 for 10-digit number constraint
        ((AbstractDocument) textField_5.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
                if (isValidInput(fb.getDocument().getLength(), string, 10)) {
                    super.insertString(fb, offset, string, attr);
                } else {
                    JOptionPane.showMessageDialog(null, "Mobile number must be 10 digits");
                }
            }

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                if (isValidInput(fb.getDocument().getLength() - length, text, 10)) {
                    super.replace(fb, offset, length, text, attrs);
                } else {
                    JOptionPane.showMessageDialog(null, "Mobile number must be 10 digits");
                }
            }

            private boolean isValidInput(int currentLength, String input, int maxLength) {
                return (currentLength + input.length() <= maxLength) && input.chars().allMatch(Character::isDigit);
            }
        });

        JButton btnNewButton = new JButton("Confirm");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Handle confirm button action here
                String Name = textField.getText();
                String Address = textField_1.getText();
                String City = textField_2.getText();
                String State = textField_3.getText();
                String Pincode = textField_4.getText();
                String Mobile_no = textField_5.getText();
                
                if (Pincode.length() != 6) {
                    JOptionPane.showMessageDialog(null, "Pincode must be 6 digits");
                    return;
                }
                
                if (Mobile_no.length() != 10) {
                    JOptionPane.showMessageDialog(null, "Mobile number must be 10 digits");
                    return;
                }

                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/logindetails", "root", "velsrI@22");
                    String query = "INSERT INTO delivery VALUES (?, ?, ?, ?, ?, ?)";
                    PreparedStatement pst = con.prepareStatement(query);
                    pst.setString(1, Name);
                    pst.setString(2, Address);
                    pst.setString(3, City);
                    pst.setString(4, State);
                    pst.setString(5, Pincode);
                    pst.setString(6, Mobile_no);

                    int rowsAffected = pst.executeUpdate();
                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog(null, "Successfully Inserted");
                        // Display the inserted values in textPane1
                        textPane1.setText(generateReceipt(Name, Address, City, State, Pincode, Mobile_no));
                    }

                    pst.close();
                    con.close();
                } catch (SQLException | ClassNotFoundException e1) {
                    e1.printStackTrace();
                }
            }
        });
        btnNewButton.setFont(new Font("Lucida Fax", Font.BOLD, 25));
        btnNewButton.setBounds(193, 499, 180, 43);
        contentPane.add(btnNewButton);

        JLabel lblNewLabel_3 = new JLabel("Shipping details");
        lblNewLabel_3.setFont(new Font("Bookman Old Style", Font.BOLD, 30));
        lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_3.setBounds(392, 20, 352, 43);
        contentPane.add(lblNewLabel_3);

        textPane1 = new JTextPane();
        textPane1.setBounds(588, 106, 596, 433);
        contentPane.add(textPane1);

        JButton btnNewButton_1 = new JButton("BACK");
        btnNewButton_1.addActionListener(new ActionListener() {
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
        btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnNewButton_1.setBounds(10, 663, 251, 43);
        contentPane.add(btnNewButton_1);

        JButton btnNewButton_2 = new JButton("Cash On Delivery");
        btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/logindetails", "root", "velsrI@22");
                Statement st = con.createStatement();
                String sql = "truncate table add1";
                st.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "Thanks For Shopping");
                con.close();
            } catch (Exception e1) {
                JOptionPane.showMessageDialog(null, "Error: " + e1.getMessage());}
        	
            }
        });
        btnNewButton_2.setBounds(588, 602, 346, 49);
        contentPane.add(btnNewButton_2);
        
        JButton btnNewButton_3 = new JButton("UPI Payment");
        btnNewButton_3.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		try {
                    pay sf1 = new pay();
                    sf1.setVisible(true);
                    SwingUtilities.windowForComponent(btnNewButton).dispose();
                } catch (Exception rt) {
                    rt.printStackTrace();
                }
        	}
        });
        btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 24));
        btnNewButton_3.setBounds(973, 602, 251, 49);
        contentPane.add(btnNewButton_3);
    }

    private String generateReceipt(String Name, String Address, String City, String State, String Pincode, String Mobile_no) {
        return "=======================================================\n" +
               "                             DBMS STORE                         \n" +
               "=======================================================\n" +
               "                             SHIPMENT DETAILS SLIP             \n" +
               "=======================================================\n\n" +
               String.format("%-15s: %s\n", "Name", Name) +
               "-------------------------------------------------------\n" +
               String.format("%-15s: %s\n", "Address", Address) +
               "-------------------------------------------------------\n" +
               String.format("%-15s: %s\n", "City", City) +
               "-------------------------------------------------------\n" +
               String.format("%-15s: %s\n", "State", State) +
               "-------------------------------------------------------\n" +
               String.format("%-15s: %s\n", "Pincode", Pincode) +
               "-------------------------------------------------------\n" +
               String.format("%-15s: %s\n", "Mobile No", Mobile_no) +
               "-------------------------------------------------------\n" +
               String.format("%-15s: %s\n", "total Price", totalPrice) +
               "=======================================================\n" +
               "YOUR ORDERS WILL BE SHIPPED SOON!!!!\n" +
               "                HAPPY SHOPPING!!!!\n";
    }
}
