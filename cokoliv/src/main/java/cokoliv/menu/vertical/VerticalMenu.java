package cokoliv.menu.vertical;

import java.io.IOException;

import cokoliv.components.CokolivTag;

public abstract class VerticalMenu extends CokolivTag implements IVerticalMenu {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4648610564044454443L;
	

//	public void executeFlow(EFlows flow, IFlowData flowData) {
//		flow.executeFlow(flowData);
//	}
	
	public abstract void renderMenu() throws IOException;
}
