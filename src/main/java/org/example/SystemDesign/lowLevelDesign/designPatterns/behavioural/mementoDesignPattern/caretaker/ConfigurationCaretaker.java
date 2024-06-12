package org.example.SystemDesign.lowLevelDesign.designPatterns.behavioural.mementoDesignPattern.caretaker;

import org.example.SystemDesign.lowLevelDesign.designPatterns.behavioural.mementoDesignPattern.memento.ConfigurationMemento;

import java.util.ArrayList;
import java.util.List;

public class ConfigurationCaretaker {

    List<ConfigurationMemento> history = new ArrayList<>();

    public void addMemento(ConfigurationMemento memento){
        history.add(memento);
    }

    public ConfigurationMemento undo(){
        if(!history.isEmpty()){
            int lastMementoIndex = history.size()-1;
            //get the last memento from the list
            ConfigurationMemento lastMemento = history.get(lastMementoIndex);
            //remove the last memento from the list now
            history.remove(lastMemento);
            return lastMemento;
        }
        return null;

    }
}
