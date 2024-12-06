 
public class Method01 {

	public static void main(String[] args) {
		int[][] map = {{0,1,2},{3,4,5},{6,7,8}};
		MyTools tool = new MyTools();
		tool.printArr(map);
	}
}

class MyTools {

	public void printArr(int[][] map) {
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}