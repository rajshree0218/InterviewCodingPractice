package org.example.SystemDesign.lowLevelDesign.behaviouralDesignPatterns.commandPattern.withCommandDesignPattern.command;

public interface ICommand {
    public void execute();
    public void undo();
    public void redo();
}
