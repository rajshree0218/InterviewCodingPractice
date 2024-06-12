package org.example.SystemDesign.lowLevelDesign.behaviouralDesignPatterns.iterpreterDesignPattern;


import org.example.SystemDesign.lowLevelDesign.designPatterns.behavioural.iterpreterDesignPattern.AbstractExpression;
import org.example.SystemDesign.lowLevelDesign.designPatterns.behavioural.iterpreterDesignPattern.Context;

/*
* Some can interpret this expression as:
* - Stop
* - Hi
* - Number 5
* etc
* So, it's based on CONTEXT wht we interpret.
*
*                       Components Involved
*                               / \
*                              /   \
*                             /     \
*                            /       \
*                           /         \
*                     Context        Abstract Expression
*                                        / \
*                                       /   \
*                                      /     \
*                                     /       \
*                                    /         \
*                      Terminal Expression    Non-Terminal Expression
*
* */
public class Main {
    public static void main(String[] args) {
        //initialize the context
        Context context = new Context();
        context.put("a", 2);
        context.put("b", 4);

        //a*b : 2*4 = 8
        AbstractExpression expression1 = new MultiplyNonTerminalExpression(
                new NumberTerminalExpression("a"),
                new NumberTerminalExpression("b")
        );
        System.out.println(expression1.interpret(context));

        //((a*b) + (c*d)) : ((2*4) + (8*16)) = 136
        Context context2 = new Context();
        context2.put("a", 2);
        context2.put("b", 4);
        context2.put("c", 8);
        context2.put("d", 16);

        //((a+b) + (c*d))
        AbstractExpression expression2 = new SumNonTerminalExpression(
                new MultiplyNonTerminalExpression(
                        new NumberTerminalExpression("a"),
                        new NumberTerminalExpression("b")),
                new MultiplyNonTerminalExpression(
                        new NumberTerminalExpression("c"),
                        new NumberTerminalExpression("d"))
        );

        //((a*b) + (c*d)) : ((2*4) + (8*16)) = 136
        AbstractExpression expression3 = new BinaryNonTerminalExpression(
                new BinaryNonTerminalExpression(
                        new NumberTerminalExpression("a"),
                        new NumberTerminalExpression("b"),
                        '*'),
                new BinaryNonTerminalExpression(
                        new NumberTerminalExpression("c"),
                        new NumberTerminalExpression("d"),
                        '*'),
                '+'
        );

        System.out.println(expression2.interpret(context2));
        System.out.println(expression3.interpret(context2));

    }
}
