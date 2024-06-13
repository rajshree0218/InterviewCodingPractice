package org.example.SystemDesign.lowLevelDesign._01_creationalDesignPatterns.objectPoolDesignPattern.withoutThreadSafety;

import java.util.ArrayList;
import java.util.List;

public class DBConnectionPoolManager {

    List<DBConnection> freeConnectionInPool = new ArrayList<>();
    List<DBConnection> connectionCurrentlyInUse = new ArrayList<>();
    int INITIAL_POOL_SIZE = 3;
    int MAX_POOL_SIZE = 6;

    public DBConnectionPoolManager(){
        for(int i=0; i<INITIAL_POOL_SIZE; i++){
            freeConnectionInPool.add(new DBConnection());
        }
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
