import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.border.MatteBorder;
import java.awt.SystemColor;

public class LOGIN_PAGE extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LOGIN_PAGE frame = new LOGIN_PAGE();
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
	public LOGIN_PAGE() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 674, 482);
		contentPane = new JPanel();
		contentPane.setForeground(SystemColor.activeCaption);
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("USER NAME");
		lblNewLabel.setBackground(new Color(240, 240, 240));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Candara Light", Font.BOLD, 10));
		lblNewLabel.setBounds(105, 100, 73, 41);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(173, 109, 272, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(173, 161, 272, 19);
		contentPane.add(passwordField);
		
		JLabel lblNewLabel_1 = new JLabel("PASSWORD");
		lblNewLabel_1.setBounds(105, 162, 73, 16);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("LOG IN ");
		btnNewButton.setFont(new Font("Century", Font.BOLD, 10));
		btnNewButton.setBackground(SystemColor.textHighlight);
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBounds(260, 249, 85, 21);
		contentPane.add(btnNewButton);
	}
}
