
public class Object01 {

	public static void main(String[] args) {
		// Cat cat1 = new Cat();
		// Cat cat2 = new Cat();

		Person p1 = new Person();
		p1.speak();
		p1.cal01();
		p1.cal02(100);
		int returnRes = p1.getSum(10,20);
		System.out.println(returnRes);



	}
}

// class Cat {
// 	String name;
// 	int age;
// 	String color;
// }

class Person {

	String name;
	int age;
	public void speak() {
		System.out.println("hhh");
	}

	public void cal01() {
		int res = 0;
		for(int i = 1; i <= 1000; i++){
			res += i;
		}
		System.out.println(res);
	}

	//(int n) 形参列表
	public void cal02(int n) {
		int res = 0;
		for(int i = 1; i <= n; i++){
			res += i;
		}
		System.out.println(res);
	}

	//public 方法是公开的
	//int 方法执行后 返回一个 int 值
	//getSum 方法名
	//(int num1, int num2) 形参列表 2个形参 可以接收用户传入的两个数
	//return res : 把res的值 返回
	public int getSum(int num1, int num2) {
		int res = num1 + num2;
		return res;

	}

}