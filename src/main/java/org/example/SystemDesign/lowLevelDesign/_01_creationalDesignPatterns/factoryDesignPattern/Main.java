package org.example.SystemDesign.lowLevelDesign._01_creationalDesignPatterns.factoryDesignPattern;

public class Main {

    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();
        Shape shape = shapeFactory.getShape("CIRCLE");
        shape.draw();
        Shape shape2 = shapeFactory.getShape("RECTANGLE");
        shape2.draw();
    }
}
