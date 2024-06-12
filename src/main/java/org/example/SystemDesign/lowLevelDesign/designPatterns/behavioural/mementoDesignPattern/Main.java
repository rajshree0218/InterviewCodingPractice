package org.example.SystemDesign.lowLevelDesign.designPatterns.behavioural.mementoDesignPattern;

import org.example.SystemDesign.lowLevelDesign.designPatterns.behavioural.mementoDesignPattern.caretaker.ConfigurationCaretaker;
import org.example.SystemDesign.lowLevelDesign.designPatterns.behavioural.mementoDesignPattern.memento.ConfigurationMemento;
import org.example.SystemDesign.lowLevelDesign.designPatterns.behavioural.mementoDesignPattern.originator.ConfigurationOriginator;

/*
* Memento Design Pattern / Snapshot Design Pattern
* Why it's required and When to use:
* Provides an ability to revert an object to a previous state that is UNDO capability.
* And
* It does not expose the object internal implementations.
*
* 3 Major components:
* 1. Originator :
*   - It represents the object, for which state need to be saved and restored.
*   - Expose Methods to save and restore it's state using Memento Object.
* 2. Memento : It represents an Object which holds the state of the Originator.
* 3. Caretaker : Manages the list of states (list of memento).
* */
public class Main {
    public static void main(String[] args) {
        ConfigurationCaretaker caretaker = new ConfigurationCaretaker();
        // initiate state of the originator
        ConfigurationOriginator originator = new ConfigurationOriginator(5,10);

        System.out.println("height: "+originator.getHeight()+" width: "+originator.getWidth());

        //save it
        ConfigurationMemento snapshot1 = originator.createMemento();
        // add it to the history
        caretaker.addMemento(snapshot1);
        //originator changing to new state
        originator.setHeight(7);
        originator.setWidth(12);

        System.out.println("height: "+originator.getHeight()+" width: "+originator.getWidth());


        //save it
        ConfigurationMemento snapshot2 = originator.createMemento();
        //add it to the history
        caretaker.addMemento(snapshot2);
        // originator changing to new state
        originator.setHeight(9);
        originator.setWidth(14);

        System.out.println("Before UNDO :");
        System.out.println("height: "+originator.getHeight()+" width: "+originator.getWidth());
        //UNDO
        ConfigurationMemento restoredStateMementoObj = caretaker.undo();

        System.out.println("After UNDO :");
        System.out.println("height: "+originator.getHeight()+" width: "+originator.getWidth());
        //restore
        originator.restoreMemento(restoredStateMementoObj);

        System.out.println("After Restore :");
        System.out.println("height: "+originator.getHeight()+" width: "+originator.getWidth());

    }
}
