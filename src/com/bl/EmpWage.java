package com.bl;

public class EmpWage{

    public static final int Part_time =1;
    public static final int Full_time =2;



    public static int CalcWage(String Company, int Working_Days, int Monthly_Hour, int Per_Hour_Salary){
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
        }
        int totalWage = totalHour * Per_Hour_Salary;
        System.out.println("Total Employee Salary for " + Company + " is: " + totalWage + "$");
        return totalWage;
    }

    public static void main(String[] args) {

        System.out.println("Welcome to Employee Wage Computation");
        CalcWage("Infosys", 2,10,20);
        CalcWage("Bridgelabz", 5, 80, 40);
        CalcWage("Tesla", 12,60, 100);


    }
}