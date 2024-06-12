package org.example.SystemDesign.lowLevelDesign.behaviouralDesignPatterns.mementoDesignPattern.memento;

import org.example.SystemDesign.lowLevelDesign.designPatterns.behavioural.mementoDesignPattern.originator.ConfigurationOriginator;

public class ConfigurationMemento {

    public int height;
    public int width;

    public ConfigurationMemento(int height, int width){
        this.height = height;
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}
