package cokoliv.flows;

import cokoliv.enumerate.EFlows;
import cokoliv.flowdata.IFlowData;
import cokoliv.sql.SqlManager;
import cokoliv.sql.SqlPropertyRepository;
import cokoliv.support.CokolivContext;

public class BasicFlow {
	protected CokolivContext cokoliv = CokolivContext.getContext();
	protected SqlPropertyRepository sqlRepository = SqlPropertyRepository.getInstance();
	protected SqlManager sql = new SqlManager();
	
	protected void executeNextFlow(EFlows flow, IFlowData flowData) {
		flow.executeFlow(flowData);
	}
}
