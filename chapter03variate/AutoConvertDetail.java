
public class AutoConvertDetail{

	public static void main(String[] args) {
		//ϸ�� 1�� �ж������͵����ݻ������ʱ��
		//ϵͳ�����Զ�����������ת�����������������������ͣ�Ȼ���ٽ��м���
		int n1 = 10;//ok
		//float d1 = n1 + 1.1;//false n1 + 1.1 -> ��������� double
		double d1 = n1 + 1.1;// true
		float d1 = n1 + 1.1F;//true

		//ϸ�� 2: �����ǰѾ���(����)�� ���������͸�ֵ������(����)С ����������ʱ��
		//�ͻᱨ����֮�ͻ�����Զ�����ת����
		
		//int n2 = 1.1;//false double -> int

		//ϸ�� 3: (byte, short) �� char ֮�䲻���໥�Զ�ת��
		//���Ѿ��������� byte ʱ��
		//(1)���жϸ����Ƿ��� byte ��Χ�ڣ�����ǾͿ���
		byte b1 = 10;//true -128~127
		// int n2 = 1;
		// byte b2 = n2;//false ����Ǳ�����ֵ,�ж�����
		//
		//char c1 = b1;//false byte�����Զ�ת��char
		//


		//ϸ�� 4: byte��short��char �������߿��Լ��㣬�ڼ���ʱ����ת��Ϊ int

		byte b2 = 1;
		byte b3 = 2;
		short s1 = 1;
		//short s2 = b2 + s1;//false,b2 + s1 -> int
		int s2 = b2 + s1;//ture

		//byte b4 = b2 + b3;//false
		//

		//boolean ������ת��
		boolean pass = true;
		//int num100 = pass;//false boolean ������ת��

		//�Զ�����ԭ�� ���ʽ����������Զ�����Ϊ ����������������

		byte b4 = 1;
		short s3 = 100;
		int num200 = 1;
		double num300 = 1.1;

		double num500 = b4 + s3 + num200 + num300;


	}
}