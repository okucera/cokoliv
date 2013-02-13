package cokoliv.flowdata;

import cokoliv.enumerate.Forms;
import cokoliv.enumerate.MessageCodes;
import cokoliv.enumerate.UserRightsEnum;

public class FlowData implements IFlowData {
	private UserRightsEnum userRight;
	private MessageCodes msgCode;
	private MessageCodes errMsgCode;
	private Forms nextFormId;

	public UserRightsEnum getUserRights() {
		return this.userRight;
	}

	public void setUserRights(UserRightsEnum userRight) {
		this.userRight = userRight;		
	}

	public MessageCodes getMessage() {
		return this.msgCode;
	}

	public void setMessage(MessageCodes msgCode) {		
		this.msgCode = msgCode;
	}

	public MessageCodes getErrorMessage() {
		return this.errMsgCode;
	}

	public void setErrorMessage(MessageCodes errMsgCode) {
		this.errMsgCode = errMsgCode;
	}

	public Forms getNextFormId() {
		return nextFormId;
	}

	public void setNextFormId(Forms formId) {
		this.nextFormId = formId;
	}

	

}
