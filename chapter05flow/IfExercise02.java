import java.util.Scanner;
public class IfExercise02 {

	public static void main(String[] args) {
		Scanner myScanner = new Scanner(System.in);
		char season = myScanner.next().charAt(0);
		int age = myScanner.nextInt();
		if (season == '��'){
			if(age > 18 && age < 60){
				System.out.println("����:40");
			}else{
				System.out.println("����:20");
		    }
		}else if (season == '��'){
			if (age < 18){
				System.out.println("��ͯ���");
			}else if (age >18 && age < 60){
				System.out.println("����:60");
			}else if (age >60 ){
				System.out.println("����:20");
			}
		}
	}
}