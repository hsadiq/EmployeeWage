package com.bl;

public class EmpWage {

    public static final int Part_time =1;
    public static final int Full_time =2;

    public static void main(String[] args) {

        System.out.println("Welcome to Employee Wage Computation");


        //Employee Attendance UC-1
        int att = (int)(Math.random() * 10) % 2;
        if (att==1){
            System.out.println("Employee is Present");
        }else{
            System.out.println("Employee is Absent");
        }



        //Calculating Wage Per Hour UC-2

        int hour_wage= 20;
        int full_day=8;

        int wage = (hour_wage * full_day);

        System.out.println("Employee Daily wage is: "+ wage);

        //Calculating PartTime UC-3



        int Emp_Hour=0;
        int Emp_wage=0;

        int EmpCheck =(int) Math.floor(Math.random()* 10) % 3;

        //Using Switch Cases UC-4

        switch (EmpCheck){
            case Part_time:
                Emp_Hour = 4;
                break;
            case Full_time:
                Emp_Hour = 8;
                break;
            default:
                Emp_Hour = 0;
        }
        Emp_wage = Emp_Hour * hour_wage;
        System.out.println("Your Wage: "+Emp_wage);

        //Calculating Wage for Month UC-5

        int work_days = 20;

        int one_day = 160;

        int Monthly_Wage = work_days * one_day;

        System.out.println("Monthly Salary: "+ Monthly_Wage);

        //Calculate Wage According Working Hour UC-6

        int Monthly_Working_Hours = 100;

        System.out.println("Wage According To Hour is: "+ Monthly_Working_Hours);


    }
}
