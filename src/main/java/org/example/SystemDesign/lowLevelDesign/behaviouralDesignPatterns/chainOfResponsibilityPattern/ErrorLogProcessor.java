package org.example.SystemDesign.lowLevelDesign.behaviouralDesignPatterns.chainOfResponsibilityPattern;

public class ErrorLogProcessor extends LogProcessor {

    ErrorLogProcessor(LogProcessor logProcessor) {
        super(logProcessor);
    }

    public void log(int logLevel, String message){
        if(logLevel == ERROR){
            System.out.println("ERROR: "+message);
        } else {
            super.log(logLevel, message);
        }
    }
}
