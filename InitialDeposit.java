import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InitialDeposit extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private String AccountType;
	private JButton btnNewButton;
	private JButton btnCancel;
	private String Username;
	private UserInfo user;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InitialDeposit frame = new InitialDeposit("Checkings",null);
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
	public InitialDeposit(String AccountType,UserInfo name) {
		this.AccountType = AccountType;
		this.user = name;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 662, 398);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField.setBounds(318, 126, 199, 41);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Please, Make an initial deposit of at least $25:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(44, 91, 389, 31);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New " +AccountType +" Account");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(44, 16, 221, 31);
		contentPane.add(lblNewLabel_1);
		
		btnNewButton = new JButton("Deposit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(textField.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Please enter a number");
				}
				if(Double.valueOf(textField.getText())<25.0) {
					JOptionPane.showMessageDialog(null, "Please deposit $25 or more.");
				}
				
				if(AccountType.equals("Checkings")) {
				
					
				Username = user.getUsername();
				user.setCheckings(Double.valueOf(textField.getText()));
				LaunchApplication.UsersData.replace(Username, user);
				
				System.out.print(user +"checkings: " +user.getCheckings());
				user.setHasCheckings(true);
				new NewAccountMenu(user).setVisible(true);
				
				dispose();
				}
				
				if(AccountType.equals("Savings")) {
					//new UserInfo(name).depositCheckings(Double.valueOf(textField.getText()));
					
				Username = user.getUsername();
				user.setSavings(Double.valueOf(textField.getText()));
				LaunchApplication.UsersData.replace(Username, user);
				user.setHasCheckings(true);
				new NewAccountMenu(user).setVisible(true);
				
				dispose();
				
				}
					
				
			}
		});
		btnNewButton.setBounds(375, 195, 142, 41);
		contentPane.add(btnNewButton);
		
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new NewAccountMenu(name).setVisible(true);
				dispose();
				
			}
		});
		btnCancel.setBounds(15, 259, 115, 29);
		contentPane.add(btnCancel);
	}
}
