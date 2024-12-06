import java.util.Scanner;

public class ArrayTest {

    public static void main(String[] args) {
        MyTools mt = new MyTools();
        int[] arr = {10, -1, 8, 0, 34};
        mt.bubbleSort(arr);
        System.out.println("排序后的arr");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
        Scanner myScanner = new Scanner(System.in);
//        Scanner myScanner = new Scanner(System.in);
    }
}

// 创建一个类MyTools 编写一个方法  int数组冒泡
 class MyTools {
    // 冒泡排序方法
    public void bubbleSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // 交换arr[j]和arr[j + 1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}

class Person {
    String name;
    int age;
    //构造器-快捷键

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }


}