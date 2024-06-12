package org.example.SystemDesign.lowLevelDesign._03_behaviouralDesignPatterns.commandPattern.withCommandDesignPattern.command;

import org.example.SystemDesign.lowLevelDesign._03_behaviouralDesignPatterns.commandPattern.withCommandDesignPattern.receiver.AirConditioner;

public class TurnACOnCommand implements ICommand {

    AirConditioner ac;

    public TurnACOnCommand(AirConditioner ac){
        this.ac = ac;
    }

    @Override
    public void execute() {
        ac.turnOnAc();
    }

    @Override
    public void undo() {
        ac.turnOffAc();
    }

    @Override
    public void redo() {
        ac.turnOnAc();
    }
}
