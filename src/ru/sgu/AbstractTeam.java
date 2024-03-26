package ru.sgu;

import java.util.ArrayList;
import java.util.List;


abstract class AbstractTeam {
    String name;
    List<Person> players = new ArrayList<>();
    Person coach;
    String homeStadium;
    int[] stats;
    String league;
}
