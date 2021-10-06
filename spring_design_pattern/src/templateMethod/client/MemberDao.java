package templateMethod.client;

import java.sql.Connection;
import java.sql.DriverManager;

import templateMethod.framework.AbstractMemberDao;

//추상클래스 상속받고 추상메서드 사용자가 구현 
public class MemberDao extends AbstractMemberDao{	//상속이 아닌 인터페이스 구현을 통해  다중구현하는 식이 더 괜찮음 -> Strategy Pattern
													//(상속은 다중상속이 불가하므로) 

	@Override
	public Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe"
					, "bookmanager", "1234");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return conn;
	}
}
