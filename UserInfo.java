//package Bank;

import java.awt.HeadlessException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.String;
import java.util.Properties;

import javax.swing.JOptionPane;




//import test.newA;

public class UserInfo {
	private String firstname;
	private String lastname;
	private String username;
	private String password;
	private String email;
	private double Checkings = 0.0;
	private double Savings = 0.0;
	private boolean hasCheckings = false;
	private boolean hasSaving = false;
	public Loan loan = null;
	
	
	
	
	public UserInfo(String firstname, String lastname, String username, String password, String email) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
		this.email = email;
		
	}
	
	
	
	
	public UserInfo(String username) {
		this.username = username;
	}
	
	
	public String getFirstName() {
		return firstname;
	}
	
	public String getLastName() {
		return lastname;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setFirstName(String newFirstName) {
		this.firstname = newFirstName;
	}
	
	public void setLastName(String newLastName) {
		this.lastname = newLastName;
	}
	
	public void setUsername(String newUsername) {
		this.username = newUsername;
	}
	
	public void setPassword(String newPassword) {
		this.password = newPassword;
	}
	
	public void setEmail(String newEmail) {
		this.email = newEmail;
	}
	public void setLoan(double[] d) {
		loan = new Loan(d);
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		
		return "firstname :" +firstname +" ,lastname: " +lastname +" ,Email: " +email 
				+" ,Username: " +username +" ,Password: " +password  +" hascheckings" +hasCheckings;
	}
	
	
	public double getCheckings() {
		return Checkings;
	}

	public void setCheckings(double checkings) {
		Checkings = checkings;
		hasCheckings = true;
	}
	

	public double getSavings() {
		return Savings;
	}

	public void setSavings(double savings) {
		Savings = savings;
		hasSaving = true;
	}

	public boolean isHasCheckings() {
		return hasCheckings;
	}

	public void setHasCheckings(boolean hasCheckings) {
		this.hasCheckings = hasCheckings;
	}

	public boolean isHasSaving() {
		return hasSaving;
	}

	public void setHasSaving(boolean hasSaving) {
		this.hasSaving = hasSaving;
	}
	
	public void depositCheckings(String dc) {
	
		Checkings = Checkings + Double.valueOf(dc);
		
	}
	public void depositSavings(String ds) {
		
		Savings = Savings + Double.valueOf(ds);
		
	}
	
	public void withdrawCheckings(String wc) {
		Checkings = Checkings - Double.valueOf(wc);
	}
	
	public void WithdrawSavings(String ws) {
		
		Savings = Savings - Double.valueOf(ws);
		
	}
	public static void main(String[] args) throws HeadlessException, IOException {
		
		
		
		
	}

	
	
}
