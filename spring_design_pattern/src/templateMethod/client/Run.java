package templateMethod.client;

public class Run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String password = new MemberDao().selectPassword("dev");
		System.out.println("dev님의 비밀번호는 " + password + " 입니다.");
		
	}
	
}
