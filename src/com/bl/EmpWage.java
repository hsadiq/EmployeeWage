package com.bl;

public class EmpWage {

    public static final int Part_time = 1;
    public static final int Full_time = 2;
    private final String Company;
    private final int working_days;
    private final int monthly_hour;
    private final int Per_hour_salary;

    private int totalWage;

    public EmpWage(String company, int workingDays, int monthlyHour, int perHourSalary) {
        this.Company = company;
        this.working_days = workingDays;
        this.monthly_hour = monthlyHour;
        this.Per_hour_salary = perHourSalary;
    }

    public void CalcWage(){
        int totalHour = 0;
        int totalWorkingDays = 0;

        int empCheck = (int) (Math.random() * 10) % 3;

        while (totalWorkingDays <= working_days && totalHour < monthly_hour) {
            totalWorkingDays++;

            switch (empCheck) {
                case Part_time:
                    totalHour = 4;
                    break;
                case Full_time:
                    totalHour = 8;
                    break;
                default:
                    totalHour = 0;
                    break;
            }
            totalWorkingDays += totalHour;
        }
        int totalWage = totalHour * Per_hour_salary;
    }


    public String toString(){
        return "Total Employee Wage for Comapany: " + Company+ " is:" + totalWage;
    }

    public static void main(String[] args) {
        EmpWage Infosys = new EmpWage("Infosys",10,2,20);
        EmpWage Mphasis = new EmpWage("Mphasis", 25,20,85);
        Infosys.CalcWage();
        System.out.println(Infosys);
        Mphasis.CalcWage();
        System.out.println(Mphasis);
    }
}
//add to git