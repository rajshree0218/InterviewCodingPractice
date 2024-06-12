package org.example.SystemDesign.lowLevelDesign._02_structuralDesignPatterns.compositeDesignPattern.ProblemStatement;

public class File {

    String fileName;

    public File(String name){
        this.fileName = name;
    }

    public void ls(){
        System.out.println("file name " + fileName);
    }
}
