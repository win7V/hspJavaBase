package com.edu.poly_.polyparameter;

public class manager extends Employee {
    private double bonus;

    public manager(String name, double salary, double bonus) {
        super(name, salary);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public double getAnnual() {
        return super.getAnnual() + bonus;
    }

    public void manage() {
        System.out.println("经理" + getName() + "在管理");
    }


}
