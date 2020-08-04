import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CreateLoan extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private UserInfo user;
	private Loan loan;
	private double[] flow;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateLoan frame = new CreateLoan(null);
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
	public CreateLoan(UserInfo user) {
		this.user = user;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 561, 471);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMonth = new JLabel("month 1:");
		lblMonth.setBounds(15, 110, 73, 27);
		contentPane.add(lblMonth);
		
		JLabel lblNewLabel = new JLabel("Month 2");
		lblNewLabel.setBounds(15, 161, 73, 27);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Month 3");
		lblNewLabel_1.setBounds(15, 224, 73, 27);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Month 4");
		lblNewLabel_2.setBounds(15, 290, 73, 27);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(103, 110, 146, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(103, 161, 146, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(103, 224, 146, 26);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(103, 290, 146, 26);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Interest Rate 5%");
		lblNewLabel_3.setBounds(350, 110, 146, 27);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("Set Up");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				flow = new double[]{Double.valueOf(textField.getText())
						,Double.valueOf(textField_1.getText()),Double.valueOf(textField_2.getText()),
						Double.valueOf(textField_3.getText())};
				
				//user.loan = new Loan(flow);
				user.setLoan(flow);
				user.loan.setDesiredLoan(Double.valueOf(textField_4.getText()));
				//user.loan.giveLoan();
				
				new DebtAccount(user).setVisible(true);
				//new NewAccountMenu(user).setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(357, 196, 139, 40);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_4 = new JLabel("Please enter you monthly income from the last 4 months");
		lblNewLabel_4.setBounds(75, 30, 421, 27);
		contentPane.add(lblNewLabel_4);
		
		textField_4 = new JTextField();
		textField_4.setBounds(135, 356, 146, 26);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Desired Loan");
		lblNewLabel_5.setBounds(15, 359, 119, 20);
		contentPane.add(lblNewLabel_5);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new NewAccountMenu(user).setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(409, 355, 115, 29);
		contentPane.add(btnNewButton_1);
	}

}
