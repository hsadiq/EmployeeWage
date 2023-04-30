package com.bl;
interface IEmpWageBuilder {
    void addCompanyEmpWage(String company, int empRatePerHour, int numOfWorkingDays, int maxHoursPerMonth);
    void computeEmpWage();
    int getTotalWage(String company);
}