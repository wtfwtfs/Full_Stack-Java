package exc;

public class BankException extends Exception {
	private ERR_CODE errCode;
	
	public BankException(String msg, ERR_CODE errCode) {
		super(msg);
		this.errCode=errCode;
	}
	
	@Override
	public String toString() {
		String message= "["+getMessage()+"]";
		switch(errCode) {
		case ACCID_ERR: message+="���¹�ȣ�� Ʋ���ϴ�"; break;
		case DOUBLEID_ERR: message+="���¹�ȣ�� �ߺ��˴ϴ�"; break;
		case DEPOSIT_ERR: message+="�Աݾ��� Ȯ���ϼ���"; break;
		case WITHDRAW_ERR: message+="�ܾ��� �����մϴ�"; break;
		case MENU_ERR: message+="������ �޴��� �ٸ��� �ʽ��ϴ�"; break;
		}
		return message;
	}
}