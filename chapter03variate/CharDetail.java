
public class  CharDetail {
	public static void main(String[] args) {
		//�� java �У�char �ı�����һ����������Ĭ�����ʱ���� unicode ���Ӧ���ַ�
		//Ҫ�����Ӧ�����֣�����(int)�ַ�
		char c1 = 97;
		System.out.println(c1); // a
		
		char c2 = 'a'; //���'a' ��Ӧ�� ����
		System.out.println((int)c2);
		char c3 = '��';
		System.out.println((int)c3);//24352
		char c4 = 24352;

		System.out.println(c4);
		//char �����ǿ��Խ�������ģ��൱��һ����������Ϊ������Ӧ�� Unicode ��. 
		System.out.println('a' + 10);//107

		//test
		char c5 = 'b' + 1;
		System.out.println((int)c5);//99
		System.out.println(c5);//c
				

	}
}