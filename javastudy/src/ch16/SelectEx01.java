package ch16;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SelectEx01 {

	public static void main(String[] args) {
		// OracleDriver o = new OracleDriver();
		// �ٸ� ���ÿ��� �ʿ��ϸ� �� new �ؾ��Ѵ�.
		try {
			final String SQL = "select id, name, email, password from users where id = ?";
			// OJDBC ������ �ش� ����̹��� �ε��϶�� �޴����� ����
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// ��Ʈ�� ����
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "ssar", "bitc5600");
			// ���� �ޱ� (? �� ����ϰ� ���ش�)
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, 3); // ù��° ����ǥ�� ���� 1 �����͸� insert
			// ���ۿ� ���� (ResultSet�� ���Ϲ���)
			// execute �� select������ ��.
			// commit �� �ʿ���� �Ӵ��� Ŀ���� �ʿ��ϱ� ������ execute ���
			ResultSet rs = pstmt.executeQuery();
			Users users = null;
			if (rs.next()) { // Ŀ�� ����
				users = new Users( rs.getInt("id"), 
											   rs.getString("name"), 
											   rs.getString("email"),
											   rs.getString("password"));
			}
			System.out.println(users.getId());
			System.out.println(users.getName());
			System.out.println(users.getEmail());
			System.out.println(users.getPassword());

			System.out.println("Select �Ϸ�");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}