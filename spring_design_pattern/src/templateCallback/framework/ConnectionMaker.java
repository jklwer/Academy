package templateCallback.framework;

import java.sql.Connection;

@FunctionalInterface
public interface ConnectionMaker {	
	
	Connection getConnection();	//화살표 함수 사용시 추상메서드가 하나만 있어야 함
	
	//default메서드는 여러개 있어도 괜찮음 
	default void test() {
		System.out.println("aaa");
	}
	default void test1() {
		System.out.println("bbb");
	}
	default void test2() {
		System.out.println("ccc");
	}
}
