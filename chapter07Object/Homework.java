
public class Homework {

	public static void main(String[] args) {
		// A01 a = new A01();
		// double[] num = {1.1, 2.2, 3.3, -1.1};
		// System.out.print("����������ֵΪ" + a.max(num));

		// A02 a02 = new A02();
		// String[] strs = {"jack", "haa", "lala"};
		// String findStr = "haa";
		// int index = a02.find(findStr,strs);
		// if (index != -1) {
		// 	System.out.println("�ҵ��ˣ��ڵ�" + index + "λ");
		// } else {
		// 	System.out.println("û�ҵ�");
		// }

		A03 a03 = new A03();
		int[] nums = {1,2,3,4,-1};
		int[] newnums = a03.copyArr(nums);
		for(int i = 0; i < newnums.length; i++) {
			System.out.print(newnums[i] + " ");
		}




	}
}

class A01 {
	public double max(double[] num) {
		double max = 0.0;
		for(int i = 0; i< num.length; i ++) {
			if(max < num[i]) {
				max = num[i];
			}
		}
		return max;
	}
}

class A02 {
	//ʵ�ֲ����ַ���������Ԫ�ز��� ���������� ����Ҳ��� ����-1
	public int find(String findStr, String[] strs) {
		for(int i = 0; i < strs.length; i++) {
			if(findStr.equals(strs[i])) {
				return i;
			} 
		}
		//û�ҵ�
		return -1;
	}
}

class A03 {
	public int[] copyArr(int[] num) {
		int[] newnum = new int[num.length];
		for(int i = 0; i < num.length; i++) {
			newnum[i] = num[i];
		}
		return newnum;
	}
}