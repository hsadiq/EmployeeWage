package com.bl;

import java.util.Scanner;

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

        Scanner sc = new Scanner(System.in);
        System.out.println("enter your work hour: ");
        int ent = sc.nextInt();


        //Calculating Wage Per Hour UC-2

        int hour_wage= 20;
        int full_day=8;

        int wage = (hour_wage * full_day);

        System.out.println("Employee Daily wage is: "+ wage);

        //Calculating PartTime UC-3



        int Emp_Hour=0;
        int Emp_wage=0;

        int EmpCheck =(int) Math.floor(Math.random()* 10) % 3;

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



    }
}
