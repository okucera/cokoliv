package cokoliv.flowdata.manager;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import cokoliv.flowdata.IFlowData;

public class FlowDataManager implements IFlowDataManager {
	private Map<String,IFlowData> flowDataMap;
	private static IFlowDataManager instance;
	
	private FlowDataManager(){
		flowDataMap = new HashMap<String, IFlowData>();
	}
	
	public static synchronized IFlowDataManager getInstance(){
		if(instance==null) {
			instance = new FlowDataManager();
		}
		
		return instance;
	}
	
	private String generateTimestamp(){
		Date d = new Date();		
		return d.getTime()+""; 
	}
	
	public String storeFlowData(IFlowData flowData) {
		String key = generateTimestamp();
		flowDataMap.put(key, flowData);
		return key;
	}

	public IFlowData getFlowDataByKey(String key) {
		return flowDataMap.get(key);
	}

}
