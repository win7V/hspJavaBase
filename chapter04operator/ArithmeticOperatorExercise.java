

public class ArithmeticOperatorExercise{

	public static void main(String[] args) {
		//59���xx������xx��
		int day1 = 59;
		int week = day1 / 7;
		int day2 = day1 % 7;
		System.out.println(day1 + "��  ��" + week + "����" + day2 + "��");


		//����һ���������滪���¶�
		//�����¶�ת��Ϊ�����¶ȵĹ�ʽΪ
		//5/9*(�����¶�-100)
		double huaShi = 234.6;
		double sheShi = 5.0 / 9 * (huaShi - 100);
		System.out.println("�����¶�" + huaShi + 
			" ��Ӧ�������¶�=" + sheShi);


	}
}