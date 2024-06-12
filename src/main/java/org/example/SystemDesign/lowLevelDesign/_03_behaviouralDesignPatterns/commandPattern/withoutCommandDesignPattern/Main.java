package org.example.SystemDesign.lowLevelDesign._03_behaviouralDesignPatterns.commandPattern.withoutCommandDesignPattern;

/*
 * Let's take use case of Remote control which can control various home appliances and with that let's understand problem, then we will go with this pattern.
 * */
public class Main {

    /*
    * problem with this code:
    * - Lack of Abstraction : Today, process of turning on ac is simple,
    * but if there are more steps, client has to be aware all of that, which is not good.
    *
    * - undo/redo functionality:
    * what if I want to implement the undo/redo capability. How it will be handled.
    *
    * - Difficulty in code maintenance:
    * What if in the future, we have to support more commands for more devices examples Bulb, Ma
    * */
    public static void main(String[] args) {
        AirConditioner ac = new AirConditioner();
        ac.turnOnAc();
        ac.setTemperature(24);
        ac.turnOffAc();

        Bulb bulb = new Bulb();
        bulb.turnOnBulb();
        bulb.turnOffBulb();
    }

    /*
    * How COMMAND DESIGN PATTERN solves it?
    * It separates the logic of:
    * - Receiver
    * - Invoker
    * - Command
    *
    * Client will use this INVOKER to generate a COMMAND which is intent to a particular RECEIVER.
    * Client -> INVOKER -> COMMAND -> RECEIVER.
    *
    * */

}
