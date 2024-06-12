package org.example.SystemDesign.lowLevelDesign._02_structuralDesignPatterns.flyWeightPattern.designRobotGame;


/*
* Two imp interview questions.
* - Design Word Processor?
* - Design Game ?
*
*
* Definition : this pattern helps to reduce the memory usage by sharing data among multiple objects.
*
* Let's first see the issues for gaming scenario:
* attached UML diagrams 1,2,3.
*
* Observe and understanding, when to use this pattern :
* - When memory is limited
* - When object is shared data.
*   - intrinsic data : Shared among objects and remain same once defined one value.
*   - Extrinsic data : changes based on client input and differs from one object to another.
* - creation of object is expensive.
*
* This is how it solves the issue:
* - from object, remove all the extrinsic data and keep intrinsic data(this object called flyweight object).
* - This flyweight class can be immutable.
* - Extrinsic data can be passed to the flyweight class in method parameter.
* - Once the flyweight object is created, it is cached and reused whenever required.
*
*
* */
public class Main {

    public static void main(String args[]){

        IRobot humanoidRobot1 = RoboticFactory.createRobot("HUMANOID");
        humanoidRobot1.display(1,2);


        IRobot humanoidRobot2 = RoboticFactory.createRobot("HUMANOID");
        humanoidRobot2.display(10,30);

        IRobot roboDog1 = RoboticFactory.createRobot("ROBOTICDOG");
        roboDog1.display(2,9);

        IRobot roboDog2 = RoboticFactory.createRobot("ROBOTICDOG");
        roboDog2.display(11,19);

    }
}
