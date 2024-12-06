import java.util.Scanner;
public class IfExercise01 {

	public static void main(String[] args) {
		Scanner myScanner = new Scanner(System.in);
		double d1 = myScanner.nextDouble();
		double d2 = myScanner.nextDouble();
		if (d1 > 10.0 && d2 <20.0){
			System.out.println(d1 + d2);
		}else{
			System.out.println("所给数值不符合要求");
		}
	}
}