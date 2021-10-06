package factory.framework;

import java.util.Date;

public class ConnectorFactory {	//변경될 일이 없는 값이므로  builder pattern으로 구현 
	
	protected String url;
	protected String id;
	protected String password;
	protected Date connectTime;
	
	
	private ConnectorFactory(ConnectorFactoryBuilder builder) {
		this.url = builder.url;
		this.id = builder.id;
		this.password = builder.password;
		this.connectTime = new Date();
	}

	//빌더 메서드 
	public static ConnectorFactoryBuilder builder() {
		return new ConnectorFactoryBuilder();
	}

	
	public static class ConnectorFactoryBuilder{	//이너클래스 
		
		protected String url;
		protected String id;
		protected String password;
		
		public ConnectorFactoryBuilder url(String url) {
			this.url = url;
			return this;
		}
		public ConnectorFactoryBuilder id(String id) {
			this.id = id;
			return this;
		}
		public ConnectorFactoryBuilder password(String password) {
			this.password = password;
			return this;
		}
	
		
		//빌더메서드
		public ConnectorFactory build() {
			return new ConnectorFactory(this);
		}
	}
	
	
	public SMTPConnector getConnector() {
		if(url.equalsIgnoreCase("smtp.naver.com")) {
			return new NaverMailConnector(url, id, password, connectTime);
		}else if (url.equalsIgnoreCase("smtp.daum.net")) {
			return new DaumMailConnector(url, id, password, connectTime);
		}else if (url.equalsIgnoreCase("smtp.google.com")) {
			return new GoogleMailConnector(url, id, password, connectTime);
		}else {
			throw new RuntimeException("잘못된 smtp host를 입력하였습니다.");
		}
		
	}
	
	
	
	
	
	
}
