package strategy.framework;

import java.sql.Connection;

//사용자에게 커넥션 만드는 역할 위임, 우리에게 그 커넥션을 전달해줌 
public interface ConnectionMaker {	//추상클래스를 통한 상속이 아닌, 인터페이스를 통한 구현 
	
	Connection getConnection();
	
	//사용자가 이 인터페이스를 구현하도록 한 후 우리의 memberDao로 가져오기 
	//connection을 다오에서 반환받아서 쓰면 됨 
}
