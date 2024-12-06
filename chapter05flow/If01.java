import java.util.Scanner;
public class If01 {

	public static void main(String[] args) {
		Scanner myScanner = new Scanner(System.in);
		System.out.println("请输入年龄");
		int age = myScanner.nextInt();
		if (age > 18) {
			System.out.println("成年了");
		}else{
			System.out.println("未成年");
		}
	}
}