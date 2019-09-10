package quizz;

public class ErrorApp extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7563928521550749889L;

	private String serviceID;
	private String code;
	private String msg;
	private String type;
	private Throwable originException;

	public ErrorApp(String serviceID, String code, String msg, String type, Throwable originException) {
		super();
		this.serviceID = serviceID;
		this.code = code;
		this.msg = msg;
		this.type = type;
		this.originException = originException;
	}

	public String getServiceID() {
		return serviceID;
	}

	public void setServiceID(String serviceID) {
		this.serviceID = serviceID;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Throwable getOriginException() {
		return originException;
	}

	public void setOriginException(Throwable originException) {
		this.originException = originException;
	}

	@Override
	public String toString() {
		return "ErrorAPP [serviceID=" + serviceID + ", code=" + code + ", msg=" + msg + ", type=" + type
				+ ", originException=" + originException + "]";
	}

}
