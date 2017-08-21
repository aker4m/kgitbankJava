package mall;

import board.command.*;

public class MallFactory {
	private MallFactory(){}
	
	private static MallFactory instance = new MallFactory();
	
	public static MallFactory getInstance(){
		return instance;
	}
	
	public CommandIf createCommand(String cmd){
		CommandIf cmdIf = null;
		
		if(cmd.equals("/mall.mall")){
			cmdIf = new MallCommand();
		}
		
		return cmdIf;
	}
}
