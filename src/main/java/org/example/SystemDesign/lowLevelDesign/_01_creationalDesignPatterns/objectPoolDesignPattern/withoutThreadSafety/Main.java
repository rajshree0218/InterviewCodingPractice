package org.example.SystemDesign.lowLevelDesign._01_creationalDesignPatterns.objectPoolDesignPattern.withoutThreadSafety;

/*
* Object Pool Design Pattern
* - Manages the pool of reusable objects like DBConnection object.
* - Borrow from the pool -> use it -> then return it back to the pool.
*
*
* Advantages :
* - Reduce the overhead of creating and destroying the frequently required object (generally resource intensive objects)
* - Reduce the latency, as it uses the pre initialized objects.
* - Prevent resource exhaustion by managing the number of resource intensive object creation.
*
* Disadvantages :
* - Resource leakage can happen, if object is not handled properly and not being returned to the pool.
* - Required more memory because of managing the pool.
* - Pool management required thread safety, which is additional overhead.
* - Adds application complexity because of managing the pool.
*
*
* Many Engineers makes 1 mistake while coding for this design pattern?
*
* What's wrong with the above code?
* This Object Pool Design Pattern is used with Singleton design pattern and
* required thread safety while acquiring and releasing the resource.
*
*
* */
public class Main {
    public static void main(String[] args) {
        DBConnectionPoolManager poolManager = new DBConnectionPoolManager();

        DBConnection dbConnection1 = poolManager.getDBConnection();
        DBConnection dbConnection2 = poolManager.getDBConnection();
        DBConnection dbConnection3 = poolManager.getDBConnection();
        DBConnection dbConnection4 = poolManager.getDBConnection();
        DBConnection dbConnection5 = poolManager.getDBConnection();
        DBConnection dbConnection6 = poolManager.getDBConnection();

        poolManager.getDBConnection();
        poolManager.releaseDBConnection(dbConnection6);
    }
}
