package org.example.SystemDesign.lowLevelDesign._03_behaviouralDesignPatterns.iterpreterDesignPattern;

import java.util.HashMap;
import java.util.Map;

public class Context {

    Map<String, Integer> contextMap = new HashMap<>();

    public void put(String strVariable, int value){
        contextMap.put(strVariable, value);
    }

    public int get(String strVariable){
        return contextMap.get(strVariable);
    }
}
