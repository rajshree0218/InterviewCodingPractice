package org.example.SystemDesign.lowLevelDesign._02_structuralDesignPatterns.proxyPattern;

public class EmployeeDaoImpl implements EmployeeDao{

    @Override
    public void create(String client, EmployeeDo ob) throws Exception {
        // creates a new row
        System.out.println("created a new row in the Employee table");
    }

    @Override
    public void remove(String client, int employeeId) throws Exception {
        //delete a row
        System.out.println("deleted row with employeeId"+ employeeId);
    }

    @Override
    public EmployeeDo get(String client, int employeeId) throws Exception {
        //fetch row
        System.out.println("fetching data from the DB");
        return new EmployeeDo();
    }
}
