import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CreditAccount extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private UserInfo user;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreditAccount frame = new CreditAccount(null);
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
	public CreditAccount(UserInfo user) {
		this.user = user;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 594, 443);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(311, 74, 146, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.setText("$" +Double.toString(user.loan.getDebt()));
		
		JButton back = new JButton("Back");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new UserMenu(user).setVisible(true);
				dispose();
			}
		});
		back.setBounds(442, 329, 115, 29);
		contentPane.add(back);
		
		JButton btnNewButton = new JButton("Pay Debt");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				user.loan.pay(Double.valueOf(textField_1.getText()));
				textField.setText("$" +Double.toString(user.loan.getDebt()));

			}
		});
		btnNewButton.setBounds(181, 160, 115, 29);
		contentPane.add(btnNewButton);
		
		textField_1 = new JTextField();
		textField_1.setBounds(311, 161, 146, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("take more loans");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CreateLoan(user).setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(15, 329, 171, 29);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Total Debt");
		lblNewLabel.setBounds(181, 77, 88, 23);
		contentPane.add(lblNewLabel);
	}
}
