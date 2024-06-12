package org.example.SystemDesign.lowLevelDesign.behaviouralDesignPatterns.chainOfResponsibilityPattern;


public class DebugLogProcessor extends LogProcessor {

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
