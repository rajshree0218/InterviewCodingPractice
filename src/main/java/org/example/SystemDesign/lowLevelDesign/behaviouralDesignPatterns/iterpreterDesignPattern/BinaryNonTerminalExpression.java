package org.example.SystemDesign.lowLevelDesign.behaviouralDesignPatterns.iterpreterDesignPattern;

import org.example.SystemDesign.lowLevelDesign.designPatterns.behavioural.iterpreterDesignPattern.AbstractExpression;
import org.example.SystemDesign.lowLevelDesign.designPatterns.behavioural.iterpreterDesignPattern.Context;

public class BinaryNonTerminalExpression implements org.example.SystemDesign.lowLevelDesign.designPatterns.behavioural.iterpreterDesignPattern.AbstractExpression {

    org.example.SystemDesign.lowLevelDesign.designPatterns.behavioural.iterpreterDesignPattern.AbstractExpression leftExpression;
    org.example.SystemDesign.lowLevelDesign.designPatterns.behavioural.iterpreterDesignPattern.AbstractExpression rightExpression;
    char operator;

    public BinaryNonTerminalExpression(org.example.SystemDesign.lowLevelDesign.designPatterns.behavioural.iterpreterDesignPattern.AbstractExpression leftExpression,
                                       AbstractExpression rightExpression,
                                       char operator){
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
        this.operator = operator;
    }

    @Override
    public int interpret(Context context) {
        switch(operator){
            case '+':
                return leftExpression.interpret(context) + rightExpression.interpret(context);
            case '*':
                return leftExpression.interpret(context) * rightExpression.interpret(context);
            default :
                return 0;
        }
    }
}
