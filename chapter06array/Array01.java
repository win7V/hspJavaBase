import java.util.Scanner;
public class Array01{

	public static void main(String[] args) {
		// char[] num = new char[26];
		// for(int i = 0 ; i < num.length; i++) {
		// 	num[i] = (char)('A' + i);
		// 	System.out.print(num[i] + " ");
		// }

		// int[] arr = {4,-1,9,10,23};
		// int t = 0;
		// int max = arr[0];
		// for(int i = 0; i < arr.length; i++){
			
		// 	if (max < arr[i]){
		// 		t = i;
		// 		max = arr[i];
		// 	}
		// }
		// System.out.print(max + " " + t);

		//ArrayCopy
		// int[] arr1 = {11,22,33};
		// int[] arr2 = new int[arr1.length];
		// for(int i = 0; i <= arr1.length; i++){
		// 	arr2[i] = arr1[i];
		// 	System.out.println(arr1[i] + " " + arr2[i]);
		// 	arr2[2] = 100;
		// 	System.out.println(arr1[i] + " " + arr2[i]);
		//
		// }

		//ArrayReverse
		// int[] arr = {11,22,33,44,55,66};
		// for(int i = 0; i < arr.length / 2; i++){
		// 	int temp = arr[arr.length - 1 - i];
		// 	arr[arr.length - 1 -i] = arr[i];
		// 	arr[i] = temp;
		// }
		// for(int i = 0; i < arr.length; i++){
		// 	System.out.print(arr[i] + " ");
		// }

		//ArrayAdd
		// int[]arr = {1,2,3};
		// int[]arrNew = new int[arr.length + 1];
		// for(int i = 0; i < arr.length; i++){
		// 	arrNew[i] = arr [i];
		// }
		// arrNew[arrNew.length - 1] = 4;
		// arr = arrNew;
		// for(int i = 0; i < arr.length; i++){
		// 	System.out.print(arr[i] + " ");
		// }

		//ArrayAdd02

		// 	Scanner myScanner = new Scanner(System.in);

		// 	int[]arr = {1,2,3};

		// 	do {
		// 		int[]arrNew = new int[arr.length + 1];
		// 		for(int i = 0; i < arr.length; i++){
		// 			arrNew[i] = arr [i];
		// 		}
		// 		System.out.println("请输入要添加的元素");

		// 			int addNum = myScanner.nextInt();

		// 		arrNew[arrNew.length - 1] = addNum;

		// 		arr = arrNew;
		// 		System.out.println("====arr扩容后元素情况====");
		// 		for(int i = 0; i < arr.length; i++){
		// 			System.out.print(arr[i] + "\t");
		// 		}

		// 		System.out.println("是否继续添加 y/n");
		// 		char key = myScanner.next().charAt(0);
		// 		if(key == 'n'){
		// 			break;
		// 		}

		// }while(true);
		// System.out.println("成功退出添加");	

		//BubbleSort
		// int[] array = {24,69,80,57,13};
		// int temp = 0;
		// for(int j = 0; j < array.length - 1; j++){

		// 	for(int i = 0; i < array.length - 1 - j; i++){
		// 		if(array[i] > array[i + 1]){
		// 			temp = array[i];
		// 			array[i] = array[i + 1];
		// 			array[i + 1] = temp;
		// 		}
		// 	}
		// 	System.out.println("\n===第" + (j+1) + "轮===");
		// 	for(int i = 0; i< array.length; i++){
		// 		System.out.print(array[i] + "\t");
		// 	}
		// }

		//SeqSearch
		// int[] arr = {1,8,10,89,1000,1234};
		// int index = -1;
		// Scanner myScanner = new Scanner(System.in);
		// System.out.println("请输入要查找的数");
		// int aimNum = myScanner.nextInt();
		// for(int i =0; i< arr.length; i++){
		// 	if(arr[i] == aimNum){
		// 		System.out.println("目标数" + aimNum + "的下标是" + i);
		// 		index = i;
		// 		break;
		// 	}
		// }
		// if(index == -1){
		// 	System.out.println("未找到目标数");
		// }

		//TwoDimensionalArray
		// int arr[][] = new int [2][3];
		// arr[1][1] = 8;
		// for(int i =0; i < arr.length; i++){
		// 	for(int j = 0; j< arr[i].length; j++){
		// 		System.out.print(arr[i][j] + " ");
		// 	}
		// 	System.out.println();
		// }

		// int arr[][]={{4,6},{1,4,5,7},{-2}};
		// for(int i = 0; i < arr.length; i++){
		// 	for(int j = 0; j < arr[i].length; j++){
		// 		System.out.print(arr[i][j] + " ");
		// 	}
		// 	System.out.println();
		// }

		//YangHui
		// int [][]yangHui = new int[10][];
		// for(int i = 0; i < yangHui.length; i++){
		// 	//给每个一维数组(行)开辟空间
		// 	yangHui[i] = new int[i + 1];
		// 	//给每个一维数组(行)赋值
		// 	for(int j = 0; j < yangHui[i].length; j++){
		// 		if(j == 0 || j == yangHui[i].length - 1){
		// 			yangHui[i][j] = 1;
		// 		} else {
		// 			yangHui[i][j] = yangHui[i - 1][j] + yangHui[i - 1][j - 1];
		// 		}
		// 		System.out.print(yangHui[i][j] + "\t");
		// 	}
		// 	System.out.println();	
		// }


		// Scanner myScanner = new Scanner(System.in);
		// System.out.println("请输入要插入的数");
		// int insertNum = myScanner.nextInt();

		// int[] arr = {10, 12, 45, 90};
		// int index = -1; // index就是要插入的位置

		// for(int i = 0; i < arr.length; i++){
		// 	if(insertNum <= arr[i]) {
		// 		index = i;
		// 		break; // 找到位置后,就退出
		// 	}

		// 	if (index == -1) {
		// 		index = arr.length;
		// 	}

		// }
		// 	//System.out.println("index=" + index);
		// int[] arrNew = new int[arr.length + 1];
		// for(int i = 0; i<arrNew.length; i++) {
		// 	if(i < index) {
		// 		arrNew[i] = arr[i];
		// 	}else if(i == index) {
		// 		arrNew[i] = insertNum;
		// 	}else if(i >index) {
		// 		arrNew[i] = arr[i - 1];
		// 	}
		// 	System.out.print(arrNew[i] + " ");
		// }

		int[] arr = new int[10];
		int maxIndex = 0;
		int minIndex = 0;
		double average = 0;
		int sum = 0;
		//(int)(Math.random() * 100) + 1 生产随机数

		for(int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random() * 100) + 1;
		}

		System.out.println("====arr的元素情况====");
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " "); 
		}
		System.out.println();
		System.out.println("\n====arr倒叙打印====");
		for(int i = arr.length - 1; i >= 0; i--) {
			System.out.print(arr[i] + " "); 
		}

		for(int i = 0; i < arr.length; i++) {
			int max = arr[0];
			if(max < arr[i]){
				maxIndex = i;
			}
			int min = arr[0];
			if(min > arr[i]){
				minIndex = i;
			}
			sum += arr[i];
		}

		average = sum / arr.length;
		System.out.println();
		System.out.println("最大值下标=" + maxIndex);
		System.out.println("最小值下标=" + minIndex);
		System.out.println("平均值=" + average);










		

		




















	}
}