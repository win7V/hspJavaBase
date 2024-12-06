

public class MiGong {

	public static void main(String[] args) {
		//思路
		//1. 先创建迷宫 二维数组 int[][] map = new int[8][7];
		//2. 规定map数值 1障碍物 0可以走

		int[][] map = new int[8][7];
		//3. 将最上面一行和最下面一行 全部设置为1
		for(int i = 0; i < 7; i++) {
			map[0][i] = 1;
			map[7][i] = 1;
		}
		//3. 将最右面一列和最左面一列 全部设置为1
		for(int i = 0; i < 8; i++) {
			map[i][0] = 1;
			map[i][6] = 1;
		}
		map[3][1] = 1;
		map[3][2] = 1;


		//输出当前地图
		System.out.println("====当前地图情况====");
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}

		//使用findWay给老鼠找路
		T t1 = new T();
		t1.findWay(map, 1, 1);

		System.out.println();
		System.out.println("====找路的情况====");

		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}














	}
}

class T {

	//使用递归回溯思想解决迷宫
	//
	//1. findWay 方法找出迷宫路径
	//2. 找到返回true,否则返回false
	//3. map 就是二维数组 即表示迷宫
	//4. i,j 就是老鼠的位置 初始化为（1，1）
	//5. 递归找路 先规定map数组的各个值的含义
	// 0可以走 1障碍物 2可以走 3走过但是走不通是死路
	//6. 当map[6][5] == 2 就说明找到通路 否则就继续找
	//7. 先确定老鼠找路策略 下->右->上->左

	public boolean findWay(int[][] map, int i, int j) {

		if(map[6][5] == 2) {
			return true;
		} else {
			if(map[i][j] == 0) { //当前这个位置等于0 说明可以走
				//假定可以走通
				map[i][j] = 2;
				//使用找路策略 来确定该位置是否真的可以走通
				//下->右->上->左
				if(findWay(map, i + 1, j)) { //先走下
					return true;
				} else if(findWay(map, i, j + 1)) { //右
					return true;
				} else if(findWay(map, i - 1, j)) { //上
					return true;
				} else if(findWay(map, i, j - 1)) { //左
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