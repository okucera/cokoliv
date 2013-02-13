package cokoliv.flowdata;

import cokoliv.enumerate.Forms;
import cokoliv.enumerate.MessageCodes;
import cokoliv.enumerate.UserRightsEnum;

public class FlowData implements IFlowData {
	private UserRightsEnum userRight;
	private MessageCodes msgCode;
	private MessageCodes errMsgCode;
	private Forms nextFormId;

	@Override
	public UserRightsEnum getUserRights() {
		return this.userRight;
	}

	@Override
	public void setUserRights(UserRightsEnum userRight) {
		this.userRight = userRight;		
	}

	@Override
	public MessageCodes getMessage() {
		return this.msgCode;
	}

	@Override
	public void setMessage(MessageCodes msgCode) {		
		this.msgCode = msgCode;
	}

	@Override
	public MessageCodes getErrorMessage() {
		return this.errMsgCode;
	}

	@Override
	public void setErrorMessage(MessageCodes errMsgCode) {
		this.errMsgCode = errMsgCode;
	}

	@Override
	public Forms getNextFormId() {
		return nextFormId;
	}

	@Override
	public void setNextFormId(Forms formId) {
		this.nextFormId = formId;
	}

	

}
