package com.edu.poly_.polyparameter;

public class PolyParameter {
    public static void main(String[] args) {
        Worker a = new Worker("a", 2500);
        manager b = new manager("b", 3000, 10000);

        PolyParameter polyParameter = new PolyParameter();
        polyParameter.showEmpAnnual(a);
        polyParameter.showEmpAnnual(b);


        polyParameter.testWork(a);
        polyParameter.testWork(b);

    }

    //获取任何员工年薪
    public void showEmpAnnual(Employee e){
        System.out.println(e.getAnnual());
    }

    //添加一个方法  testWork  如果是普通员工调用work  经理调用manager

    public void testWork(Employee e) {
        if(e instanceof Worker) {
            ((Worker)e).work();
        } else if (e instanceof manager) {
            ((manager)e).manage();
        }
    }

}
