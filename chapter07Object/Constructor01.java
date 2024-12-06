
public class Constructor01 {

	public static void main(String[] args) {
		// 当new一个对象 直接通过构造器指定名字和年龄
		Person p1 = new Person("smith",80);
		Person p2 = new Person();
		System.out.println("p1 = " + p1.name + " " + p1.age);
		System.out.println("p2 = " + p2.name + " " + p2.age);
	}
}

class Person {
	String name;
	int age;
	//构造器
	//1. 没有返回值 也不能写void
	//2. 构造器名称和类名Person一样
	//3. (String pName, int pAge) 是构造器形参列表 规则和成员方法一样
	public Person(String pName, int pAge) {
		System.out.println("构造器调用");
		name = pName;
		age = pAge;
	}

	public Person(){
		age = 18;
	}
}