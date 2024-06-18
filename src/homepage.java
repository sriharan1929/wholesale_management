import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class homepage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					homepage frame = new homepage();
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
	public homepage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1020, 670);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 222, 173));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					station sf1 = new  station();
				sf1.setVisible(true);
				SwingUtilities.windowForComponent(btnNewButton).dispose();}
				catch(Exception rt) {
					rt.printStackTrace();				}
			}
		});
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\balaj\\Downloads\\stationery.png"));
		btnNewButton.setBounds(533, 329, 189, 149);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(project_DBMS.username);
				 dairys sf = new dairys();
				sf.setVisible(true);
				SwingUtilities.windowForComponent(btnNewButton_1).dispose();
			}
		});
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\balaj\\Downloads\\dairy-products (6).png"));
		btnNewButton_1.setBounds(303, 93, 189, 149);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fruits sf = new fruits();
				sf.setVisible(true);
				SwingUtilities.windowForComponent(btnNewButton_2).dispose();
			}
		});
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.setIcon(new ImageIcon("C:\\Users\\balaj\\Downloads\\vegetable.png"));
		btnNewButton_2.setBounds(533, 93, 189, 149);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					munch sf1 = new  munch();
				sf1.setVisible(true);
				SwingUtilities.windowForComponent(btnNewButton_3).dispose();}
				catch(Exception rt) {
					rt.printStackTrace();				}
			}
		});
		btnNewButton_3.setBackground(Color.WHITE);
		btnNewButton_3.setIcon(new ImageIcon("C:\\Users\\balaj\\Downloads\\snack.png"));
		btnNewButton_3.setBounds(303, 329, 189, 149);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					personal sf1 = new  personal();
				sf1.setVisible(true);
				SwingUtilities.windowForComponent(btnNewButton_4).dispose();}
				catch(Exception rt) {
					rt.printStackTrace();				}
			}
		});
		btnNewButton_4.setBackground(Color.WHITE);
		btnNewButton_4.setIcon(new ImageIcon("C:\\Users\\balaj\\Downloads\\cosmetics (1).png"));
		btnNewButton_4.setBounds(761, 329, 189, 149);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(project_DBMS.username);
				 Sample sf = new Sample();
				sf.setVisible(true);
				SwingUtilities.windowForComponent(btnNewButton_1).dispose();
			}
		});
		btnNewButton_5.setBackground(Color.WHITE);
		btnNewButton_5.setIcon(new ImageIcon("C:\\Users\\balaj\\Downloads\\spices.png"));
		btnNewButton_5.setBounds(63, 93, 189, 149);
		contentPane.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					Home_essen sf1 = new  Home_essen();
				sf1.setVisible(true);
				SwingUtilities.windowForComponent(btnNewButton_6).dispose();}
				catch(Exception rt) {
					rt.printStackTrace();				}
			}
		});
		btnNewButton_6.setBackground(Color.WHITE);
		btnNewButton_6.setIcon(new ImageIcon("C:\\Users\\balaj\\Downloads\\cleaning.png"));
		btnNewButton_6.setBounds(761, 93, 189, 149);
		contentPane.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					chocolate sf1 = new  chocolate();
				sf1.setVisible(true);
				SwingUtilities.windowForComponent(btnNewButton_7).dispose();}
				catch(Exception rt) {
					rt.printStackTrace();				}
			}
		});
		btnNewButton_7.setBackground(Color.WHITE);
		btnNewButton_7.setIcon(new ImageIcon("C:\\Users\\balaj\\Downloads\\chocolate (2).png"));
		btnNewButton_7.setBounds(63, 329, 189, 149);
		contentPane.add(btnNewButton_7);
		
		JLabel lblNewLabel = new JLabel("Didn't find what you are looking for?");
		lblNewLabel.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 20));
		lblNewLabel.setBounds(612, 541, 338, 34);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Suggest something &\r\nwe will look into it ");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setToolTipText("");
		lblNewLabel_1.setFont(new Font("Gill Sans MT", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(652, 575, 272, 17);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton_8 = new JButton("Suggest a product ");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				suggestion_box sf = new suggestion_box();
				sf.setVisible(true);
				SwingUtilities.windowForComponent(btnNewButton_8).dispose();
			}
		});
		btnNewButton_8.setBackground(Color.WHITE);
		btnNewButton_8.setForeground(new Color(50, 205, 50));
		btnNewButton_8.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 12));
		btnNewButton_8.setBounds(705, 602, 163, 21);
		contentPane.add(btnNewButton_8);
		
		JLabel lblNewLabel_2 = new JLabel("Grocery");
		lblNewLabel_2.setFont(new Font("Bell MT", Font.BOLD, 20));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(63, 252, 189, 21);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Dairy\r\n");
		lblNewLabel_3.setFont(new Font("Bell MT", Font.BOLD, 20));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(303, 252, 189, 21);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Fruits & Vegetables\r\n");
		lblNewLabel_4.setFont(new Font("Bell MT", Font.BOLD, 20));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(533, 252, 189, 21);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Home Essentials");
		lblNewLabel_5.setFont(new Font("Bell MT", Font.BOLD, 20));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(761, 252, 189, 21);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Chocolates");
		lblNewLabel_6.setFont(new Font("Bell MT", Font.BOLD, 20));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(63, 488, 189, 21);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Munch & Bites");
		lblNewLabel_7.setFont(new Font("Bell MT", Font.BOLD, 20));
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setBounds(303, 488, 189, 21);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Stationery Supplies");
		lblNewLabel_8.setFont(new Font("Bell MT", Font.BOLD, 20));
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setBounds(533, 488, 189, 21);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("\r\nPersonal Care");
		lblNewLabel_9.setForeground(new Color(0, 0, 0));
		lblNewLabel_9.setFont(new Font("Bell MT", Font.BOLD, 20));
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9.setBounds(761, 488, 189, 21);
		contentPane.add(lblNewLabel_9);
		
		JButton btnNewButton_11 = new JButton("\r\n");
		btnNewButton_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					MyCart sf1 = new  MyCart();
				sf1.setVisible(true);
				SwingUtilities.windowForComponent(btnNewButton_11).dispose();}
				catch(Exception rt) {
					rt.printStackTrace();				}
				
			}
		});
		btnNewButton_11.setIcon(new ImageIcon("C:\\Users\\balaj\\Downloads\\shopping-cart.png"));
		btnNewButton_11.setBounds(911, 10, 85, 61);
		contentPane.add(btnNewButton_11);
		
		JLabel lblNewLabel_12 = new JLabel("MY CART");
		lblNewLabel_12.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 10));
		lblNewLabel_12.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_12.setBounds(911, 73, 85, 21);
		contentPane.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("");
		lblNewLabel_13.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_13.setIcon(new ImageIcon("C:\\Users\\balaj\\Downloads\\truck (1).png"));
		lblNewLabel_13.setBounds(240, 48, 64, 59);
		contentPane.add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel("New label");
		lblNewLabel_14.setIcon(new ImageIcon("C:\\Users\\balaj\\Downloads\\soap.png"));
		lblNewLabel_14.setBounds(10, 280, 64, 61);
		contentPane.add(lblNewLabel_14);
		
		JLabel lblNewLabel_15 = new JLabel("\r\n");
		lblNewLabel_15.setIcon(new ImageIcon("C:\\Users\\balaj\\Downloads\\backpack.png"));
		lblNewLabel_15.setBounds(-6, 113, 91, 73);
		contentPane.add(lblNewLabel_15);
		
		JLabel lblNewLabel_16 = new JLabel("\r\n\r\n\r\n");
		lblNewLabel_16.setIcon(new ImageIcon("C:\\Users\\balaj\\Downloads\\watermelon.png"));
		lblNewLabel_16.setBounds(551, 21, 91, 73);
		contentPane.add(lblNewLabel_16);
		
		JLabel lblNewLabel_17 = new JLabel("");
		lblNewLabel_17.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_17.setIcon(new ImageIcon("C:\\Users\\balaj\\Downloads\\shape.png"));
		lblNewLabel_17.setBounds(715, 283, 47, 83);
		contentPane.add(lblNewLabel_17);
		
		JLabel lblNewLabel_18 = new JLabel("\r\n");
		lblNewLabel_18.setIcon(new ImageIcon("C:\\Users\\balaj\\Downloads\\salt-and-pepper.png"));
		lblNewLabel_18.setBounds(923, 268, 73, 74);
		contentPane.add(lblNewLabel_18);
		
		JLabel lblNewLabel_19 = new JLabel("");
		lblNewLabel_19.setIcon(new ImageIcon("C:\\Users\\balaj\\Downloads\\products.png"));
		lblNewLabel_19.setBounds(475, 252, 85, 83);
		contentPane.add(lblNewLabel_19);
		
		JLabel lblNewLabel_20 = new JLabel("");
		lblNewLabel_20.setIcon(new ImageIcon("C:\\Users\\balaj\\Downloads\\coffee-cup.png"));
		lblNewLabel_20.setBounds(240, 268, 77, 73);
		contentPane.add(lblNewLabel_20);
		
		JLabel lblNewLabel_21 = new JLabel("");
		lblNewLabel_21.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				project_DBMS sf1 = new project_DBMS();
				sf1.setVisible(true);
				SwingUtilities.windowForComponent(btnNewButton_8).dispose();
			}
		});
		lblNewLabel_21.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_21.setIcon(new ImageIcon("C:\\Users\\balaj\\Downloads\\back (4).png"));
		lblNewLabel_21.setBounds(0, 0, 85, 71);
		contentPane.add(lblNewLabel_21);
		
		JLabel lblNewLabel_22 = new JLabel("Log Out");
		lblNewLabel_22.setFont(new Font("Myanmar Text", Font.BOLD, 15));
		lblNewLabel_22.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_22.setBounds(10, 73, 75, 20);
		contentPane.add(lblNewLabel_22);
		
		JLabel lblNewLabel_10 = new JLabel("Select The Category You want to Explore");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_10.setBounds(106, 16, 467, 41);
		contentPane.add(lblNewLabel_10);
		
		JButton btnNewButton_9 = new JButton("  Search");
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					del_cart1 sf1 = new  del_cart1();
				sf1.setVisible(true);
				SwingUtilities.windowForComponent(btnNewButton_9).dispose();}
				catch(Exception rt) {
					rt.printStackTrace();				}
			}
		});
		btnNewButton_9.setBackground(new Color(255, 255, 224));
		btnNewButton_9.setIcon(new ImageIcon("C:\\Users\\balaj\\Downloads\\loupe (1).png"));
		btnNewButton_9.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnNewButton_9.setBounds(652, 31, 216, 41);
		contentPane.add(btnNewButton_9);
	}
}
