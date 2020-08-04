import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class NewUserInfo extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField LastN;
	private JTextField Email;
	private JTextField UserName;
	private JPasswordField passwordField;
	private UserInfo user;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewUserInfo frame = new NewUserInfo();
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
	public NewUserInfo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 559, 458);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("First Name");
		lblNewLabel.setBounds(63, 63, 87, 20);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(188, 60, 146, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Last Name");
		lblNewLabel_1.setBounds(63, 117, 87, 20);
		contentPane.add(lblNewLabel_1);
		
		LastN = new JTextField();
		LastN.setBounds(188, 114, 146, 26);
		contentPane.add(LastN);
		LastN.setColumns(10);
		
		Email = new JTextField();
		Email.setBounds(188, 156, 146, 26);
		contentPane.add(Email);
		Email.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(63, 153, 69, 20);
		contentPane.add(lblEmail);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(63, 207, 87, 20);
		contentPane.add(lblUsername);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setBounds(63, 254, 69, 20);
		contentPane.add(lblNewLabel_2);
		
		UserName = new JTextField();
		UserName.setBounds(188, 204, 146, 26);
		contentPane.add(UserName);
		UserName.setColumns(10);
		
		JButton btnNewButton = new JButton("Create new account");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setUserInfo(textField.getText(), LastN.getText(),
						Email.getText(), UserName.getText(), new String(passwordField.getPassword()));
				
				LaunchApplication.StoreUsers(UserName.getText(), user);
				LaunchApplication.userPassword.add(new String(passwordField.getPassword()));
				//System.out.print(LaunchApplication.UsersData);
				
				
				new NewAccountMenu(user).setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(63, 338, 171, 48);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Go Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Bank().setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(388, 348, 115, 29);
		contentPane.add(btnNewButton_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(188, 251, 146, 26);
		contentPane.add(passwordField);
	}
	
	private void setUserInfo(String firstname,String lastname, String email, String userName
			,String password) {
		
		user = new UserInfo(firstname, lastname, userName, password, email);
		
	}
	
	public UserInfo getUserInfo() {
		
		return user;
		
	}
}
