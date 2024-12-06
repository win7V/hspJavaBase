
public class Recursion01 {

	public static void main(String[] args) {
		T t1 = new T();
		//t1.test(4);
		// int result = t1.fibonacci(3);
		// System.out.println(result);
		System.out.println(t1.monkey(8));
		
	}
}

class T {
	public void test(int n) {
		if (n > 2) {
			test (n - 1);
		}
		System.out.println("n=" + n);
	}

	public int fibonacci(int n) {
		if(n >=1) {
			if(n == 1 || n == 2) {
				return 1;
			} else {
				return fibonacci(n - 1) + fibonacci(n - 2);
			}
		} else {
			System.out.println("error");
			return -1;
		}
	}

	public int monkey(int day) {
		if (day == 10) {
			return 1;
		} else if (day >= 1 && day <= 9) {
			return (monkey(day + 1) + 1) * 2;
		} else {
			System.out.println("error day number");
			return -1;
		}
	}



}