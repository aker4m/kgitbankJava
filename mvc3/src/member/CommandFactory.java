package member;

public class CommandFactory {
	private CommandFactory(){}
	
	private static CommandFactory instance = new CommandFactory();
	
	public static CommandFactory getInstance(){
		return instance;
	}
	
	public CommandIf createCommand(String cmd){
		CommandIf cmdIf = null;
		if(cmd == null){
			cmdIf = new OtherCommand();
		}else if(cmd.equals("insert")){
			cmdIf = new InsertCommand();
		}else if(cmd.equals("delete")){
			cmdIf = new DeleteCommand();
		}else if(cmd.equals("search")){
			cmdIf = new FindCommand();
		}else if(cmd.equals("list")){
			cmdIf = new ListCommand();
		}else if(cmd.equals("check")){
			cmdIf = new CheckCommand();
		}
		return cmdIf;
	}
}
