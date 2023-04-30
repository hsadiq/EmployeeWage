package com.bl.Interface;

public class CompanyEmpWage {
    private String companyName;
    private int workingDays;
    private int monthlyHours;
    private int perHourSalary;
    private int totalWage;

    public CompanyEmpWage(String companyName, int workingDays, int monthlyHours, int perHourSalary) {
        this.companyName = companyName;
        this.workingDays = workingDays;
        this.monthlyHours = monthlyHours;
        this.perHourSalary = perHourSalary;
    }

    public void setTotalWage(int totalWage) {
        this.totalWage = totalWage;
    }

    public String getCompanyName() {
        return companyName;
    }

    public int getWorkingDays() {
        return workingDays;
    }

    public int getMonthlyHours() {
        return monthlyHours;
    }

    public int getPerHourSalary() {
        return perHourSalary;
    }

    public int getTotalWage() {
        return totalWage;
    }


    @Override
    public String toString() {
        return "Total Employee Salary for " + companyName + " is: " + totalWage + "$";
    }
}

