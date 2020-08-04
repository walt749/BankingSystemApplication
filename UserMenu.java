import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.awt.event.ActionEvent;

public class UserMenu extends JFrame {

	private JPanel contentPane;
	private String a = "";
	private UserInfo user;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					
					UserMenu frame = new UserMenu(null);
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
	public UserMenu(UserInfo user) {
		
		this.user = user;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 655, 414);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome " +user.getUsername());
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lblNewLabel.setBounds(15, 16, 313, 31);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Checkings Account");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//JOptionPane.showMessageDialog(null, HasFile(user));
					if(user.isHasCheckings()) {
					
					new ShowAccount("Checkings",user).setVisible(true);
					
					dispose();
					
				}else {
					JOptionPane.showMessageDialog(null, "This account doesn't have a Checkings account");
					if (JOptionPane.showConfirmDialog(null, "Would you like to create a Checkings account?", "Checkings account",
					        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					    // yes option
						new InitialDeposit("Checkings", user).setVisible(true);
				}
			}
			}});
		btnNewButton.setBounds(29, 168, 192, 65);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Savings Account");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(user.isHasSaving()) {
					
					new ShowAccount("Savings",user).setVisible(true);
					
					dispose();
					
				}else {
					JOptionPane.showMessageDialog(null, "This account doesn't have a Savings account");
					if (JOptionPane.showConfirmDialog(null, "Would you like to create a Savings account?", "Checkings account",
					        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					    // yes option
						new InitialDeposit("Savings", user).setVisible(true);
						dispose();
					} 
				}
			}
		});
		btnNewButton_1.setBounds(426, 168, 192, 65);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Credit Account");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (user.loan != null) {
					
					new CreditAccount(user).setVisible(true);
					dispose();
				} else {
						JOptionPane.showMessageDialog(null, "This account doesn't have a credit account");
						if (JOptionPane.showConfirmDialog(null, "Would you like to create a credit account?", "Credit account",
						        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
						    // yes option
							new CreateLoan(user).setVisible(true);
							dispose();
						} 
						
				}
			}
		});
		btnNewButton_2.setBounds(230, 265, 192, 65);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Sign out");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Sign_In().setVisible(true);
				dispose();
			}
		});
		btnNewButton_3.setBounds(485, 51, 133, 52);
		contentPane.add(btnNewButton_3);
	}
}
