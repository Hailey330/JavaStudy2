package quiz;

import java.util.Scanner;

// while �� ������ ������ ���� ������ �ݺ��Ͽ� ����Ѵ�.

// ���ڸ� �Է��ϸ� �Է��� ���ڸ�ŭ "�ȳ��ϼ���"�� ����϶�

public class Quiz014 {
	
	public static void main(String[] args) {
		System.out.println("���ڸ� �Է��ϼ���");
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt(); 
		while (sc.hasNextInt()) {
			System.out.println(number + "�ȳ��ϼ���");
		break; 
		}
		
		
	}
}