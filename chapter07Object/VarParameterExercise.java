
public class VarParameterExercise {

	public static void main(String[] args) {
		Methods m = new Methods();
		System.out.println(m.showScore("����",11,22,33));
		System.out.println(m.showScore("����",11));
		


	}
}

class Methods {
	public String showScore(String name, double... scores) {
		double totalScore = 0;
		for(int i = 0; i < scores.length; i++) {
			totalScore += scores[i];
		}
		return name + "��" + scores.length + "�ſγ̣��ܷ�Ϊ:" + totalScore;


	}
}