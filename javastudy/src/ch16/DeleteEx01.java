package ch16;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DeleteEx01 {

	public static void main(String[] args) {
		// OracleDriver o = new OracleDriver();
		// 다른 스택에서 필요하면 또 new 해야한다. 
		try {
			final String SQL = "delete from users where id = ?";
			// OJDBC 문서에 해당 드라이버를 로드하라는 메뉴얼이 있음
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 스트림 연결
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "ssar", "bitc5600");
			// 버퍼 달기 (? 를 사용하게 해준다)
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, 1); // 첫번째 물음표에 숫자 1 데이터를 insert
			// 버퍼에 쓰기 (commit)
			// execute 는 select문에서 씀.
			// insert, delete 등 내용이 변경되는 문장. 즉, commit 되어야 하는 문장은 executeUpdate 사용
			pstmt.executeUpdate();
			System.out.println("Delete 완료");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
