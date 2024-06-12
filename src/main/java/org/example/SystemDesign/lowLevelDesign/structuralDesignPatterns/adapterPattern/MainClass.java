package org.example.SystemDesign.lowLevelDesign.structuralDesignPatterns.adapterPattern;

public class MainClass {

    public static void main(String[] args) {

            /*
            * Adapter Design Pattern :
            * It allows the interface of an existing class to be used as another interface.
            * It acts as a bridge b/w two incompatible interfaces, making them work together.
            * This pattern involves a single class, kn/w as the adapter, which is responsible for joining
            * functionalities of independent or incompatible interfaces.
            *
            *
            * client -> target -> Adapter -> adaptee
            *
            * Components of Adapter pattern
            * 1. Target Interface : Defines the interface expected by the client.
            * it represents the set of operations that the client code can use.
            * it common interface that client code interacts with.
            * 2. Adaptee : The existing class or system with an incompatible interface that needs to be integrated into the new system.
            * it's the class or system that the client code can not directly use due to interface mismatches.
            * 3. Adapter : A class that implements the target interface and internally uses an instance of the adpatee to make it compatible with the target interface.
            * 4. Client : The code that uses the target interface to interact with objects.
            * it remains unaware of the specific implementation details of the adaptee and the adapter.
            * its the code that benefits from the integration of the adaptee into the system through the adapter.
            * 
            *
            *
            * */
    }

}
