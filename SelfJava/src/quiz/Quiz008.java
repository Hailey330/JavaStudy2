package quiz;

import java.util.Arrays;

// ���ڿ� �޼��� split�� � ���ڿ��� ���ڸ� �������� ����� �迭�� �����

// "����and������".split("and") �� ����ϸ� �迭 {"����","������"}�� �����ȴ�

//	�Ʒ��� ���ڿ��� split�� �̿��Ͽ� "������ġ"�� ����غ���

public class Quiz008 {

	public static void main(String[] args) {

		String a = "�Ƶ�����:�Ե�����:����ŷ:��������:������ġ";
		String[] arr = a.split(":");
		System.out.println(arr[4]);

	}
}