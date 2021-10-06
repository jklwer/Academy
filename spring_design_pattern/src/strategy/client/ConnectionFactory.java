package strategy.client;

import java.sql.Connection;
import java.sql.DriverManager;

import strategy.framework.ConnectionMaker;

public class ConnectionFactory implements ConnectionMaker{

	@Override
	public Connection getConnection() {//connection 생성해서 dao로 반환해야함 
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
