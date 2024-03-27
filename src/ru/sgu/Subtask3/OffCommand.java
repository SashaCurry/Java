package ru.sgu.Subtask3;

public class OffCommand implements ICommand {
    Car car;

    public OffCommand(Car car) {
        this.car = car;
    }

    public void execute() {
        car.off();
    }
}
