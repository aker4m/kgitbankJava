package admin;

import admin.command.*;

public class AdminFactory {
	private AdminFactory(){}
	
	private static AdminFactory instance = new AdminFactory();
	
	public static AdminFactory getInstance(){
		return instance;
	}
	
	public CommandIf createCommand(String cmd){
		CommandIf cmdIf = null;
		
		if(cmd.equals("/main.admin")){
			cmdIf = new MainCommand();
		}else if(cmd.equals("/cate_input.admin")){
			cmdIf = new Cate_inputCommand();
		}else if(cmd.equals("/cate_input_ok.admin")){
			cmdIf = new Cate_input_okCommand();
		}
		
		return cmdIf;
	}
}
