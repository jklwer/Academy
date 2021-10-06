package templateCallback.framework;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDao {
	
	public String selectPassword(String userId, ConnectionMaker connectionFactory) {	//커넥션 주입 
				
		String password = "";
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");	// 드라이버 등록

			conn = connectionFactory.getConnection();
			
			String sql = "select password from member where user_id = ?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, userId);
			rset = pstm.executeQuery();
			
			if(rset.next()) {
				password = rset.getString("password");
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				rset.close();
				pstm.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return password;
	}
	
	
	//미완의 클래스와 메서드를 만들어 사용자가 채워놓도록 해야 함 
	
	//위 코드의 문제점
	
	//트랜잭션 관리를 직접 할 수 없다.
	//다른 기능 추가시 코드를 새로 작성해야 한다. = 재사용할 수 없다.
	//가독성이 안좋다.
	
	//*디비가 바뀔때 마다 디비 주소를 일일이 다 바꿔야한다 
	//-> 커넥션 생성하는 코드를 사용자로부터 커넥션 url, id, password를 따로 받아오면 됨
	// = 커넥션 생성을 클라이언트에게 넘김 
	
	
	
	
	
	
	
	
	
	
	
}
