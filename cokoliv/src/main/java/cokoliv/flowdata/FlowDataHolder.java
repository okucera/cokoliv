package cokoliv.flowdata;

public class FlowDataHolder {
	
	private static FlowDataHolder instance;
	private IFlowData flowData;
	
	private FlowDataHolder(){
		
	}
	
	public static synchronized FlowDataHolder getInstance() {
		if(instance==null){
			instance = new FlowDataHolder();
		}
		
		return instance;
	}

	public IFlowData getFlowData() {
		return flowData;
	}

	public void setFlowData(IFlowData flowData) {
		this.flowData = flowData;
	}
}
