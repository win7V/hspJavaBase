/**
 * ��ʾ�����������ʹ��
 */

public class ArithmeticOperator{

    public static void main(String[] args) {
       //
        System.out.println(10 / 4);//2
        System.out.println(10.0 / 4);//2.5
        double d = 10 / 4;// 10 / 4 ==2 2=>2.0
        System.out.println(d);//2.0

        // % ȡģ ,ȡ��
        // �� % �ı��� ��һ����ʽ!!!! a % b = a - a / b * b
        // -10 % 3 => -10 - (-10) / 3 * 3 = -10 + 9 = -1
        // 10 % -3 = 10 - 10 / (-3) * (-3) = 10 - 9 = 1
        // -10 % -3 = (-10) - (-10) / (-3) * (-3) = -1

        System.out.println(10 % 3); //1
        System.out.println(-10 % 3); // -1
        System.out.println(10 % -3); //1
        System.out.println(-10 % -3);//-1

        //++��ʹ��
        //
        int i = 10;
        i++;//���� �ȼ��� i = i + 1; => i = 11
        ++i;//���� �ȼ��� i = i + 1; => i = 12
        System.out.println("i=" + i);//12
        /*
        ��Ϊ����ʽʹ��
        ǰ++��++i ��������ֵ
        ��++��i++�ȸ�ֵ������
        */
        int j = 8;
        //int k = ++j; //�ȼ� j=j+1;k=j;
        int k = j++; // �ȼ� k =j;j=j+1;
        System.out.println("k=" + k + "j=" + j);//8 
    }
}