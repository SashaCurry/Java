package ru.sgu.Subtask3;

public class SpeedIncreaseCommand implements ICommand{
    Car car;

    public SpeedIncreaseCommand(Car car) {
        this.car = car;
    }

    public void execute() {
        car.speedIncrease();
    }
}
