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
        this.totalEmpWage = 0;
        this.dailyWageList = new ArrayList<Integer>();
    }

    public void setTotalEmpWage(int totalEmpWage) {
        this.totalEmpWage = totalEmpWage;
    }

    public void setDailyWageList(ArrayList<Integer> dailyWageList) {
        this.dailyWageList = dailyWageList;
    }

    @Override
    public String toString() {
        return "Total Employee Wage for " + company + " is " + totalEmpWage;
    }
}
class EmpWageBuilder implements IEmpWageBuilder {
    public static final int PART_TIME = 1;
    public static final int FULL_TIME = 2;

    private ArrayList<CompanyEmpWage> companyEmpWageList;
    private int numOfCompanies = 0;

    public EmpWageBuilder() {
        companyEmpWageList = new ArrayList<>();
    }

    public void addCompanyEmpWage(String company, int empRatePerHour, int numOfWorkingDays, int maxHoursPerMonth) {
        companyEmpWageList.add(new CompanyEmpWage(company, empRatePerHour, numOfWorkingDays, maxHoursPerMonth));
        numOfCompanies++;
    }

    public void computeEmpWage() {
        for (int i = 0; i < numOfCompanies; i++) {
            CompanyEmpWage companyEmpWage = companyEmpWageList.get(i);
            int totalEmpHrs = 0, totalWorkingDays = 0;
            ArrayList<Integer> dailyWageList = new ArrayList<Integer>();
            while (totalEmpHrs <= companyEmpWage.maxHoursPerMonth && totalWorkingDays < companyEmpWage.numOfWorkingDays) {
                int empHrs = 0, empWage = 0;
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
                int dailyWage = empHrs * companyEmpWage.empRatePerHour;
                dailyWageList.add(dailyWage);
                totalEmpHrs += empHrs;
            }
            companyEmpWage.setTotalEmpWage(totalEmpHrs * companyEmpWage.empRatePerHour);
            companyEmpWage.setDailyWageList(dailyWageList);
            System.out.println(companyEmpWage);
        }
    }

    public int getTotalWage(String company) {
        for (int i = 0; i < numOfCompanies; i++) {
            CompanyEmpWage companyEmpWage = companyEmpWageList.get(i);
            if (company.equals(companyEmpWage.company)) {
                return companyEmpWage.totalEmpWage;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Employee Wage Computation");

        // Create an instance of EmpWageBuilder
        EmpWageBuilder empWageBuilder = new EmpWageBuilder();

        // Add companies and their details using addCompanyEmpWage method
        empWageBuilder.addCompanyEmpWage("Infosys", 20, 2, 10);
        empWageBuilder.addCompanyEmpWage("Bridgelabz", 40, 5, 20);
        empWageBuilder.addCompanyEmpWage("Tesla", 100, 12, 30);

        // Compute employee wages for all companies
        empWageBuilder.computeEmpWage();

        // Get total wage for a specific company
        System.out.println("Total wage for Infosys: " + empWageBuilder.getTotalWage("Infosys"));
        System.out.println("Total wage for Bridgelabz: " + empWageBuilder.getTotalWage("Bridgelabz"));
        System.out.println("Total wage for Tesla: " + empWageBuilder.getTotalWage("Tesla"));
    }


}