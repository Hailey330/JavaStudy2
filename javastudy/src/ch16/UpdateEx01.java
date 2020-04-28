package ch16;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UpdateEx01 {

	public static void main(String[] args) {
		// OracleDriver o = new OracleDriver();
		// �ٸ� ���ÿ��� �ʿ��ϸ� �� new �ؾ��Ѵ�. 
		try {
			final String SQL = "update users set password = ? where id = ?";
			// OJDBC ������ �ش� ����̹��� �ε��϶�� �޴����� ����
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// ��Ʈ�� ����
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "ssar", "bitc5600");
			// ���� �ޱ� (? �� ����ϰ� ���ش�)
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, "5678"); // ù��° ����ǥ�� 5678 �����͸� update
			pstmt.setInt(2, 2); // �ι�° ����ǥ(id) ������ update
			// ���ۿ� ���� (commit)
			// execute �� select������ ��.
			// insert, delete �� ������ ����Ǵ� ����. ��, commit �Ǿ�� �ϴ� ������ executeUpdate ���
			pstmt.executeUpdate();
			System.out.println("Update �Ϸ�");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}