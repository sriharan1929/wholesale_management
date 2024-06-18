import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class project_food_delivery extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField passwordField;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					project_food_delivery frame = new project_food_delivery();
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
	public project_food_delivery() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0,0,1287,730);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("PASSWORD");
		lblNewLabel.setForeground(UIManager.getColor("ToolBar.foreground"));
		lblNewLabel.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(599, 322, 181, 41);
		contentPane.add(lblNewLabel);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Dubai Light", Font.BOLD, 20));
		passwordField.setBounds(790, 323, 271, 45);
		contentPane.add(passwordField);
		
		JLabel lblNewLabel_1 = new JLabel("USER NAME");
		lblNewLabel_1.setForeground(UIManager.getColor("ToolBar.foreground"));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 25));
		lblNewLabel_1.setBounds(599, 225, 181, 43);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(790, 223, 271, 45);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("SIGN IN ");
		lblNewLabel_2.setForeground(new Color(255, 0, 102));
		lblNewLabel_2.setFont(new Font("Bodoni MT Condensed", Font.BOLD, 42));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(581, 137, 120, 52);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("to treat your habit :)");
		lblNewLabel_3.setBackground(new Color(128, 128, 128));
		lblNewLabel_3.setForeground(new Color(105, 105, 105));
		lblNewLabel_3.setFont(new Font("Maiandra GD", Font.BOLD, 26));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(670, 149, 308, 39);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("Sign in");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setForeground(new Color(0, 0, 128));
		btnNewButton.setFont(new Font("Dubai", Font.BOLD, 30));
		btnNewButton.setBounds(847, 391, 169, 45);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_6 = new JLabel("Don't have an Account?");
		lblNewLabel_6.setFont(new Font("SansSerif", Font.BOLD, 25));
		lblNewLabel_6.setBounds(676, 523, 289, 23);
		contentPane.add(lblNewLabel_6);
		
		JButton btnNewButton_1 = new JButton("Sign up");
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.setForeground(new Color(0, 0, 205));
		btnNewButton_1.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		btnNewButton_1.setBounds(960, 527, 110, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("About");
		btnNewButton_2.setBounds(718, 596, 85, 21);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_4 = new JLabel("Forget Password?");
		lblNewLabel_4.setFont(new Font("SansSerif", Font.BOLD, 25));
		lblNewLabel_4.setBounds(676, 474, 224, 39);
		contentPane.add(lblNewLabel_4);
		
		JButton btnNewButton_3 = new JButton("click here");
		btnNewButton_3.setForeground(new Color(0, 0, 205));
		btnNewButton_3.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		btnNewButton_3.setBounds(913, 486, 148, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Privacy");
		btnNewButton_4.setBounds(847, 596, 85, 21);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Terms");
		btnNewButton_5.setBounds(976, 596, 85, 21);
		contentPane.add(btnNewButton_5);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\balaj\\Downloads\\style-quotes-dress-.jpg"));
		lblNewLabel_5.setBounds(88, 59, 450, 372);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon("C:\\Users\\balaj\\Downloads\\clark-street-mercantile-qnKhZJPKFD8-unsplash.jpg"));
		lblNewLabel_7.setBounds(-13, -40, 1600, 935);
		contentPane.add(lblNewLabel_7);
	}
}
