import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.util.Random;
import javax.swing.JSeparator;

public class project_DBMS extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JLabel error;
    private JTextField textField;
    private JPasswordField pass;
    static String username;
    private JTextField captchaField;
    private JLabel captchaLabel;
    private String currentCaptcha;
    private final JSeparator separator_1 = new JSeparator();

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    project_DBMS frame = new project_DBMS();
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
    public project_DBMS() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 1287, 730);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(240, 230, 140));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        error = new JLabel("");
        error.setBounds(452, 342, 250, 30);
        error.setForeground(Color.RED);
        contentPane.add(error);

        JLabel lblNewLabel_1 = new JLabel("USER NAME");
        lblNewLabel_1.setBounds(333, 258, 181, 43);
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setForeground(Color.BLACK);
        lblNewLabel_1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 25));
        contentPane.add(lblNewLabel_1);

        textField = new JTextField();
        textField.setBounds(536, 256, 271, 45);
        textField.setColumns(10);
        contentPane.add(textField);

        JLabel lblNewLabel_2 = new JLabel("SIGN IN ");
        lblNewLabel_2.setBounds(290, 173, 181, 62);
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2.setForeground(new Color(128, 0, 0));
        lblNewLabel_2.setFont(new Font("Bodoni MT Condensed", Font.BOLD, 45));
        lblNewLabel_2.setBackground(new Color(211, 211, 211));
        contentPane.add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel("to treat your needs :)");
        lblNewLabel_3.setBounds(421, 186, 308, 39);
        lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_3.setForeground(new Color(0, 100, 0));
        lblNewLabel_3.setFont(new Font("Maiandra GD", Font.BOLD, 26));
        lblNewLabel_3.setBackground(Color.GRAY);
        contentPane.add(lblNewLabel_3);

        JLabel lblNewLabel = new JLabel("PASSWORD");
        lblNewLabel.setBounds(333, 335, 181, 41);
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setForeground(Color.BLACK);
        lblNewLabel.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 25));
        contentPane.add(lblNewLabel);

        pass = new JPasswordField();
        pass.setBounds(536, 331, 271, 45);
        contentPane.add(pass);

        JRadioButton rdbtnNewRadioButton = new JRadioButton("Show password");
        rdbtnNewRadioButton.setBounds(827, 335, 135, 30);
        rdbtnNewRadioButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (rdbtnNewRadioButton.isSelected()) {
                    pass.setEchoChar((char) 0);
                } else {
                    pass.setEchoChar('*');
                }
            }
        });
        rdbtnNewRadioButton.setFont(new Font("Serif", Font.BOLD, 15));
        contentPane.add(rdbtnNewRadioButton);

        JLabel lblNewLabel_4 = new JLabel("Are You a NEW USER?");
        lblNewLabel_4.setBounds(289, 578, 277, 49);
        lblNewLabel_4.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 24));
        contentPane.add(lblNewLabel_4);

        JButton btnNewButton_1_1 = new JButton("Forget Password");
        btnNewButton_1_1.setBounds(794, 503, 257, 43);
        btnNewButton_1_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                reset nf1 = new reset();
                nf1.setVisible(true);
                SwingUtilities.windowForComponent(btnNewButton_1_1).dispose();
            }
        });
        btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
        contentPane.add(btnNewButton_1_1);

        JButton btnNewButton_1 = new JButton("SIGNIN");
        btnNewButton_1.setBounds(576, 581, 174, 49);
        btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\balaj\\Downloads\\user (1).png"));
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                signup1 nf = new signup1();
                nf.setVisible(true);
                SwingUtilities.windowForComponent(btnNewButton_1).dispose();
            }
        });
        btnNewButton_1.setFont(new Font("Dubai", Font.BOLD, 20));
        contentPane.add(btnNewButton_1);

        captchaField = new JTextField();
        captchaField.setBounds(536, 450, 250, 43);
        contentPane.add(captchaField);
        captchaField.setColumns(10);

        captchaLabel = new JLabel("");
        captchaLabel.setBounds(536, 399, 230, 41);
        captchaLabel.setForeground(new Color(0, 0, 0));
        captchaLabel.setBackground(new Color(0, 0, 0));
        captchaLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        contentPane.add(captchaLabel);

        // Generate and Display CAPTCHA
        generateCaptcha();

        JButton btnNewButton_3 = new JButton("LOGIN");
        btnNewButton_3.setBounds(576, 503, 174, 45);
        btnNewButton_3.setIcon(new ImageIcon("C:\\Users\\balaj\\Downloads\\password.png"));
        btnNewButton_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int et = 0;
                    String us = textField.getText();
                    String ps = new String(pass.getPassword());

                    // CAPTCHA validation
                    if (!captchaField.getText().equals(currentCaptcha)) {
                        error.setText("Invalid CAPTCHA");
                        return;
                    }

                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/logindetails", "root", "velsrI@22");
                    Statement st = con.createStatement();
                    String sql = "Select * from loginpage";
                    ResultSet rs = st.executeQuery(sql);
                    while (rs.next()) {
                        username = rs.getString("username");
                        String password = rs.getString("password");

                        if (us.equals(username) && ps.equals(password)) {
                            new homepage().setVisible(true);
                            SwingUtilities.windowForComponent(btnNewButton_3).dispose();
                            et = 1;
                            break;
                        } else {
                            textField.setText("");
                            pass.setText("");
                            continue;
                        }
                    }
                    if (et == 0) {
                        error.setText("Invalid username or password");
                    }
                } catch (Exception o) {
                    JOptionPane.showMessageDialog(btnNewButton_3, "Error while establishing connection", "Connection Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnNewButton_3.setForeground(new Color(0, 0, 128));
        btnNewButton_3.setFont(new Font("Dubai", Font.BOLD, 30));
        btnNewButton_3.setBackground(Color.WHITE);
        contentPane.add(btnNewButton_3);

        JButton btnRefreshCaptcha = new JButton("");
        btnRefreshCaptcha.setBounds(805, 389, 53, 43);
        btnRefreshCaptcha.setIcon(new ImageIcon("C:\\Users\\balaj\\Downloads\\refresh.png"));
        btnRefreshCaptcha.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                generateCaptcha();
            }
        });
        contentPane.add(btnRefreshCaptcha);

        JLabel lblNewLabel_5 = new JLabel("New label");
        lblNewLabel_5.setBounds(707, 146, 100, 100);
        lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\balaj\\Downloads\\icons8-hand-with-smartphone-100.png"));
        contentPane.add(lblNewLabel_5);

        JLabel lblNewLabel_6 = new JLabel("New label");
        lblNewLabel_6.setBounds(250, 0, 100, 100);
        lblNewLabel_6.setIcon(new ImageIcon("C:\\Users\\balaj\\Downloads\\icons8-smile-100.png"));
        contentPane.add(lblNewLabel_6);

        JLabel lblNewLabel_7 = new JLabel("New label");
        lblNewLabel_7.setBounds(204, 197, 100, 115);
        lblNewLabel_7.setIcon(new ImageIcon("C:\\Users\\balaj\\Downloads\\icons8-user-96.png"));
        contentPane.add(lblNewLabel_7);

        JLabel lblNewLabel_8 = new JLabel("");
        lblNewLabel_8.setBounds(1199, 10, 64, 79);
        lblNewLabel_8.setIcon(new ImageIcon("C:\\Users\\balaj\\Downloads\\discount-coupon.png"));
        contentPane.add(lblNewLabel_8);

        JLabel lblNewLabel_9 = new JLabel("New label");
        lblNewLabel_9.setBounds(1163, 583, 100, 100);
        lblNewLabel_9.setIcon(new ImageIcon("C:\\Users\\balaj\\Downloads\\icons8-dividends-96.png"));
        contentPane.add(lblNewLabel_9);

        JLabel lblNewLabel_10 = new JLabel("New label");
        lblNewLabel_10.setBounds(1129, 391, 100, 100);
        lblNewLabel_10.setIcon(new ImageIcon("C:\\Users\\balaj\\Downloads\\icons8-networking-100.png"));
        contentPane.add(lblNewLabel_10);

        JLabel lblNewLabel_11 = new JLabel("");
        lblNewLabel_11.setBounds(898, 197, 135, 100);
        lblNewLabel_11.setIcon(new ImageIcon("C:\\Users\\balaj\\Downloads\\cart.png"));
        contentPane.add(lblNewLabel_11);
        
        JLabel lblNewLabel_12 = new JLabel("");
        lblNewLabel_12.setBounds(143, 568, 135, 128);
        lblNewLabel_12.setIcon(new ImageIcon("C:\\Users\\balaj\\Downloads\\social.png"));
        contentPane.add(lblNewLabel_12);
        
        JLabel lblNewLabel_13 = new JLabel("Enter Captcha");
        lblNewLabel_13.setBounds(313, 448, 218, 43);
        lblNewLabel_13.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 25));
        contentPane.add(lblNewLabel_13);
        
        JSeparator separator = new JSeparator();
        separator.setBounds(0, 74, 1, 2);
        contentPane.add(separator);
        
        JLabel lblNewLabel_14 = new JLabel("ONLINE   WHOLE   SALE   SHOP ");
        lblNewLabel_14.setBounds(376, 10, 617, 79);
        lblNewLabel_14.setForeground(new Color(178, 34, 34));
        lblNewLabel_14.setFont(new Font("Modern No. 20", Font.BOLD, 35));
        lblNewLabel_14.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(lblNewLabel_14);
        separator_1.setBounds(0, 94, 1229, 36);
        separator_1.setForeground(new Color(128, 0, 0));
        separator_1.setBackground(new Color(255, 0, 0));
        contentPane.add(separator_1);
    }

    private void generateCaptcha() {
        currentCaptcha = generateRandomCaptcha();
        captchaLabel.setText(currentCaptcha);
    }

    private String generateRandomCaptcha() {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random rnd = new Random();
        StringBuilder captcha = new StringBuilder(6);
        for (int i = 0; i < 6; i++) {
            captcha.append(chars.charAt(rnd.nextInt(chars.length())));
        }
        return captcha.toString();
    }
}
