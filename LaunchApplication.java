
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JOptionPane;





public class LaunchApplication {
	
	NewUserInfo newUser;
	UserInfo user;
	public static HashMap<String, UserInfo> UsersData = new HashMap<>();
	public static ArrayList<String> userPassword = new ArrayList<>();
	
	
	public LaunchApplication() {
		// TODO Auto-generated constructor stub
	    //new	Bank().setVisible(true);
	}
	
	public static void StoreUsers(String username,UserInfo user ) {
		
		UsersData.put(username, user);
		
	}
	
	/**public UserInfo CreateUser() {
		
	 	newUser = new NewUserInfo();
	 	newUser.setVisible(true);
	 	return newUser.getUserInfo();
	 	
	}*/
	
	public void name() {
		//user = CreateUser();
		System.out.print(UsersData);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new Bank().setVisible(true);
		
	}

}
