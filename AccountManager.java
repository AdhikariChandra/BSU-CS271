import java.util.Hashtable;


public class AccountManager {
	
    private Hashtable<String, UserProfile> userAccount;
    
    public AccountManager() {
        userAccount = new Hashtable<String, UserProfile>();
    }
    
    /**
     * Returns 'true' if username is found in AccountManager
     * @param username - String
     * @return found - boolean
     */
    public boolean containsUsername(String userName){
    	boolean found = false;
    	if(userName != null){
    		found = userName.equals(userAccount.get(userName));
    	}
    	return found;
    }
    
    public boolean verifyEmail(String email){
    	return false;
    }
    
    public boolean verifyPassword(String userName, String password) {
       if(userName == null || password ==null){
    	   return false; 
       }  
       String storedPassword = userAccount.get(userName).getPassword();
       return storedPassword != null && storedPassword.equals(password);
    }
    
    public boolean verifyCreateProfile(UserProfile user){
    	boolean canCreate = true;
    	if(containsUsername(user.getName())){
    		canCreate = false;
    	}
    	if(user.getName().length() > 12){
    		canCreate = false;
    	}
    	return canCreate;
    }
    
}