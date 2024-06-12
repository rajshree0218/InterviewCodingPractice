package org.example.SystemDesign.lowLevelDesign._03_behaviouralDesignPatterns.commandPattern.withCommandDesignPattern.command;

import org.example.SystemDesign.lowLevelDesign._03_behaviouralDesignPatterns.commandPattern.withCommandDesignPattern.receiver.AirConditioner;

public class TurnACOffCommand implements ICommand {
    AirConditioner ac;
    TurnACOffCommand(AirConditioner ac){
        this.ac = ac;
    }

    public void execute(){
        ac.turnOffAc();
    }

    @Override
    public void redo() {
        ac.turnOffAc();
    }

    @Override
    public void undo() {
        ac.turnOnAc();
    }
}
