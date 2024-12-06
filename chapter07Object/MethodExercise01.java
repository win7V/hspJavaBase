
public class MethodExercise01 {

	public static void main(String[] args) {
		AA A = new AA();
		System.out.println(A.isOdd(1));
		System.out.println(A.isOdd(2));
		A.printChar(4,4,'#');
	}
}

class AA {
	public boolean isOdd(int n) {
		if (n % 2 != 0){
			return true;
		} else {
			return false;
		}
	}

	public void printChar(int row, int column, char c) {
		for(int i = 0; i< row; i++){
			for (int j = 0; j < column; j++){
				System.out.print(c);
			}
			System.out.println();
		}

	}
}




