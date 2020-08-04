import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ShowAccount extends JFrame {

	private JPanel contentPane;
	private UserInfo user;
	private JTextField Balance;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShowAccount frame = new ShowAccount(null,null);
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
	public ShowAccount(String type,UserInfo user) 
	{
		this.user = user;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 644, 411);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel(type +" Account Balance");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(32, 39, 264, 26);
		contentPane.add(lblNewLabel);
		
		Balance = new JTextField();
		if(type.equals("Checkings")) {
		Balance.setText("$ " +user.getCheckings());
		}
		else if(type.equals("Savings")){
			Balance.setText("$ " +user.getSavings());
		}
		Balance.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Balance.setEditable(false);
		Balance.setBounds(345, 34, 205, 31);
		contentPane.add(Balance);
		Balance.setColumns(10);
		
		JButton deposit = new JButton("Deposit");
		deposit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(type.equals("Checkings")) {
					user.depositCheckings(textField.getText());
					setUser(user);
					Balance.setText("$ " +user.getCheckings());
					
				}
				else if (type.equals("Savings")) {
					user.depositSavings(textField.getText());
					setUser(user);
					Balance.setText("$ " +user.getSavings());
				}
				
			}
		});
		deposit.setBounds(70, 144, 140, 41);
		contentPane.add(deposit);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField.setBounds(345, 144, 165, 33);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton widrawal = new JButton("Withdraw");
		widrawal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(type.equals("Checkings")) {
					user.withdrawCheckings(textField_1.getText());
					setUser(user);
					Balance.setText("$ " +user.getCheckings());
				}
				else if (type.equals("Savings")) {
					user.WithdrawSavings(textField_1.getText());
					setUser(user);
					Balance.setText("$ " +user.getSavings());
				}
			}
		});
		widrawal.setBounds(70, 259, 140, 41);
		contentPane.add(widrawal);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_1.setBounds(345, 254, 165, 31);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new UserMenu(user).setVisible(true);
				dispose();
			}
		});
		btnGoBack.setBounds(492, 310, 115, 29);
		contentPane.add(btnGoBack);
	}
	
	public void setUser(UserInfo u) {
		
		LaunchApplication.UsersData.replace(u.getUsername(), u);
		
	}
}
