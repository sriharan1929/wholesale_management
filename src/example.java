import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;

public class example extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textname;
	private JTextField textno;
	private JTextField textotp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					example frame = new example();
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
	public example() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1030, 601);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(54, 69, 113, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(54, 163, 124, 25);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(54, 245, 113, 35);
		contentPane.add(lblNewLabel_2);
		
		textname = new JTextField();
		textname.setBounds(161, 72, 143, 19);
		contentPane.add(textname);
		textname.setColumns(10);
		
		textno = new JTextField();
		textno.setBounds(161, 166, 143, 19);
		contentPane.add(textno);
		textno.setColumns(10);
		
		textotp = new JTextField();
		textotp.setBounds(161, 253, 162, 19);
		contentPane.add(textotp);
		textotp.setColumns(10);
		
		JButton btnNewButton = new JButton("login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String myURI = "https://api.bulksms.com/v1/messages";

		        // change these values to match your own account
		        String textname = ";
		        String myPassword = "password";

		        // the details of the message we want to send
		        String myData = "{to: \"1111111\", encoding: \"UNICODE\", body: \"Dobrá práce! Jak se máš?\"}";

		        try {
		            // build the request based on the supplied settings
		            URL url = new URL(myURI);
		            HttpURLConnection request = (HttpURLConnection) url.openConnection();
		            request.setDoOutput(true);

		            // supply the credentials
		            String authStr = myUsername + ":" + myPassword;
		            String authEncoded = Base64.getEncoder().encodeToString(authStr.getBytes());
		            request.setRequestProperty("Authorization", "Basic " + authEncoded);

		            // we want to use HTTP POST
		            request.setRequestMethod("POST");
		            request.setRequestProperty("Content-Type", "application/json");

		            // write the data to the request
		            try (OutputStreamWriter out = new OutputStreamWriter(request.getOutputStream())) {
		                out.write(myData);
		            }

		            // make the call to the API
		            try (BufferedReader in = new BufferedReader(new InputStreamReader(request.getInputStream()))) {
		                String replyText;
		                while ((replyText = in.readLine()) != null) {
		                    System.out.println(replyText);
		                }
		            }
		        } catch (IOException ex) {
		            System.out.println("An error occurred:" + ex.getMessage());
		            try (BufferedReader in = new BufferedReader(new InputStreamReader(request.getErrorStream()))) {
		                // print the detail that comes with the error
		                String replyText;
		                while ((replyText = in.readLine()) != null) {
		                    System.out.println(replyText);
		                }
		            } catch (IOException e) {
		                e.printStackTrace();
		            }
		        }
		    }
		}
				
			}
		});
		btnNewButton.setBounds(374, 165, 85, 21);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("verify\r\n");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(336, 312, 85, 21);
		contentPane.add(btnNewButton_1);
	}
}
