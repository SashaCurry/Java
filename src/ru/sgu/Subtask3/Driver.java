package ru.sgu.Subtask3;

public class Driver {
    ICommand on;
    ICommand off;
    ICommand speedIncrease;
    ICommand speedDeacrease;

    public Driver(ICommand on, ICommand off, ICommand speedIncrease, ICommand speedDeacrease) {
        this.on = on;
        this.off = off;
        this.speedIncrease = speedIncrease;
        this.speedDeacrease = speedDeacrease;
    }

    public void onCar() {
        on.execute();
    }

    public void offCar() {
        off.execute();
    }

    public void speedIncreaseCar() {
        speedIncrease.execute();
    }

    public void speedDeacreaseCar() {
        speedDeacrease.execute();
    }
}
