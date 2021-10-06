package templateCallback.client;

import java.sql.Connection;
import java.sql.DriverManager;

import templateCallback.framework.MemberDao;


public class Run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//람다식
		//Functional Interface : 추상 메서드가 하나만 존재하는 인터페이스, 
		//						인터페이스 위에 @FunctionalInterface어노테이션 작성 
		//Functional Interface의 추상메서드는 화살표 함수 형태로 표현이 가능
		//Functional Interface의 익명클래스를 생성해, 하나만 존재하는 Functional Interface를 overide한 뒤
		//						해당 익명클래스의 인스턴스를 메서드의 매개변수로 전달.
		
		//자바의 화살표 함수도 매개변수의 타입을 생략할 수 있음 (매개변수 한개여도, 여러개여도 생략 가능 )
		//화살표 함수의 메서드 block을 생략할 경우 
		//1. 매개변수가 하나밖에 없는 메서드 
		// arg -> {...}
		 
		//2. return밖에 없는 경우 메서드 block생략, return문 생략 
		// () -> a + b
		
		//3. *** 메서드의 구문이 1줄인 경우 메서드의 block을 생략 
		
		
		String password = new MemberDao().selectPassword("dev", () -> {	//익명함수화 (람다)
			Connection conn = null;		
			try {
				conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe"
						, "bookmanager", "1234");
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return conn;
		});
		
		System.out.println("dev님의 비밀번호는 " + password + " 입니다.");
		
	}
	
}
