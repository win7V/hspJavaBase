
public class TernaryOperatorExercise {

	public static void main(String[] args) {
		//ʵ�������������ֵ
		int n1 = 55;	
		int n2 = 11;	
		int n3 = 66;	

		int max1 = n1 > n2 ? n1 : n2;
		int max2 = max1 > n3 ? max1 : n3;
		System.out.println("max number is " + max2);

		// һ�����ʵ��
		int max = (n1 > n2 ? n1 : n2) > n3 ? 
					(n1 > n2 ? n1 : n2) : n3;
		System.out.println("max number is " + max);
	}
}