package com.bl;

public class EmpWage {

    public final String Company;
    public final int working_days;
    public final int monthly_hour;
    public final int Per_hour_salary;

    public int totalWage;

    public EmpWage(String company, int workingDays, int monthlyHour, int Per_hour_salary) {
        this.Company = company;
        this.working_days = workingDays;
        this.monthly_hour = monthlyHour;
        this.Per_hour_salary = Per_hour_salary;
    }

    public void setTotalWage(int totalWage) {
        this.totalWage = totalWage;
    }

    public String toString() {

        return "Total Employee Wage for Comapany: " + Company + " is:" + totalWage;
    }

    public static class EmpWageBuilderArray {
        public static final int Part_time = 1;
        public static final int Full_time = 2;
        private int numofCompany = 0;
        private final EmpWage[] empWageArray = new EmpWage[5];

        private void addCompanyEmpWage(String company, int per_hour_rate, int working_days, int monthly_hour) {
            empWageArray[numofCompany] = new EmpWage(company, per_hour_rate, working_days, monthly_hour);
            numofCompany++;
        }

        private void computeWage() {
            for (int i = 0; i < numofCompany; i++) {
                empWageArray[i].setTotalWage(this.computeWage(empWageArray[i]));
                System.out.println(empWageArray[i]);
            }
        }

        private int computeWage(EmpWage empWage) {
            int totalHour = 0;
            int totalWorkingDays = 0;

            int empCheck = (int) (Math.random() * 10) % 3;

            while (totalWorkingDays <= empWage.monthly_hour && totalHour < empWage.working_days) {
                totalWorkingDays++;

                switch (empCheck) {
                    case Part_time:
                        totalHour = 4;
                        break;
                    case Full_time:
                        totalHour = 8;
                        break;
                    default:
                }
                totalWorkingDays += totalHour;
                System.out.println("Days: " +totalWorkingDays+ " Hour: " +totalHour);
            }
            return totalHour * empWage.Per_hour_salary;
        }

        public static void main(String[] args) {
            EmpWageBuilderArray empWageBuilder = new EmpWageBuilderArray();
            empWageBuilder.addCompanyEmpWage("Infosys", 20, 2, 10);
            empWageBuilder.computeWage();
        }
    }
}