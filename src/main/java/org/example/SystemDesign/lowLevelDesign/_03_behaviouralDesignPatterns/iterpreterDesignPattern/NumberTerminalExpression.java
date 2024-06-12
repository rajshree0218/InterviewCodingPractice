package org.example.SystemDesign.lowLevelDesign._03_behaviouralDesignPatterns.iterpreterDesignPattern;

public class NumberTerminalExpression implements AbstractExpression {

    String stringValue;

    NumberTerminalExpression(String value){
        this.stringValue = value;
    }

    @Override
    public int interpret(Context context) {
        return context.get(stringValue);
    }
}
