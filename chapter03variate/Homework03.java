
public class Homework03{

	public static void main(String[] args) {
		//编程,保存两本书名，用+拼接，看效果。保存两个性别，
		//用加号拼接，看效果。保存两本书的价格，用加号拼接，看效果

		String book1 = "城南旧事";
		String book2 = "流言";
		System.out.println(book1 + book2);//城南旧事流言

		//性别应该用char保存
		char c1 = '男';
		char c2 = '女';
		System.out.println(c1 + c2);//得到的 男字符码值+女字符码值

		//保存两本书价格
		double price1 = 123.56;
		double price2 = 100.11;
		System.out.println(price1 + price2);// 就是 123.56 + 100.11

	}
}