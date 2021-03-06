package factory.framework;

import java.util.Date;

public abstract class SMTPConnector {	//커넥터들이 상속받을 추상클래스 

	protected String url;
	protected String id;
	protected String password;
	protected Date ConnectTime;
	
	public SMTPConnector(String url, String id, String password, Date connectTime) {
		super();
		this.url = url;
		this.id = id;
		this.password = password;
		ConnectTime = connectTime;
	}

	public abstract void connect();

	@Override
	public String toString() {
		return "SMTPConnector [url=" + url + ", id=" + id + ", password=" + password + ", ConnectTime=" + ConnectTime
				+ "]";
	}
	
}
