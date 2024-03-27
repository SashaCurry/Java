package ru.sgu.Subtask3;

public class TestCommand {
    public static void main(String[] args) {

        Car car = new Car();

        Driver driver = new Driver(new OnCommand(car), new OffCommand(car),
                new SpeedIncreaseCommand(car), new SpeedDecreaseCommand(car) );

        driver.onCar();
        driver.speedIncreaseCar();
        driver.speedDeacreaseCar();
        driver.offCar();
    }
}
