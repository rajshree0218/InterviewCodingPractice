package org.example.SystemDesign.lowLevelDesign._02_structuralDesignPatterns.proxyPattern;

public class EmployeeDaoProxy implements EmployeeDao{

    EmployeeDao employeeDao;
    EmployeeDaoProxy(){
        employeeDao = new EmployeeDaoImpl();
    }

    @Override
    public void create(String client, EmployeeDo ob) throws Exception {
        System.out.println(client);
        if(client.equals("ADMIN")){
            employeeDao.create(client,ob);
            return ;
        }
        throw new Exception("Access Denied");
    }

    @Override
    public void remove(String client, int employeeId) throws Exception {
        if(client.equals("ADMIN")){
            employeeDao.remove(client,employeeId);
            return ;
        }
        throw new Exception("Access Denied");
    }

    @Override
    public EmployeeDo get(String client, int employeeId) throws Exception {
        if(client.equals("ADMIN") || client.equals("USER")){
            return employeeDao.get(client, employeeId);
        }
        throw new Exception("Access Denied");
    }
}
