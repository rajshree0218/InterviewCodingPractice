package org.example.SystemDesign.lowLevelDesign.behaviouralDesignPatterns.chainOfResponsibilityPattern;

import org.example.SystemDesign.lowLevelDesign.designPatterns.behavioural.chainOfResponsibilityPattern.LogProcessor;

public class ErrorLogProcessor extends org.example.SystemDesign.lowLevelDesign.designPatterns.behavioural.chainOfResponsibilityPattern.LogProcessor {

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
