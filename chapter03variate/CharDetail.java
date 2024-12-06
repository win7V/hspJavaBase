
public class  CharDetail {
	public static void main(String[] args) {
		//在 java 中，char 的本质是一个整数，在默认输出时，是 unicode 码对应的字符
		//要输出对应的数字，可以(int)字符
		char c1 = 97;
		System.out.println(c1); // a
		
		char c2 = 'a'; //输出'a' 对应的 数字
		System.out.println((int)c2);
		char c3 = '张';
		System.out.println((int)c3);//24352
		char c4 = 24352;

		System.out.println(c4);
		//char 类型是可以进行运算的，相当于一个整数，因为它都对应有 Unicode 码. 
		System.out.println('a' + 10);//107

		//test
		char c5 = 'b' + 1;
		System.out.println((int)c5);//99
		System.out.println(c5);//c
				

	}
}