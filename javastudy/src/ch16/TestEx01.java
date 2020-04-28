package ch16;

class MyConnection {

}

class MyJDBC extends MyConnection {

	static MyConnection conn;

	public MyJDBC() {
		System.out.println("생성자 호출");
	}

	static { // 객체 생성 전에 초기화 할 때 사용. new 할 때 static 내부 호출!
		conn = new MyJDBC();
	}
}

public class TestEx01 {

	public static void main(String[] args) {
//		MyJDBC mj = new MyJDBC();
		try {
			Class.forName("ch16.MyJDBC");
			MyConnection conn = MyJDBC.conn;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
