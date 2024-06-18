import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;

public class pay extends JFrame {

    private double totalPrice;

    public pay() {
    	getContentPane().setBackground(new Color(240, 230, 140));
        totalPrice = MyCart.totalPrice;

        setTitle("Payment Options");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 883, 542);
        getContentPane().setLayout(null);

        JLabel lblTotalPrice = new JLabel("Total Price:");
        lblTotalPrice.setHorizontalAlignment(SwingConstants.CENTER);
        lblTotalPrice.setBounds(296, 204, 136, 41);
        lblTotalPrice.setFont(new Font("Tahoma", Font.BOLD, 20));
        getContentPane().add(lblTotalPrice);

        JLabel totprice = new JLabel("New label");
        totprice.setHorizontalAlignment(SwingConstants.CENTER);
        totprice.setBounds(435, 205, 120, 41);
        totprice.setText(String.valueOf(totalPrice));
        totprice.setFont(new Font("Tahoma", Font.BOLD, 18));
        getContentPane().add(totprice);

        JButton btnGpay = new JButton("");
        btnGpay.setIcon(new ImageIcon("C:\\Users\\balaj\\Downloads\\google-pay (1).png"));
        btnGpay.setBounds(333, 333, 184, 41);
        btnGpay.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	Gpay sf = new Gpay();
				sf.setVisible(true);
				SwingUtilities.windowForComponent(btnGpay).dispose();
            	
                // Handle cash payment
                JOptionPane.showMessageDialog(null, "Please pay cash amount: " + totalPrice);
            }
        });
        btnGpay.setFont(new Font("Tahoma", Font.PLAIN, 14));
        getContentPane().add(btnGpay);

        JButton btnBack = new JButton("Back");
        btnBack.setBounds(10, 472, 89, 23);
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	MyCart sf = new MyCart();
				sf.setVisible(true);
				SwingUtilities.windowForComponent(btnBack).dispose();
            }
        });
        btnBack.setFont(new Font("Tahoma", Font.PLAIN, 14));
        getContentPane().add(btnBack);
        
        JButton btnPhonepe = new JButton("");
        btnPhonepe.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		PhonePe sf = new PhonePe();
				sf.setVisible(true);
				SwingUtilities.windowForComponent(btnPhonepe).dispose();
        	}
        });
        btnPhonepe.setIcon(new ImageIcon("C:\\Users\\balaj\\Downloads\\phonepe (2).png"));
        btnPhonepe.setBounds(333, 268, 184, 41);
        btnPhonepe.setFont(new Font("Tahoma", Font.PLAIN, 14));
        getContentPane().add(btnPhonepe);
        
        JLabel lblNewLabel_1 = new JLabel("Total Price of the products you Billed ");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_1.setBounds(165, 154, 523, 29);
        getContentPane().add(lblNewLabel_1);
        
        JLabel lblNewLabel_1_1 = new JLabel("Online Payment");
        lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1_1.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 46));
        lblNewLabel_1_1.setBounds(165, 0, 476, 74);
        getContentPane().add(lblNewLabel_1_1);
        
        JSeparator separator = new JSeparator();
        separator.setForeground(new Color(178, 34, 34));
        separator.setBackground(new Color(220, 20, 60));
        separator.setBounds(10, 80, 849, 2);
        getContentPane().add(separator);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    pay frame = new pay(); // Pass the total price here
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
