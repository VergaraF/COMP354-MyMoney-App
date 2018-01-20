import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class LogIn {
	
	private static ArrayList<String> login_info= new ArrayList<String>();
	private Scanner scan;
	FileWriter writer;
	
	/**
	 * Adds user login info to arrayList.
	 * @param string
	 */
	public void recordNewUser(String username, String password){
		
		String savedInfo = username+"::"+password;
		
		login_info.add(savedInfo);
		
	}
	
	/**
	 * Method writes user login info to file.
	 */
	public void saveUserInfo(){
		
		try {
			writer = new FileWriter("login_info");
			
			for(String s:login_info){
				
				writer.write(s);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Method reads user login info from file and save in array list for look up.
	 */
	public void readUserInfor(){
		
		try {
			scan = new Scanner(new File("login_info"));
			
			while(scan.hasNextLine()){
				
				login_info.add(scan.next());
				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param userLogin user login info.
	 * @return true if user info exist in file else false.
	 */
	public boolean validateUser(String username, String password){
		
		String savedInfo = username+"::"+password;
		
		return login_info.contains(savedInfo);
	}
	

}
