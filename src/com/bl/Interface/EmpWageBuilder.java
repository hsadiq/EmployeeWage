package com.bl.Interface;

import java.util.ArrayList;
public class EmpWageBuilder implements EmpWageBuilderInterface {

    private ArrayList<CompanyEmpWage> companyEmpWageList;

    public EmpWageBuilder() {
        companyEmpWageList = new ArrayList<>();
    }

    public void addCompany(String name, int empRate, int numOfWorkingDays, int maxHoursPerMonth) {
        companyEmpWageList.add(new CompanyEmpWage(name, empRate, numOfWorkingDays, maxHoursPerMonth));
    }

    public void computeEmpWage() {
        for (CompanyEmpWage companyEmpWage : companyEmpWageList) {
            int totalWage = 0;
            int totalHour = 0;
            int totalWorkingDays = 0;

            while (totalWorkingDays < companyEmpWage.getWorkingDays() && totalHour < companyEmpWage.getMonthlyHours()) {
                int empCheck = (int) (Math.random() * 10) % 3;
                int empHour = 0;

                switch (empCheck) {
                    case 1:
                        empHour = 4;
                        break;
                    case 2:
                        empHour = 8;
                        break;
                    default:
                        empHour = 0;
                        break;
                }

                totalHour += empHour;
                totalWorkingDays++;
            }

            totalWage = totalHour * companyEmpWage.getPerHourSalary();
            companyEmpWage.setTotalWage(totalWage);
        }
    }

    public int getTotalWage(String name) {
        for (CompanyEmpWage companyEmpWage : companyEmpWageList) {
            if (companyEmpWage.getCompanyName().equals(name)) {
                return companyEmpWage.getTotalWage();
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        EmpWageBuilder empWageBuilder = new EmpWageBuilder();
        empWageBuilder.addCompany("Infosys", 20, 2, 10);
        empWageBuilder.addCompany("Bridgelabz", 40, 5, 80);
        empWageBuilder.addCompany("Tesla", 100, 12, 60);
        empWageBuilder.computeEmpWage();

        System.out.println("Total Employee Salary for Infosys is: " + empWageBuilder.getTotalWage("Infosys") + "$");
        System.out.println("Total Employee Salary for Bridgelabz is: " + empWageBuilder.getTotalWage("Bridgelabz") + "$");
        System.out.println("Total Employee Salary for Tesla is: " + empWageBuilder.getTotalWage("Tesla") + "$");
    }
}

