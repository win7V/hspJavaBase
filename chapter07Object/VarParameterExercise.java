
public class VarParameterExercise {

	public static void main(String[] args) {
		Methods m = new Methods();
		System.out.println(m.showScore("张三",11,22,33));
		System.out.println(m.showScore("李四",11));
		


	}
}

class Methods {
	public String showScore(String name, double... scores) {
		double totalScore = 0;
		for(int i = 0; i < scores.length; i++) {
			totalScore += scores[i];
		}
		return name + "有" + scores.length + "门课程，总分为:" + totalScore;


	}
}