package Exceptions;

public class EmptyRecordException extends Exception {
	private int errorno;
	private String errormsg;
	public EmptyRecordException (String message) {
		
		super(message);
		this.errormsg = message;
	}
	
	public EmptyRecordException(int errorno) {
		super();
		this.errorno = errorno;
		
	}
	public EmptyRecordException(int errorno, String errormsg) {
		super();
		this.errorno = errorno;
		this.errormsg = errormsg;
		
	}
	public int getErrorno() {
		return errorno;
	}
	public void setErrorno(int errorno) {
		this.errorno = errorno;
	}
	public String getErrormsg() {
		return errormsg;
	}
	public void setErrormsg(String errormsg) {
		this.errormsg = errormsg;
	}
}