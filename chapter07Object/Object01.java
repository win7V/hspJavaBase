
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

	//(int n) �β��б�
	public void cal02(int n) {
		int res = 0;
		for(int i = 1; i <= n; i++){
			res += i;
		}
		System.out.println(res);
	}

	//public �����ǹ�����
	//int ����ִ�к� ����һ�� int ֵ
	//getSum ������
	//(int num1, int num2) �β��б� 2���β� ���Խ����û������������
	//return res : ��res��ֵ ����
	public int getSum(int num1, int num2) {
		int res = num1 + num2;
		return res;

	}

}