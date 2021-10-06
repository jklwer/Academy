package factory.client;

import factory.framework.ConnectorFactory;
import factory.framework.SMTPConnector;

public class Run {

	public static void main(String[] args) {

		SMTPConnector conn = ConnectorFactory.builder()	//ConnectorFactory에 의존 (외부에서 의존성 주입 = di)
							.url("stmt.daum.net")		//service > dao 도 의존성주입의 일종
							.id("ijij1135@daum.net")
							.password("1234")
							.build()
							.getConnector();
						conn.connect();
	}

}
