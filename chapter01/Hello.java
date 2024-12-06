
//这是java的快速入门，演示Java的开发步骤
//对代码的相关说明
//1.public class Hello 表示Hello是一个类,是一个public共有的类
//2.Hello{ } 表示一个类的开始和结束
//3.public static  void main(String[] args) 表示一个主方法，即我们程序的入口
//4.main(){} 表示方法的开始和结束
//5.System.out.println("hello,world~"); 表示输出"hello,world~"到屏幕

public class Hello{

	//编写一个main方法
	public static void main(String[] args) {
		System.out.println("hello,world~");
	}
}

// 一个源文件中最多只能有一个public类,其它类个数不限
// 编译后,每一个类,都对应一个.class
class Dog{
	public static void main(String[] args) {
		System.out.println("hello,Dog");
	}
}

class Tiger{
	public static void main(String[] args) {
		System.out.println("hello,Dog");
	}
}