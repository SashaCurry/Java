package ru.sgu;

public interface Team {
    public void getName();
    public void setName(String newName);

    public void getPlayers();
    public void addPlayer(Person newPlayer);
    public void removePlayer(Person oldPlayer);

    public void getCoach();
    public void setCoach(Person newCoach);

    public void getHomeStadium();
    public void setHomeStadium(String newHomeStadium);

    public void getStats();
    public void setStats(int numWins, int numLose);

    public void getLeague();
}