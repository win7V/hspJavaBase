
public class OverLoad01 {

	public static void main(String[] args) {
		Methods H = new Methods();
		H.m(3);
		H.m(1, 2);
		H.m("HHH");
		System.out.print();
		
	}
}

class Methods {
	public void m(int n) {
		System.out.println(n * n);
	}

	public void m(int n, int m) {
		System.out.println(n * m);
	}

	public void m(String c) {
		System.out.println(c);
	}
}