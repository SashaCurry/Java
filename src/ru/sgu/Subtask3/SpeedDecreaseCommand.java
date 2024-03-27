package ru.sgu.Subtask3;

public class SpeedDecreaseCommand implements ICommand {
    Car car;

    public SpeedDecreaseCommand(Car car) {
        this.car = car;
    }

    public void execute() {
        car.speedDecrease();
    }
}
