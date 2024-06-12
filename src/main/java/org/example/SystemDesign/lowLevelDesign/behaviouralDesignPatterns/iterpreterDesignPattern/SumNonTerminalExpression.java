package org.example.SystemDesign.lowLevelDesign.behaviouralDesignPatterns.iterpreterDesignPattern;

import org.example.SystemDesign.lowLevelDesign.designPatterns.behavioural.iterpreterDesignPattern.AbstractExpression;
import org.example.SystemDesign.lowLevelDesign.designPatterns.behavioural.iterpreterDesignPattern.Context;

public class SumNonTerminalExpression implements org.example.SystemDesign.lowLevelDesign.designPatterns.behavioural.iterpreterDesignPattern.AbstractExpression {

    org.example.SystemDesign.lowLevelDesign.designPatterns.behavioural.iterpreterDesignPattern.AbstractExpression leftExpression;
    org.example.SystemDesign.lowLevelDesign.designPatterns.behavioural.iterpreterDesignPattern.AbstractExpression rightExpression;

    public SumNonTerminalExpression(org.example.SystemDesign.lowLevelDesign.designPatterns.behavioural.iterpreterDesignPattern.AbstractExpression leftExpression, AbstractExpression rightExpression){
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }

    @Override
    public int interpret(Context context) {
        return leftExpression.interpret(context) + rightExpression.interpret(context);
    }
}
