

public class ArithmeticOperatorExercise{

	public static void main(String[] args) {
		//59天合xx星期零xx天
		int day1 = 59;
		int week = day1 / 7;
		int day2 = day1 % 7;
		System.out.println(day1 + "天  合" + week + "周零" + day2 + "天");


		//定义一个变量保存华氏温度
		//华氏温度转换为摄氏温度的公式为
		//5/9*(华氏温度-100)
		double huaShi = 234.6;
		double sheShi = 5.0 / 9 * (huaShi - 100);
		System.out.println("华氏温度" + huaShi + 
			" 对应的摄氏温度=" + sheShi);


	}
}