/**
* 演示字符串转基本数据类型的细节
*/
public class StringToBasicDetail {
	//编写一个 main 方法
	public static void main(String[] args) {
		String str = "hello";
		//转成 int
		int n1 = Integer.parseInt(str);
		System.out.println(n1);
	}
}