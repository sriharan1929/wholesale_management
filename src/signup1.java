import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;

public class signup1 extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField newuser;
    private JPasswordField newpass;
    private JPasswordField passwordField;
    private JLabel lblNewLabel_11;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    signup1 frame = new signup1();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public signup1() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1034, 742);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(240, 230, 140));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("User Name");
        lblNewLabel.setBounds(187, 148, 252, 42);
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
        contentPane.add(lblNewLabel);

        JLabel lblPassword = new JLabel("New Password");
        lblPassword.setBounds(191, 229, 193, 42);
        lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
        lblPassword.setFont(new Font("Tahoma", Font.BOLD, 25));
        contentPane.add(lblPassword);

        JLabel lblConfirmPassword = new JLabel("Confirm Password");
        lblConfirmPassword.setBounds(139, 313, 252, 45);
        lblConfirmPassword.setHorizontalAlignment(SwingConstants.CENTER);
        lblConfirmPassword.setFont(new Font("Tahoma", Font.BOLD, 25));
        contentPane.add(lblConfirmPassword);

        newuser = new JTextField();
        newuser.setBounds(422, 148, 371, 42);
        contentPane.add(newuser);
        newuser.setColumns(10);

        newpass = new JPasswordField();
        newpass.setBounds(422, 229, 371, 42);
        contentPane.add(newpass);

        passwordField = new JPasswordField();
        passwordField.setBounds(422, 313, 371, 42);
        contentPane.add(passwordField);

        JButton btnSignup = new JButton("Signup");
        btnSignup.setBounds(504, 395, 203, 45);
        btnSignup.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = newuser.getText();
                String password = new String(newpass.getPassword());
                String confirmPassword = new String(passwordField.getPassword());

                if (!isValidPassword(password)) {
                    JOptionPane.showMessageDialog(signup1.this, "Password must contain at least one uppercase letter, one number, and one special character", "Invalid Password", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (!password.equals(confirmPassword)) {
                    JOptionPane.showMessageDialog(signup1.this, "Passwords do not match", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/logindetails", "root", "velsrI@22");

                    String sql = "INSERT INTO loginpage (username, password) VALUES (?, ?)";
                    PreparedStatement ps = con1.prepareStatement(sql);
                    ps.setString(1, username);
                    ps.setString(2, password);
                    ps.executeUpdate();

                    JOptionPane.showMessageDialog(signup1.this, "Data created", "Success", JOptionPane.INFORMATION_MESSAGE);
                    con1.close();

                    // Navigate to Project_DBMS page
                    project_DBMS projectDbms = new project_DBMS();
                    projectDbms.setVisible(true);
                    dispose(); // Close the signup1 frame

                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(signup1.this, "Error while establishing connection", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnSignup.setFont(new Font("Tahoma", Font.BOLD, 18));
        contentPane.add(btnSignup);
        
        JButton btnNewButton = new JButton("");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    project_DBMS sf1 = new project_DBMS();
                    sf1.setVisible(true);
                    SwingUtilities.windowForComponent(btnNewButton).dispose();
                } catch (Exception rt) {
                    rt.printStackTrace();
                }
            }
        });
        btnNewButton.setIcon(new ImageIcon("C:\\Users\\balaj\\Downloads\\back (2).png"));
        btnNewButton.setBounds(10, 649, 150, 46);
        contentPane.add(btnNewButton);
        
        JLabel lblNewLabel_1;
        lblNewLabel_11 = new JLabel("");
        lblNewLabel_11.setIcon(new ImageIcon("C:\\Users\\balaj\\Downloads\\user (2).png"));
        lblNewLabel_11.setBounds(0, 149, 166, 154);
        contentPane.add(lblNewLabel_11);

        JRadioButton rdbtnNewRadioButton = new JRadioButton("Show Password");
        rdbtnNewRadioButton.setBounds(841, 244, 125, 25);
        contentPane.add(rdbtnNewRadioButton);
        
        JLabel lblNewLabel_11 = new JLabel("\r\n");
        lblNewLabel_11.setBounds(850, 559, 160, 146);
        lblNewLabel_11.setIcon(new ImageIcon("C:\\Users\\balaj\\Downloads\\people-poll.png"));
        contentPane.add(lblNewLabel_11);
        
        JLabel lblPasswordMustContain = new JLabel("Password must contain Maximum 8 Characters with 1 Uppercase,1 Special Character and 1 Number");
        lblPasswordMustContain.setBounds(422, 200, 578, 25);
        lblPasswordMustContain.setFont(new Font("Tahoma", Font.PLAIN, 13));
        contentPane.add(lblPasswordMustContain);
        
        JSeparator separator = new JSeparator();
        separator.setBounds(10, 78, 1000, 9);
        contentPane.add(separator);
        
        JLabel lblNewLabel_2 = new JLabel("Sign in to create your own Account");
        lblNewLabel_2.setForeground(new Color(139, 0, 0));
        lblNewLabel_2.setFont(new Font("Serif", Font.PLAIN, 30));
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2.setBounds(232, 10, 606, 57);
        contentPane.add(lblNewLabel_2);

        rdbtnNewRadioButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (rdbtnNewRadioButton.isSelected()) {
                    newpass.setEchoChar((char) 0);
                   // passwordField.setEchoChar((char) 0);
                } else {
                    newpass.setEchoChar('*');
                   // passwordField.setEchoChar('*');
                }
            }
        });
    }

    private boolean isValidPassword(String password) {
        return password.length() >= 8 && 
               password.matches(".*[A-Z].*") && 
               password.matches(".*\\d.*") &&
               password.matches(".*[!@#$%^&*(),.?\":{}|<>].*");
    }
}
