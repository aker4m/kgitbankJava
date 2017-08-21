package board;

import board.command.*;

public class BoardFactory {
	private BoardFactory(){}
	
	private static BoardFactory instance = new BoardFactory();
	
	public static BoardFactory getInstance(){
		return instance;
	}
	
	public CommandIf createCommand(String cmd){
		CommandIf cmdIf = null;
		
		if(cmd.equals("/board.bd")){
			cmdIf = new ListCommand();
		}else if(cmd.equals("/writeForm.bd")){
			cmdIf = new WriteFormCommand();
		}else if(cmd.equals("/writePro.bd")){
			cmdIf = new WriteProCommand();
		}else if(cmd.equals("/content.bd")){
			cmdIf = new ContentCommand();
		}else if(cmd.equals("/updateForm.bd")){
			cmdIf = new UpdateFormCommand();
		}else if(cmd.equals("/updatePro.bd")){
			cmdIf = new UpdateProCommand();
		}else if(cmd.equals("/deleteForm.bd")){
			cmdIf = new DeleteFormCommand();
		}else if(cmd.equals("/deletePro.bd")){
			cmdIf = new DeleteProCommand();
		}
		
		return cmdIf;
	}
}
