package org.example.SystemDesign.lowLevelDesign.designPatterns.behavioural.iterpreterDesignPattern;

public class SumNonTerminalExpression implements AbstractExpression{

    AbstractExpression leftExpression;
    AbstractExpression rightExpression;

    public SumNonTerminalExpression(AbstractExpression leftExpression, AbstractExpression rightExpression){
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }

    @Override
    public int interpret(Context context) {
        return leftExpression.interpret(context) + rightExpression.interpret(context);
    }
}
