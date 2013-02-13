package cokoliv.flowdata;

import cokoliv.enumerate.Forms;
import cokoliv.enumerate.MessageCodes;
import cokoliv.enumerate.UserRightsEnum;

public interface IFlowData {
	public void setUserRights(UserRightsEnum userRight);
	public UserRightsEnum getUserRights();
	public void setMessage(MessageCodes msgCode);
	public MessageCodes getMessage();
	public void setErrorMessage(MessageCodes errMsgCode);
	public MessageCodes getErrorMessage();
	public void setNextFormId(Forms formId);
	public Forms getNextFormId();
}
