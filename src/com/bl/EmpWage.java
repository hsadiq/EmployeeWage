package com.bl;

public class EmpWage {

    public static final int Part_time =1;
    public static final int Full_time =2;
    public static final int Working_Days=2;
    public static final int Monthly_Hour=100;
    public static final int Per_Hour_Salary=20;

    public static int CalcWage(){
        int empHour=0;
        int totalHour=0;
        int totalWorkingDays=0;

        int empCheck = (int)(Math.random() * 10) % 3;

        while (totalWorkingDays<=Working_Days && totalHour<=Monthly_Hour) {
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
            System.out.println("Day: " + totalWorkingDays + " Hour: " + totalHour);
        }
        int totalWage = totalHour * Per_Hour_Salary;
        return totalWage;


    }

    public static void main(String[] args) {

        System.out.println("Welcome to Employee Wage Computation");
        CalcWage();
        System.out.println("Total Wage is: " + CalcWage());
    }
}