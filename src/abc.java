import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextArea;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;



public class abc extends JFrame {

    private static final long serialVersionUID = 1L;
    private DefaultTableModel model;
    private JPanel contentPane;
    private JTable table1;
    private JTextField txtsubtotal;
    private JTextField txtpay;
    private JTextField txtbalance;
    private int lastid;
    private JLabel lblMovie;
    private JTextField txtname;
    private JSpinner txtodc;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	abc frame = new abc();
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
    public abc() {
        setTitle("Book Ticket");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 809, 539);

        model = new DefaultTableModel();
        
        model.addColumn("Seat Type");
        model.addColumn("Price");
        model.addColumn("Quantity");
        model.addColumn("Total");
        model.addColumn("Name");
        table1 = new JTable(model);

        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 255));
        contentPane.setForeground(new Color(255, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 0, 0));
        panel.setBorder(null);
        panel.setBounds(0, 83, 402, 367);
        contentPane.add(panel);
        panel.setLayout(null);

        JCheckBox chk1 = new JCheckBox("ODC");
        chk1.setFocusPainted(false);
        chk1.setBackground(new Color(255, 0, 0));
        chk1.setForeground(new Color(255, 255, 255));
        chk1.setBounds(6, 46, 93, 26);
        panel.add(chk1);

        JCheckBox chk2 = new JCheckBox("Balcony");
        chk2.setForeground(new Color(255, 255, 255));
        chk2.setBackground(new Color(255, 0, 0));
        chk2.setBounds(6, 108, 74, 26);
        panel.add(chk2);

        JCheckBox chk3 = new JCheckBox("Box");
        chk3.setForeground(new Color(255, 255, 255));
        chk3.setBackground(new Color(255, 0, 0));
        chk3.setBounds(6, 163, 74, 26);
        panel.add(chk3);

        JCheckBox chk4 = new JCheckBox("Super Balcony");
        chk4.setForeground(new Color(255, 255, 255));
        chk4.setBackground(new Color(255, 0, 0));
        chk4.setBounds(6, 212, 111, 26);
        panel.add(chk4);

        txtodc = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        txtodc.setBounds(115, 44, 74, 31);
        panel.add(txtodc);

        JSpinner txtbal = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        txtbal.setBounds(115, 106, 74, 31);
        panel.add(txtbal);

        JSpinner txtbox = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        txtbox.setBounds(115, 161, 74, 31);
        panel.add(txtbox);

        JSpinner txtsupbal = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        txtsupbal.setBounds(115, 210, 74, 31);
        panel.add(txtsupbal);
        
        txtname = new JTextField();
        txtname.setBounds(115, 15, 167, 19);
        panel.add(txtname);
        txtname.setColumns(10);
        
        JLabel lblName = new JLabel("User's Name:");
        lblName.setForeground(Color.WHITE);
        lblName.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblName.setBounds(6, 13, 111, 20);
        panel.add(lblName);
        
                JButton btnAdd = new JButton("Booking");
                btnAdd.setBounds(291, 281, 101, 26);
                panel.add(btnAdd);
                btnAdd.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        String name = txtname.getText();
                        
                        int sum = 0;
                        int price;
                        int quantity;
                        int total;
                        
                        if (chk1.isSelected()) {
                            String odc = chk1.getText();
                            price = 400;
                            quantity = (int) txtodc.getValue();
                            total = price * quantity;
                            model.addRow(new Object[] { odc, price, quantity, total, name });
                        }
                        if (chk2.isSelected()) {
                            String balcony = chk2.getText();
                            price = 300;
                            quantity = (int) txtbal.getValue();
                            total = price * quantity;
                            model.addRow(new Object[] { balcony, price, quantity, total, name });
                        }
                        if (chk3.isSelected()) {
                            String box = chk3.getText();
                            price = 470;
                            quantity = (int) txtbox.getValue();
                            total = price * quantity;
                            model.addRow(new Object[] { box, price, quantity, total, name });
                        }
                        if (chk4.isSelected()) {
                            String superBalcony = chk4.getText();
                            price = 590;
                            quantity = (int) txtsupbal.getValue();
                            total = price * quantity;
                            model.addRow(new Object[] { superBalcony, price, quantity, total, name });
                        }

                        for (int i = 0; i < table1.getRowCount(); i++) {
                            sum += (int) table1.getValueAt(i, 3);
                        }
                        txtsubtotal.setText(String.valueOf(sum));
                        sales();
                    }
                });
                btnAdd.setForeground(Color.WHITE);
                btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 14));
                btnAdd.setBorder(new EtchedBorder());
                btnAdd.setBackground(new Color(124, 252, 0));

        JPanel panel_1 = new JPanel();
        panel_1.setBorder(null);
        panel_1.setBackground(new Color(255, 0, 0));
        panel_1.setBounds(0, 0, 793, 80);
        contentPane.add(panel_1);
        panel_1.setLayout(null);
        
        JLabel lblMovie1 = new JLabel("Book Ticket");
        lblMovie1.setBounds(10, 50, 275, 20);
        panel_1.add(lblMovie1);
        lblMovie1.setForeground(Color.WHITE);
        lblMovie1.setFont(new Font("Tahoma", Font.BOLD, 12));

        JLabel HOME = new JLabel("Movie Vault");
        HOME.setBounds(10, 0, 773, 50);
        panel_1.add(HOME);
        HOME.setHorizontalAlignment(SwingConstants.CENTER);
        HOME.setForeground(Color.WHITE);
        HOME.setFont(new Font("Papyrus", Font.BOLD, 31));

        JPanel panel_2 = new JPanel();
        panel_2.setLayout(null);
        panel_2.setBorder(null);
        panel_2.setBackground(Color.RED);
        panel_2.setBounds(406, 83, 387, 367);
        contentPane.add(panel_2);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 10, 363, 203);
        panel_2.add(scrollPane);

        table1 = new JTable(model);
        scrollPane.setViewportView(table1);

        txtsubtotal = new JTextField();
        txtsubtotal.setBounds(74, 225, 87, 19);
        panel_2.add(txtsubtotal);
        txtsubtotal.setFont(new Font("Tahoma", Font.PLAIN, 12));
        txtsubtotal.setColumns(10);

        JLabel lblSubtotal = new JLabel("Subtotal:");
        lblSubtotal.setBounds(10, 223, 71, 22);
        panel_2.add(lblSubtotal);
        lblSubtotal.setForeground(Color.WHITE);
        lblSubtotal.setFont(new Font("Tahoma", Font.BOLD, 12));

        JLabel lblPay = new JLabel("Paying amount:");
        lblPay.setBounds(171, 223, 104, 22);
        panel_2.add(lblPay);
        lblPay.setForeground(Color.WHITE);
        lblPay.setFont(new Font("Tahoma", Font.BOLD, 12));

        txtpay = new JTextField();
        txtpay.setBounds(286, 223, 87, 19);
        panel_2.add(txtpay);
        txtpay.setFont(new Font("Tahoma", Font.PLAIN, 12));
        txtpay.setColumns(10);

        JLabel lblBalance = new JLabel("Balance:");
        lblBalance.setBounds(10, 268, 71, 22);
        panel_2.add(lblBalance);
        lblBalance.setForeground(Color.WHITE);
        lblBalance.setFont(new Font("Tahoma", Font.BOLD, 12));

        txtbalance = new JTextField();
        txtbalance.setBounds(74, 270, 87, 19);
        panel_2.add(txtbalance);
        txtbalance.setFont(new Font("Tahoma", Font.PLAIN, 12));
        txtbalance.setColumns(10);

        JButton btnPrint = new JButton("Calculate");
        btnPrint.setBounds(262, 331, 101, 26);
        panel_2.add(btnPrint);
        btnPrint.setForeground(Color.WHITE);
        btnPrint.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnPrint.setBorder(new EtchedBorder());
        btnPrint.setBackground(new Color(0, 0, 255));
        
        JButton btnPdf = new JButton("Generate Bill");
        btnPdf.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Generate the bill
                StringBuilder bill = new StringBuilder();
                bill.append("=============================================\n");
                bill.append("                         Movie Ticket Bill          \n");
                bill.append("=============================================\n\n");
                bill.append(String.format("%-15s %-10s %-10s %-10s %-20s\n", "Seat Type", "Price", "Quantity", "Total", "Name"));

                
                for (int i = 0; i < table1.getRowCount(); i++) {
                    
                    String seatType = (String) table1.getValueAt(i, 0);
                    int price = (int) table1.getValueAt(i, 1);
                    int quantity = (int) table1.getValueAt(i, 2);
                    int total = (int) table1.getValueAt(i, 3);
                    String name = (String) table1.getValueAt(i, 4);

                    bill.append(String.format("%-15s %-10s %-10s %-10s %-20s\n", seatType, price, quantity, total, name));
                }

                
                bill.append("\nSubTotal: ").append(txtsubtotal.getText()).append("\n");
                bill.append("Paying amount: ").append(txtpay.getText()).append("\n");
                bill.append("Balance: ").append(txtbalance.getText()).append("\n");

                
                JTextArea textArea = new JTextArea(bill.toString());
                textArea.setFont(new Font("Arial", Font.PLAIN, 14));
                textArea.setEditable(false);
                JScrollPane scrollPane = new JScrollPane(textArea);
                scrollPane.setPreferredSize(new Dimension(400, 300));
                JOptionPane.showMessageDialog(null, scrollPane, "Movie Ticket Bill", JOptionPane.PLAIN_MESSAGE);
            }
        });


        btnPdf.setForeground(Color.WHITE);
        btnPdf.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnPdf.setBorder(new EtchedBorder());
        btnPdf.setBackground(new Color(0, 128, 0));
        btnPdf.setBounds(10, 331, 101, 26);
        panel_2.add(btnPdf);
        
                JButton btnExit = new JButton("Back to Dashboard");
                btnExit.setBounds(633, 465, 152, 27);
                contentPane.add(btnExit);
                btnExit.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                    	Dashboarda info = new Dashboarda();
        				Dashboarda.main(null);
        				dispose();
                        
                    }
                });
                btnExit.setForeground(Color.WHITE);
                btnExit.setFont(new Font("Tahoma", Font.PLAIN, 14));
                btnExit.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
                btnExit.setBackground(new Color(178, 34, 34));

        btnPrint.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int sub = Integer.parseInt(txtsubtotal.getText());
                int pay = Integer.parseInt(txtpay.getText());
                int bal = pay - sub;

                txtbalance.setText(String.valueOf(bal));
                sales();
            }
        });
    }

 
    public void sales() {
        Connection con = null;
        PreparedStatement ps1 = null;
        PreparedStatement ps2 = null;
        try {
            String subtotal = txtsubtotal.getText();
            String pay = txtpay.getText();
            String total = txtbalance.getText();

            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/movieticket", "root", "apple1");
            String query = "INSERT INTO ticket(subtotal, pay, balance) VALUES (?, ?, ?)";
            ps1 = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            ps1.setString(1, subtotal);
            ps1.setString(2, pay);
            ps1.setString(3, total);
            ps1.executeUpdate();

            ResultSet rs = ps1.getGeneratedKeys();

            if (rs.next()) {
                lastid = rs.getInt(1);
            }

            int rows = table1.getRowCount();
            String query1 = "INSERT INTO sales_product(sales_id, tickettype, quantity, price, total, name) VALUES (?, ?, ?, ?, ?, ?)";
            ps2 = con.prepareStatement(query1);

            for (int i = 0; i < rows; i++) {
                String tickettype = (String) table1.getValueAt(i, 0);
                int price = (int) table1.getValueAt(i, 1);
                int quantity = (int) table1.getValueAt(i, 2);
                int totalPerRow = (int) table1.getValueAt(i, 3);
                String name = (String) table1.getValueAt(i, 4); 

                ps2.setInt(1, lastid);
                ps2.setString(2, tickettype);
                ps2.setInt(3, quantity);
                ps2.setInt(4, price);
                ps2.setInt(5, totalPerRow);
                ps2.setString(6, name);
                ps2.executeUpdate();
            }

            JOptionPane.showMessageDialog(this, "Sales Complete!!");

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(abc.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (ps1 != null) ps1.close();
                if (ps2 != null) ps2.close();
                if (con != null) con.close();
            } catch (SQLException ex) {
                Logger.getLogger(abc.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}

class Movie_Search {
    public static void main(String[] args) {
        
    }
}
