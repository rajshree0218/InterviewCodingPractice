package org.example.SystemDesign.lowLevelDesign.behaviouralDesignPatterns.iteratorDesignPattern;

import org.example.SystemDesign.lowLevelDesign.designPatterns.behavioural.iteratorDesignPattern.Iterator;

public interface Aggregate {
    Iterator createIterator();
}
