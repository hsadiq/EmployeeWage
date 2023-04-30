package com.bl;

import java.util.ArrayList;
import java.util.List;

interface EmpWageBuilder {
    public void addCompany(String name, int workingDays, int monthlyHour, int perHourSalary);
    public void computeWage();
}

class CompanyEmpWage {
    private final String name;
    private final int workingDays;
    private final int monthlyHour;
    private final int perHourSalary;
    private int totalWage;

    public CompanyEmpWage(String name, int workingDays, int monthlyHour, int perHourSalary) {
        this.name = name;
        this.workingDays = workingDays;
        this.monthlyHour = monthlyHour;
        this.perHourSalary = perHourSalary;
        totalWage = 0;
    }

    public String getName() {
        return name;
    }

    public int getWorkingDays() {
        return workingDays;
    }

    public int getMonthlyHour() {
        return monthlyHour;
    }

    public int getPerHourSalary() {
        return perHourSalary;
    }

    public int getTotalWage() {
        return totalWage;
    }

    public void setTotalWage(int totalWage) {
        this.totalWage = totalWage;
    }
}

class EmpWage implements EmpWageBuilder {

    private List<CompanyEmpWage> companyEmpWageList;

    public EmpWage() {
        companyEmpWageList = new ArrayList<>();
    }

    public void addCompany(String name, int workingDays, int monthlyHour, int perHourSalary) {
        CompanyEmpWage companyEmpWage = new CompanyEmpWage(name, workingDays, monthlyHour, perHourSalary);
        companyEmpWageList.add(companyEmpWage);
    }

    public void computeWage() {
        for (CompanyEmpWage companyEmpWage : companyEmpWageList) {
            int totalHour = 0;
            int totalWorkingDays = 0;

            while (totalWorkingDays <= companyEmpWage.getWorkingDays() && totalHour <= companyEmpWage.getMonthlyHour()) {
                totalWorkingDays++;

                int empCheck = (int) (Math.random() * 10) % 3;

                switch (empCheck) {
                    case 1:
                        totalHour = 4;
                        break;
                    case 2:
                        totalHour = 8;
                        break;
                    default:
                        totalHour = 0;
                        break;
                }

                totalWorkingDays += totalHour;
            }

            int totalWage = totalHour * companyEmpWage.getPerHourSalary();
            companyEmpWage.setTotalWage(totalWage);

            System.out.println("Total Employee Salary for " + companyEmpWage.getName() + " is: " + totalWage + "$");
        }
    }

    public static void main(String[] args) {
        EmpWage empWageBuilder = new EmpWage();
        empWageBuilder.addCompany("Infosys", 2, 10, 20);
        empWageBuilder.addCompany("Bridgelabz", 5, 80, 40);
        empWageBuilder.addCompany("Tesla", 12, 60, 100);
        empWageBuilder.computeWage();
    }
}