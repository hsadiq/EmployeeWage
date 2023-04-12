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
        int full_day=8;

        int wage = (hour_wage * full_day);

        System.out.println("Employee Daily wage is: "+ wage);

        //Calculating PartTime UC-3

        int  half_day= 4;

        int wage1= (hour_wage * half_day);

        switch (wage){
            case 1:
                System.out.println("Employee full time wage is: "+ wage);

            case 2:
                System.out.println("Employee Part Time Wage is: "+ wage1);
        }



    }
}
