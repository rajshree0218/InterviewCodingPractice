package org.example.SystemDesign.lowLevelDesign.behaviouralDesignPatterns.chainOfResponsibilityPattern;

import org.example.SystemDesign.lowLevelDesign.designPatterns.behavioural.chainOfResponsibilityPattern.LogProcessor;

public class DebugLogProcessor extends org.example.SystemDesign.lowLevelDesign.designPatterns.behavioural.chainOfResponsibilityPattern.LogProcessor {

    DebugLogProcessor(LogProcessor nextLogProcessor){
        super(nextLogProcessor);
    }

    public void log(int logLevel, String msg){
        if(logLevel == DEBUG){
            System.out.println("DEBUG: "+msg);
        } else {
            super.log(logLevel,msg);
        }
    }
}
