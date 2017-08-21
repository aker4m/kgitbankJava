package member;

import member.command.*;

public class MemberFactory {
	private MemberFactory(){}
	
	private static MemberFactory instance = new MemberFactory();
	
	public static MemberFactory getInstance(){
		return instance;
	}
	
	public CommandIf createCommand(String cmd){
		CommandIf cmdIf = null;
		
		if(cmd.equals("/memberSsn.mem")){
			cmdIf = new MemberSsnCommand();
		}else if(cmd.equals("/checkMember.mem")){
			cmdIf = new CheckMemberCommand();
		}else if(cmd.equals("/member_input.mem")){
			cmdIf = new MemberInputCommand();
		}else if(cmd.equals("/memberAll.mem")){
			cmdIf = new MemberAllCommand();
		}else if(cmd.equals("/member_delete.mem")){
			cmdIf = new MemberDeleteCommand();
		}
		
		
		return cmdIf;
	}
}
