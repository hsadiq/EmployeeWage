package com.bl.Interface;

public interface EmpWageBuilderInterface {

    public void addCompany(String name, int empRate, int numOfWorkingDays, int maxHoursPerMonth);
    public void computeEmpWage();
    public int getTotalWage(String name);

}
