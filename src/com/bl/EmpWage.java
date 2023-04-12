package com.bl;

public class EmpWage {
    public static void main(String[] args) {

        System.out.println("Welcome to Employee Wage Computation");

        int att = (int)(Math.random() * 10) % 2;
        if (att==1){
            System.out.println("Employee is Present");
        }else{
            System.out.println("Employee is Absent");
        }

    }
}
