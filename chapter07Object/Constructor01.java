
public class Constructor01 {

	public static void main(String[] args) {
		// ��newһ������ ֱ��ͨ��������ָ�����ֺ�����
		Person p1 = new Person("smith",80);
		Person p2 = new Person();
		System.out.println("p1 = " + p1.name + " " + p1.age);
		System.out.println("p2 = " + p2.name + " " + p2.age);
	}
}

class Person {
	String name;
	int age;
	//������
	//1. û�з���ֵ Ҳ����дvoid
	//2. ���������ƺ�����Personһ��
	//3. (String pName, int pAge) �ǹ������β��б� ����ͳ�Ա����һ��
	public Person(String pName, int pAge) {
		System.out.println("����������");
		name = pName;
		age = pAge;
	}

	public Person(){
		age = 18;
	}
}