package org.example.SystemDesign.lowLevelDesign._02_structuralDesignPatterns.proxyPattern;

public class ProxyDesignPattern {
    public static void main(String[] args) {
        try{
//            EmployeeDao employeeDao = new EmployeeDaoProxy();
//            employeeDao.create("USER", new EmployeeDo());
//            System.out.println("Operation successful");

            EmployeeDao employeeDao2 = new EmployeeDaoProxy();
            employeeDao2.create("ADMIN", new EmployeeDo());
            System.out.println("Operation successful");

        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
