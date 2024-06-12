package org.example.SystemDesign.lowLevelDesign.behaviouralDesignPatterns.iterpreterDesignPattern;

import org.example.SystemDesign.lowLevelDesign.designPatterns.behavioural.iterpreterDesignPattern.Context;

public interface AbstractExpression {
    int interpret(Context context);
}
