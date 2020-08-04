

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NewAccountMenu extends JFrame {

	private JPanel contentPane;
	private String name;
	private UserInfo user;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewAccountMenu frame = new NewAccountMenu(null);
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
	public NewAccountMenu(UserInfo name) {
		this.user = name;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 671, 415);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Checking Account");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new InitialDeposit("Checkings",name).setVisible(true);
				
				
				dispose();
			}
		});
		btnNewButton.setBounds(74, 185, 166, 38);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Credit Account");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CreateLoan(user).setVisible(true);
				dispose();
				
			}
		});
		btnNewButton_1.setBounds(229, 267, 166, 38);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Savings Account");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new InitialDeposit("Savings",name).setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setBounds(428, 191, 166, 38);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("Which account would you like to create?");
		lblNewLabel.setBounds(169, 88, 309, 29);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Hello " +name.getUsername());
		lblNewLabel_1.setBounds(69, 48, 143, 29);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton_3 = new JButton("Go Back");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Bank().setVisible(true);
				
				dispose();
			}
		});
		btnNewButton_3.setBounds(519, 36, 115, 29);
		contentPane.add(btnNewButton_3);
	}
}
