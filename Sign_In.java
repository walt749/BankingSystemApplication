import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import jdk.internal.util.xml.impl.Input;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.awt.event.ActionEvent;

public class Sign_In extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private UserInfo user;
	private static String csvFile = "C:\\Users\\Santiago\\Documents\\java\\Java_WorkSpaces"
			+ "\\Bank Application\\src\\User_data\\Users.csv";
	private static String PropertiesFile = "C:\\Users\\Santiago\\Documents\\java\\Java_WorkSpaces"
			+ "\\Bank Application\\src\\User_data\\";
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sign_In frame = new Sign_In();
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
	public Sign_In() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 652, 440);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(247, 104, 202, 43);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Username:");
		lblNewLabel.setBounds(138, 115, 94, 20);
		contentPane.add(lblNewLabel);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(247, 213, 202, 43);
		contentPane.add(passwordField);
		
		JLabel lblNewLabel_1 = new JLabel("Password:");
		lblNewLabel_1.setBounds(134, 213, 98, 31);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Sign In");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//System.out.println(Sign(textField.getText(), passwordField.getPassword()));
							
				try {
					if(LaunchApplication.UsersData.containsKey(textField.getText())&& 
							LaunchApplication.userPassword.contains(new String(passwordField.getPassword())) )
					{
						//new SignIn(textField.getText()).Menu();
						new UserMenu(LaunchApplication.UsersData.get(textField.getText())).setVisible(true);;
						dispose();
						
					}
					else if(textField.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Please enter Username and Password");
					}
					else {
						JOptionPane.showMessageDialog(null, "Wrong Username or Password");
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton.setBounds(405, 291, 115, 29);
		contentPane.add(btnNewButton);
		
		JButton btnMainMenu = new JButton("Go Back");
		btnMainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Bank().setVisible(true);
				dispose();
			}
		});
		btnMainMenu.setBounds(15, 308, 115, 29);
		contentPane.add(btnMainMenu);
	}
	
		public static boolean Sign(String user, char[] password) throws IOException {
			FileInputStream fis = null;
		       Properties prop = null; 
		       String r = "";
		       boolean s = false;
		      
		       try {
		           fis = new FileInputStream(PropertiesFile+user+".properties");
		           prop = new Properties();
		           prop.load(fis);
		         //  System.out.println((prop.containsKey(user)));
		          if(prop.getProperty("password").equals(new String(password))) {
		        	  s = true;
		          }
		           
		        } catch(FileNotFoundException fnfe) {
		           fnfe.printStackTrace();
		        } catch(IOException ioe) {
		           ioe.printStackTrace();
		        } 
       
        return s;
        		
		
	
	
			
	}
	
public static boolean SignIn(String user,char[] password) throws IOException {
		
		boolean sign = false;
		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
			
			String line = "";
			String csvSplitBy = ",";
			
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] Username = line.split(csvSplitBy);

                //System.out.println("Country [code= " + country[4] + " , name=" + country[5] + "]");
                	//System.out.println(Username[0].equals('"'+"user" +'"'));
                	//System.out.println(Username[0]);
                if(Username[0].equals(user)&&Username[1].equals(new String(password))) {
                	
                	sign = true;
                	
                }
                
                		
            }
		}
		return sign;
	}
}
