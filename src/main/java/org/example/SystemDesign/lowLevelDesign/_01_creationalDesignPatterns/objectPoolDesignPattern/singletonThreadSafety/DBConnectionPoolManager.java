package org.example.SystemDesign.lowLevelDesign._01_creationalDesignPatterns.objectPoolDesignPattern.singletonThreadSafety;


import java.util.ArrayList;
import java.util.List;

public class DBConnectionPoolManager {

    private List<DBConnection> freeConnectionInPool = new ArrayList<>();
    private List<DBConnection> connectionCurrentlyInUse = new ArrayList<>();
    private int INITIAL_POOL_SIZE = 3;
    private int MAX_POOL_SIZE = 6;
    private static DBConnectionPoolManager dbConnectionPoolManager = null;


    private DBConnectionPoolManager(){
        for(int i=0; i<INITIAL_POOL_SIZE; i++){
            freeConnectionInPool.add(new DBConnection());
        }
    }

    public static DBConnectionPoolManager getInstance(){
        if(dbConnectionPoolManager == null){
            synchronized (DBConnectionPoolManager.class){
                if(dbConnectionPoolManager == null){
                    dbConnectionPoolManager = new DBConnectionPoolManager();
                }
            }
        }
        return dbConnectionPoolManager;
    }

    public DBConnection getDBConnection(){
        if(freeConnectionInPool.isEmpty() && connectionCurrentlyInUse.size() < MAX_POOL_SIZE){
            freeConnectionInPool.add(new DBConnection());
            System.out.println("Creating new connection and putting into the pool, free pool size: "+freeConnectionInPool.size());
        } else if(freeConnectionInPool.isEmpty() && connectionCurrentlyInUse.size() >= MAX_POOL_SIZE){
            System.out.println("Can not create new DBConnection, as max limit reached.");
            return null;
        }
        DBConnection dbConnection = freeConnectionInPool.remove(freeConnectionInPool.size()-1);
        connectionCurrentlyInUse.add(dbConnection);
        System.out.println("Adding the connection into the pool, size: "+connectionCurrentlyInUse.size());
        return dbConnection;
    }

    public void releaseDBConnection(DBConnection dbConnection){
        if(dbConnection != null){
            connectionCurrentlyInUse.remove(dbConnection);
            System.out.println("Removing db connection from Use pool, size: "+connectionCurrentlyInUse.size());
            freeConnectionInPool.add(dbConnection);
            System.out.println("Adding db connection into free pool, size: "+freeConnectionInPool.size());
        }
    }
}
