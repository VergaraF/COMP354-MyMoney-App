
public class MyMoneyController {
	
	private static MainPanel mp;
	private static Model aModel ;
	
	
	
	public static String getFinanceStatement(){
		
		 mp = new MainPanel();
		aModel = new Model(mp.sendUserName(),mp.sendUserPassword());
		return aModel.readUserData();
		
		
	}
	

}
