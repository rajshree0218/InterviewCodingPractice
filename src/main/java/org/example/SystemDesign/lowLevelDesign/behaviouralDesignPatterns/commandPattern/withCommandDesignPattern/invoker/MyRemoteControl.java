package org.example.SystemDesign.lowLevelDesign.behaviouralDesignPatterns.commandPattern.withCommandDesignPattern.invoker;

import org.example.SystemDesign.lowLevelDesign.designPatterns.behavioural.commandPattern.withCommandDesignPattern.command.ICommand;

import java.util.Stack;

public class MyRemoteControl {

    Stack<ICommand> acCommandHistory = new Stack<>();
    ICommand command;

    public MyRemoteControl(){

    }

    public void setCommand(ICommand command){
        this.command = command;
    }

    public void pressButton(){
        command.execute();
        acCommandHistory.add(command);
    }

    public void undo(){
        if(!acCommandHistory.isEmpty()){
            ICommand lastCommand = acCommandHistory.pop();
            lastCommand.undo();
        }
    }

    public void redo(ICommand command){
        if(!acCommandHistory.isEmpty()){
            ICommand lastCommand = acCommandHistory.push(command);
            lastCommand.redo();
        }
    }
}
