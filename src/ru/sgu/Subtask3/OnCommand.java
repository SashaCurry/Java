package ru.sgu.Subtask3;

public class OnCommand implements ICommand {
    Car car;

    public OnCommand(Car car) {
        this.car = car;
    }

    public void execute() {
        car.on();
    }
}
