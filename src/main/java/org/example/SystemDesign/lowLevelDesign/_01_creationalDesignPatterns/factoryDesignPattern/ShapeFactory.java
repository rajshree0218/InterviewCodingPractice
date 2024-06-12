package org.example.SystemDesign.lowLevelDesign._01_creationalDesignPatterns.factoryDesignPattern;

public class ShapeFactory {

    Shape getShape(String input){
        switch (input) {
            case "CIRCLE":
                return new Circle();
            case "RECTANGLE":
                return new Rectangle();
            default :
                return null;
        }
    }
}
