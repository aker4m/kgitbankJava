package login;

import login.command.*;

public class LoginFactory {
	private LoginFactory(){}
	
	private static LoginFactory instance = new LoginFactory();
	
	public static LoginFactory getInstance(){
		return instance;
	}
	
	public CommandIf createCommand(String cmd){
		CommandIf cmdIf = null;
		
		if(cmd.equals("/login.login")){
			cmdIf = new LoginCommand();
		}else if(cmd.equals("/login_ok.login")){
			cmdIf = new Login_okCommand();
		}else if(cmd.equals("/search.login")){
			cmdIf = new SearchCommand();
		}else if(cmd.equals("/check.login")){
			cmdIf = new CheckCommand();
		}else if(cmd.equals("/logout.login")){
			cmdIf = new LogoutCommand();
		}
		return cmdIf;
	}
}
