package practice;

class A {
	int i;
}

class B extends A {
	int j;
}

class C extends B {
	int k;
}

class D extends B{
	int m;
}

public class Example05 {
	public static void main(String[] args) {
		A x = new D();
		System.out.println(x instanceof B);
		System.out.println(x instanceof C);
	}
}
