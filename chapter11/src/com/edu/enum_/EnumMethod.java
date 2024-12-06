package com.edu.enum_;

// 定义一个枚举类型 Season
enum Season {
    SPRING("Warm and pleasant"),
    SUMMER("Hot and sunny"),
    FALL("Cool and windy"),
    WINTER("Cold and snowy");

    private final String description;

    // 构造函数
    Season(String description) {
        this.description = description;
    }

    // 获取描述的方法
    public String getDescription() {
        return description;
    }

    // 重写 toString 方法，输出枚举常量名称和描述
    @Override
    public String toString() {
        return this.name() + " (" + description + ")";
    }
}

public class EnumMethod {

    public static void main(String[] args) {
        // 使用 Enum 类的一些方法

        // 1. 使用 values() 方法获取枚举常量数组
        System.out.println("Using values() method:");
        for (Season season : Season.values()) {
            System.out.println(season); // 直接调用 season，将触发 toString 方法
        }

        int[] num = {1,2,5};
        for(int i : num) {
            System.out.println("i = " + i);
        }

        // 2. 使用 valueOf(String name) 方法
        //将字符串转换为枚举对象
        System.out.println("\nUsing valueOf() method:");
        Season summer1 = Season.valueOf("SUMMER");
        System.out.println("Selected season: " + summer1);

        // 3. 使用 ordinal() 方法获取枚举常量的顺序
        System.out.println("\nUsing ordinal() method:");
        System.out.println("Ordinal of SPRING: " + Season.SPRING.ordinal());
        System.out.println("Ordinal of WINTER: " + Season.WINTER.ordinal());

        // 4. 使用 name() 方法获取枚举常量的名称
        System.out.println("\nUsing name() method:");
        System.out.println("Name of season: " + Season.FALL.name());

        // 5. 使用 toString() 方法（自动调用）
        System.out.println("\nUsing toString() method:");
        System.out.println("Spring season: " + Season.SPRING);
        System.out.println("Winter season: " + Season.WINTER);
    }
}
