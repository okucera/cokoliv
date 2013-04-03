package cokoliv.enumerate;

import cokoliv.flowdata.IFlowData;
import cokoliv.flows.*;

public enum EFlows {
	FL001("FL001", new LoadCokolivNewsFlow()),
	FL002("FL002", new LoginUserFlow()),
	FL003("FL003", new ChangeUserDetailFlow()),
	FL004("FL004", new DeleteSelectedNewsFlow()),
	FL005("FL005", new UploadFileFlow()),
	FL006("FL006", new ImportNewsFlow()),
	FL007("FL007", new LoadBandMenuFlow()),
	FL008("FL008", new LoadBandUserFlow()),
	FL009("FL009", new LoadConcertsFlow()),
	FL010("FL010", new LoadGuestbooksFlow()),
	FL011("FL011", new InsertGuestbookItemFlow()),
	FL012("FL012", new ImportConcertFlow());
	
	private IFlow flow;
	
	EFlows(String flowId, IFlow fl){
		this.flow = fl;
	}
	
	public void executeFlow(IFlowData flowData){
		this.flow.executeFlow(flowData);
	}
}
