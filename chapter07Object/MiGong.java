

public class MiGong {

	public static void main(String[] args) {
		//˼·
		//1. �ȴ����Թ� ��ά���� int[][] map = new int[8][7];
		//2. �涨map��ֵ 1�ϰ��� 0������

		int[][] map = new int[8][7];
		//3. ��������һ�к�������һ�� ȫ������Ϊ1
		for(int i = 0; i < 7; i++) {
			map[0][i] = 1;
			map[7][i] = 1;
		}
		//3. ��������һ�к�������һ�� ȫ������Ϊ1
		for(int i = 0; i < 8; i++) {
			map[i][0] = 1;
			map[i][6] = 1;
		}
		map[3][1] = 1;
		map[3][2] = 1;


		//�����ǰ��ͼ
		System.out.println("====��ǰ��ͼ���====");
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}

		//ʹ��findWay��������·
		T t1 = new T();
		t1.findWay(map, 1, 1);

		System.out.println();
		System.out.println("====��·�����====");

		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}














	}
}

class T {

	//ʹ�õݹ����˼�����Թ�
	//
	//1. findWay �����ҳ��Թ�·��
	//2. �ҵ�����true,���򷵻�false
	//3. map ���Ƕ�ά���� ����ʾ�Թ�
	//4. i,j ���������λ�� ��ʼ��Ϊ��1��1��
	//5. �ݹ���· �ȹ涨map����ĸ���ֵ�ĺ���
	// 0������ 1�ϰ��� 2������ 3�߹������߲�ͨ����·
	//6. ��map[6][5] == 2 ��˵���ҵ�ͨ· ����ͼ�����
	//7. ��ȷ��������·���� ��->��->��->��

	public boolean findWay(int[][] map, int i, int j) {

		if(map[6][5] == 2) {
			return true;
		} else {
			if(map[i][j] == 0) { //��ǰ���λ�õ���0 ˵��������
				//�ٶ�������ͨ
				map[i][j] = 2;
				//ʹ����·���� ��ȷ����λ���Ƿ���Ŀ�����ͨ
				//��->��->��->��
				if(findWay(map, i + 1, j)) { //������
					return true;
				} else if(findWay(map, i, j + 1)) { //��
					return true;
				} else if(findWay(map, i - 1, j)) { //��
					return true;
				} else if(findWay(map, i, j - 1)) { //��
					return true;
				} else {
					map[i][j] = 3;
					return false;
				}

			} else{ //map[i][j] = 1 2 3
				return false;

			}
		}


























	}
}