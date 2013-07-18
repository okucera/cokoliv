package cokoliv.flowdata.manager;

import cokoliv.flowdata.IFlowData;

public interface IFlowDataManager {
	public String storeFlowData(IFlowData flowData);
	public IFlowData getFlowDataByKey(String key);
}
