// 演示转义字符的使用
public class ChangeChar{

	//编写一个main方法
	public static void main(String[] args) {
		// \t : 一个制表位, 实现对齐功能
			System.out.println("北京\t天津\t上海");
		// \n : 换行符
			System.out.println("jack\nsmith\nmary");
		// \\ : 一个\  \\\\ : 两个\
			System.out.println("C:\\\\Windows\\System32\\cmd.exe");
		// \" : 一个"
			System.out.println("他说\"输出带双引号\"");
		// \' : 一个'
			System.out.println("他说\'输出带双引号\'");
		// \r : 一个回车 当前字符替换后面的字符
			//System.out.println("来一个\r回车"); //回车个
			System.out.println("来一个\r\n回车"); //来一个
												 //回车 
		// test
			System.out.println("书名\t作者\t价格\t销量\n三国\t罗贯中\t120\t1000"); 
	}
}