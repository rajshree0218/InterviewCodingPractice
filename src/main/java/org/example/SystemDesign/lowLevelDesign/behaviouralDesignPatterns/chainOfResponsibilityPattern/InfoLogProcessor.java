package org.example.SystemDesign.lowLevelDesign.behaviouralDesignPatterns.chainOfResponsibilityPattern;

import org.example.SystemDesign.lowLevelDesign.designPatterns.behavioural.chainOfResponsibilityPattern.LogProcessor;

public class InfoLogProcessor extends org.example.SystemDesign.lowLevelDesign.designPatterns.behavioural.chainOfResponsibilityPattern.LogProcessor {

    InfoLogProcessor(LogProcessor logProcessor) {
        super(logProcessor);
    }

    public void log(int logLevel, String message){
        if(logLevel == INFO){
            System.out.println("INFO: "+message);
        } else {
            super.log(logLevel, message);
        }
    }
}
