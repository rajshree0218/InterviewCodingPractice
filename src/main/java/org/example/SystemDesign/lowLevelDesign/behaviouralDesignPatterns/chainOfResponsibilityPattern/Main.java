package org.example.SystemDesign.lowLevelDesign.behaviouralDesignPatterns.chainOfResponsibilityPattern;

// Design an ATM/Vending Machine/ Logger etc
public class Main {
    public static void main(String[] args) {
        LogProcessor logProcessor = new InfoLogProcessor(new DebugLogProcessor(new ErrorLogProcessor(null)));

        logProcessor.log(LogProcessor.ERROR, "exception occurred");
        logProcessor.log(LogProcessor.DEBUG, "need to debug this");
        logProcessor.log(LogProcessor.INFO, "just for info");
    }
}
