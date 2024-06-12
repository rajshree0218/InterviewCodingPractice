package org.example.SystemDesign.lowLevelDesign.behaviouralDesignPatterns.commandPattern.withCommandDesignPattern.command;

import org.example.SystemDesign.lowLevelDesign.behaviouralDesignPatterns.commandPattern.withoutCommandDesignPattern.AirConditioner;

public class SetACTempCommand implements ICommand {
    AirConditioner ac;

    SetACTempCommand(AirConditioner ac){
        this.ac = ac;
    }

    @Override
    public void execute() {
        ac.setTemperature(25);
    }

    @Override
    public void undo() {
        ac.setTemperature(24);
    }

    @Override
    public void redo() {
        ac.setTemperature(25);
    }
}
