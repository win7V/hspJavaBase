
public class HanoiTower {

	public static void main(String[] args) {
		Tower tower = new Tower();
		tower.move(5, 'A', 'B', 'C');
	}
}

class Tower {
	// ����
	// num ��ʾҪ�ƶ��ĸ��� a b c �ֱ��ʾA�� B�� C��
	public void move(int num, char a, char b, char c) {
		if(num == 1) {
			System.out.println(a + "->" + c);
		} else {
			// ����ж���� ���Կ������� ��������������������(num - 1)
			// (1)���ƶ��������е��̵�b,����c
			move(num - 1, a, c, b);
			// (2)��������������, �ƶ���c
			System.out.println(a + "->" + c);
			// (3)�ٰ�b���������� �ƶ���c ����a
			move(num - 1, b, a, c);
		}
	}
}