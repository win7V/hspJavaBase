import java.util.Scanner;
public class IfExercise02 {

	public static void main(String[] args) {
		Scanner myScanner = new Scanner(System.in);
		char season = myScanner.next().charAt(0);
		int age = myScanner.nextInt();
		if (season == '淡'){
			if(age > 18 && age < 60){
				System.out.println("成人:40");
			}else{
				System.out.println("其它:20");
		    }
		}else if (season == '旺'){
			if (age < 18){
				System.out.println("儿童半价");
			}else if (age >18 && age < 60){
				System.out.println("成人:60");
			}else if (age >60 ){
				System.out.println("老人:20");
			}
		}
	}
}