import java.util.Scanner;//��java.util�µ�Scanner�ർ��
public class Input {

	public static void main(String[] args) {
		
		//��ʾ�����û�������
		//����
		//Scanner�� ��ʾ ���ı�ɨ���� ��java.util��
		//1. ���� Scanner �����ڵİ�
		//2. ���� Scanner ����,new ����һ������,
		//   myScanner ���� Scanner ��Ķ���
		Scanner myScanner = new Scanner(System.in);
		//3. �����û��������ˣ�ʹ�� ��صķ���
		System.out.println("����������");
		String name = myScanner.next();// �����û�����
		System.out.println("����������");
		int age = myScanner.nextInt();// �����û�����
		System.out.println("������нˮ");
		double salary = myScanner.nextDouble();// �����û�����
		System.out.println("�˵���Ϣ���£�");
		System.out.println("name="+ name +
						   "  age=" + age +
						   "  salary=" + salary);

	}
}