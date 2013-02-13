package cokoliv.enumerate;

import cokoliv.flowdata.IFlowData;
import cokoliv.flows.*;

public enum EFlows {
	FL001("FL001", new LoadCokolivNewsFlow()),
	FL002("FL002", new LoginUserFlow()),
	FL003("FL003", new ChangeUserDetailFlow()),
	FL004("FL004", new DeleteSelectedNewsFlow());
	
	private IFlow flow;
	
	EFlows(String flowId, IFlow fl){
		this.flow = fl;
	}
	
	public void executeFlow(IFlowData flowData){
		this.flow.executeFlow(flowData);
	}
}
