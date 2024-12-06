
public class TestThis {

	public static void main(String[] args) {
		Person p1 = new Person("xiaogou", 18);
		Person p2 = new Person("xiaogo", 18);
		System.out.println(p1.compareTo(p2));
	}
}

class Person {
	String name;
	int age;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public boolean compareTo(Person p) {
		// if(this.name.equals(p.name) && this.age == p.age) {
		// 	return true;
		// } else {
		// 	return false;
		// }

		//return this.name.equals(p.name) && this.age == p.age;
		return this.name == p.name && this.age == p.age;
	}
}