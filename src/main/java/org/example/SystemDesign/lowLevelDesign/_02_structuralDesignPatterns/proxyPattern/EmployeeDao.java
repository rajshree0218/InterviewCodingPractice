package org.example.SystemDesign.lowLevelDesign._02_structuralDesignPatterns.proxyPattern;

public interface EmployeeDao {
    public void create(String client, EmployeeDo ob) throws Exception;
    public void remove(String client, int employeeId) throws Exception;
    public EmployeeDo get(String client, int employeeId) throws Exception;
}
