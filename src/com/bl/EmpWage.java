package com.bl;

public class EmpWage {
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
        int hours_day=8;

        int wage = (hour_wage * hours_day);

        System.out.println("Employee Daily wage is: "+ wage);

    }
}
