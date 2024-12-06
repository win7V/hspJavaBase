
public class MethodExercise02 {

	public static void main(String[] args) {
		 MyTools AA = new MyTools();
		 int[][] n = {{1, 2, 3},{4, 5, 6},{7, 8, 9}};
		 //AA.printDoubleArray(n);

		 Person p = new Person();
		 p.age = 18;
		 p.sex = "ÄÐ";
		 Person p2 = AA.copyPerson(p);
		 System.out.print("p.age=" + p.age + "p.sex=" + p.sex);
		 System.out.println();
		 System.out.print("p2.age=" + p2.age + "p2.sex=" + p2.sex);
		 System.out.println();
		 System.out.println(p == p2);//false

		 
	}
}

class Person {
	int age;
	String sex;
}

class MyTools {
	public void printDoubleArray(int[][] n) {
		for(int i = 0; i < n.length; i++) {
			for(int j = 0; j< n[i].length; j++) {
				System.out.print(n[i][j] + " ");
			}
			System.out.println();
		}
	}

	public Person copyPerson(Person p) {
		Person a = new Person();
		a.age = p.age;
		a.sex = p.sex;
		return a;
	}
}