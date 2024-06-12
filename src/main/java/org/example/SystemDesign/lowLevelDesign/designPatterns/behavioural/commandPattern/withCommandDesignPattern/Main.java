package org.example.SystemDesign.lowLevelDesign.designPatterns.behavioural.commandPattern.withCommandDesignPattern;



import org.example.SystemDesign.lowLevelDesign.designPatterns.behavioural.commandPattern.withCommandDesignPattern.command.TurnACOnCommand;
import org.example.SystemDesign.lowLevelDesign.designPatterns.behavioural.commandPattern.withCommandDesignPattern.invoker.MyRemoteControl;
import org.example.SystemDesign.lowLevelDesign.designPatterns.behavioural.commandPattern.withCommandDesignPattern.receiver.AirConditioner;

// command pattern is used for redo/undo functionality
//client
public class Main {

    public static void main(String[] args) {
        // ac object
        AirConditioner ac = new AirConditioner();

        //remote obj
        MyRemoteControl remoteControl = new MyRemoteControl();

        // create the command and press the button
        TurnACOnCommand command = new TurnACOnCommand(ac);
        remoteControl.setCommand(command);
        remoteControl.pressButton();
        remoteControl.undo();
        remoteControl.pressButton();
        remoteControl.redo(command);
    }

}