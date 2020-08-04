import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DebtAccount extends JFrame {

	private JPanel contentPane;
	private JTextField DLoan;
	private JTextField qLoan;
	private JTextField debt;
	private UserInfo user;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DebtAccount frame = new DebtAccount(null);
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
	public DebtAccount(UserInfo user) {
		this.user = user;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 542, 435);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Get Loan");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "you now owe $"+user.loan.getDebt());
				new NewAccountMenu(user).setVisible(true);
				System.out.println("debt" +user.loan.getDebt());
				dispose();
			}
		});
		btnNewButton.setBounds(118, 268, 115, 29);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Desired Loan");
		lblNewLabel.setBounds(15, 55, 132, 29);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Loan you qualify");
		lblNewLabel_1.setBounds(15, 112, 132, 29);
		contentPane.add(lblNewLabel_1);
		
		DLoan = new JTextField();
		DLoan.setEditable(false);
		DLoan.setBounds(147, 56, 146, 26);
		contentPane.add(DLoan);
		DLoan.setColumns(10);
		DLoan.setText("$"+Double.toString(user.loan.getDesiredloan()));
		
		
		qLoan = new JTextField();
		qLoan.setEditable(false);
		qLoan.setBounds(157, 113, 146, 26);
		contentPane.add(qLoan);
		qLoan.setColumns(10);
		qLoan.setText("$" +Double.toString(user.loan.giveLoan()));
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				user.loan.cancel();
				new NewAccountMenu(user).setVisible(true);
				
				dispose();
			}
		});
		btnNewButton_1.setBounds(358, 268, 115, 29);
		contentPane.add(btnNewButton_1);
		user.loan.setDebt();
		debt = new JTextField();
		debt.setEditable(false);
		debt.setBounds(157, 171, 146, 26);
		contentPane.add(debt);
		debt.setColumns(10);
		debt.setText("$" +Double.toString(user.loan.getDebt()));
		
		
		JLabel lblTotalDebt = new JLabel("total debt");
		lblTotalDebt.setBounds(15, 171, 69, 20);
		contentPane.add(lblTotalDebt);
		
		JLabel lblNewLabel_2 = new JLabel("Interest rate 5%");
		lblNewLabel_2.setBounds(341, 59, 132, 25);
		contentPane.add(lblNewLabel_2);
	}

}
