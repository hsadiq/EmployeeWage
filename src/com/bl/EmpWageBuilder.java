package com.bl;

import java.util.ArrayList;

class CompanyEmpWage {
    public final String company;
    public final int empRatePerHour;
    public final int numOfWorkingDays;
    public final int maxHoursPerMonth;
    public int totalEmpWage;
    public ArrayList<Integer> dailyWageList;

    public CompanyEmpWage(String company, int empRatePerHour, int numOfWorkingDays, int maxHoursPerMonth) {
        this.company = company;
        this.empRatePerHour = empRatePerHour;
        this.numOfWorkingDays = numOfWorkingDays;
        this.maxHoursPerMonth = maxHoursPerMonth;
        totalEmpWage = 0;
        dailyWageList = new ArrayList<Integer>();
    }

    public void setTotalEmpWage(int totalEmpWage) {
        this.totalEmpWage = totalEmpWage;
    }

    @Override
    public String toString() {
        return "Total Employee Wage for Company: " + company + " is: " + totalEmpWage + "$";
    }
}

public class EmpWageBuilder implements IComputeEmpWage {
    public static final int PART_TIME = 1;
    public static final int FULL_TIME = 2;

    private ArrayList<CompanyEmpWage> companyEmpWageList;

    public EmpWageBuilder() {
        companyEmpWageList = new ArrayList<CompanyEmpWage>();
    }

    public void addCompanyEmpWage(String company, int empRatePerHour, int numOfWorkingDays, int maxHoursPerMonth) {
        CompanyEmpWage companyEmpWage = new CompanyEmpWage(company, empRatePerHour, numOfWorkingDays, maxHoursPerMonth);
        companyEmpWageList.add(companyEmpWage);
    }

    public void computeEmpWage() {
        for (CompanyEmpWage companyEmpWage : companyEmpWageList) {
            int totalEmpHrs = 0;
            int totalWorkingDays = 0;
            int dailyWage = 0;
            int empHrs = 0;

            while (totalEmpHrs <= companyEmpWage.maxHoursPerMonth && totalWorkingDays < companyEmpWage.numOfWorkingDays) {
                totalWorkingDays++;
                int empCheck = (int) Math.floor(Math.random() * 10) % 3;

                switch (empCheck) {
                    case PART_TIME:
                        empHrs = 4;
                        break;
                    case FULL_TIME:
                        empHrs = 8;
                        break;
                    default:
                        empHrs = 0;
                        break;
                }

                totalEmpHrs += empHrs;
                dailyWage = empHrs * companyEmpWage.empRatePerHour;
                companyEmpWage.dailyWageList.add(dailyWage);
            }

            companyEmpWage.setTotalEmpWage(totalEmpHrs * companyEmpWage.empRatePerHour);
            System.out.println("Daily Wage list for " + companyEmpWage.company + ": " + companyEmpWage.dailyWageList);
            System.out.println(companyEmpWage);
        }
    }

    public static void main(String[] args) {
        EmpWageBuilder empWageBuilder = new EmpWageBuilder();
        empWageBuilder.addCompanyEmpWage("Infosys", 20, 2, 10);
        empWageBuilder.addCompanyEmpWage("Bridgelabz", 40, 5, 80);
        empWageBuilder.addCompanyEmpWage("Tesla", 50, 18, 45);
        empWageBuilder.computeEmpWage();
    }
}