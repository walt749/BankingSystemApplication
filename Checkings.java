import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JButton;

public class Checkings extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Checkings frame = new Checkings("");
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
	public Checkings(String Username) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 603, 385);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 23));
		textField.setEditable(false);
		textField.setBounds(244, 47, 165, 40);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.setText("");
		
		textField_1 = new JTextField();
		textField_1.setBounds(266, 140, 165, 40);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(266, 240, 165, 40);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblBalance = new JLabel("Balance");
		lblBalance.setBounds(152, 57, 99, 27);
		contentPane.add(lblBalance);
		
		JLabel lblNewLabel = new JLabel("Your Account");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel.setBounds(15, 16, 152, 40);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Deposit");
		lblNewLabel_1.setBounds(182, 150, 69, 20);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Deposit");
		btnNewButton.setBounds(451, 146, 115, 29);
		contentPane.add(btnNewButton);
		
		JButton btnWidraw = new JButton("Withdraw");
		btnWidraw.setBounds(451, 246, 115, 29);
		contentPane.add(btnWidraw);
		
		JLabel lblWithdraw = new JLabel("Withdraw");
		lblWithdraw.setBounds(182, 250, 69, 20);
		contentPane.add(lblWithdraw);
	}
	
	public double read(String Usern) {
		double balance = 0;
		
		return balance;
	}
}
