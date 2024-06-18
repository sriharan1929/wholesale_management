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
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

public class signup extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField newuser;
    private JPasswordField newpass;
    private JPasswordField passwordField;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    signup frame = new signup();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public signup() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(200, 200, 1265, 776);
        contentPane = new JPanel();
        contentPane.setForeground(new Color(240, 230, 140));
        contentPane.setBackground(new Color(240, 230, 140));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel newuser1 = new JLabel("USER NAME");
        newuser1.setHorizontalAlignment(SwingConstants.CENTER);
        newuser1.setFont(new Font("Serif", Font.BOLD, 25));
        newuser1.setBounds(178, 136, 202, 47);
        contentPane.add(newuser1);

        JLabel newpass1 = new JLabel("PASSWORD");
        newpass1.setFont(new Font("Serif", Font.BOLD, 25));
        newpass1.setBounds(222, 243, 150, 47);
        contentPane.add(newpass1);

        newuser = new JTextField();
        newuser.setBounds(390, 137, 419, 46);
        contentPane.add(newuser);
        newuser.setColumns(10);

        newpass = new JPasswordField();
        newpass.setBounds(390, 243, 419, 47);
        contentPane.add(newpass);
        newpass.setColumns(10);

        JButton signin = new JButton("CONFIRM");
        signin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String nu = newuser.getText();
                    String np = new String(newpass.getPassword());
                    String confPass = new String(passwordField.getPassword());

                    if (!isValidPassword(np)) {
                        JOptionPane.showMessageDialog(signin, "Password must contain at least one uppercase letter and one number", "Invalid Password", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    if (!np.equals(confPass)) {
                        JOptionPane.showMessageDialog(signin, "Passwords do not match", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/logindetails", "root", "velsrI@22");

                    String sql1 = "SELECT COUNT(*) AS count FROM loginpage WHERE username=?";
                    PreparedStatement ps1 = con1.prepareStatement(sql1);
                    ps1.setString(1, nu);
                    ResultSet res1 = ps1.executeQuery();

                    if (res1.next() && res1.getInt("count") > 0) {
                        JOptionPane.showMessageDialog(signin, "Username already exists", "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        String sql2 = "INSERT INTO loginpage (username, password) VALUES (?, ?)";
                        PreparedStatement ps2 = con1.prepareStatement(sql2);
                        ps2.setString(1, nu);
                        ps2.setString(2, np);
                        ps2.executeUpdate();
                        JOptionPane.showMessageDialog(signin, "Data created", "Success", JOptionPane.INFORMATION_MESSAGE);
                    }

                    con1.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(signin, "Error while establishing connection", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        signin.setFont(new Font("Serif", Font.BOLD, 25));
        signin.setBounds(449, 446, 306, 46);
        contentPane.add(signin);

        JLabel lblNewLabel = new JLabel("Maximum 8 Characters with 1 Uppercase and Number");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel.setBounds(449, 210, 317, 25);
        contentPane.add(lblNewLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(390, 333, 419, 47);
        contentPane.add(passwordField);

        JLabel lblConfirmPassword = new JLabel("CONFIRM PASSWORD");
        lblConfirmPassword.setFont(new Font("Serif", Font.BOLD, 25));
        lblConfirmPassword.setBounds(100, 333, 289, 46);
        contentPane.add(lblConfirmPassword);

        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\balaj\\Downloads\\user (2).png"));
        lblNewLabel_1.setBounds(0, 0, 166, 154);
        contentPane.add(lblNewLabel_1);

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
        btnNewButton.setBounds(0, 693, 150, 46);
        contentPane.add(btnNewButton);

        JRadioButton rdbtnNewRadioButton = new JRadioButton("Show Password");
        rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        rdbtnNewRadioButton.setBounds(847, 303, 150, 25);
        contentPane.add(rdbtnNewRadioButton);

        rdbtnNewRadioButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (rdbtnNewRadioButton.isSelected()) {
                    newpass.setEchoChar((char) 0);
                } else {
                    newpass.setEchoChar('*');
                    passwordField.setEchoChar('*');
                }
            }
        });
    }

    private boolean isValidPassword(String password) {
        return password.matches(".*[A-Z].*") && password.matches(".*\\d.*");
    }
}
