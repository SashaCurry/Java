package ru.sgu;

import java.util.ArrayList;
import java.util.List;


abstract class AbstractTeam implements Cloneable {
    String name;
    List<Person> players = new ArrayList<>();
    Person coach;
    String homeStadium;
    int[] stats;
    String league;

    protected Object clone() throws CloneNotSupportedException {
        for (int i = 0; i < players.size(); i++)
            this.players.set(i, (Person) players.get(i).clone());
        this.coach = (Person) coach.clone();
        return super.clone();
    }
}
