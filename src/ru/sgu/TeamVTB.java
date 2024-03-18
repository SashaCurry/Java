package ru.sgu;

import java.util.Arrays;

public class TeamVTB extends AbstractTeam implements Team {
    public TeamVTB(String name, String homeStadium) {
        this.name = name;
        this.homeStadium = homeStadium;
        this.league = "Единая Лига ВТБ";
        this.stats = new int[] {0, 0};
    }

    @Override
    public void getName() {
        System.out.println("Название команды" + this.name); }
    @Override
    public void setName(String newName) {
        this.name = newName;
        System.out.println("Команда успешно переименована! Новое название команды: " + this.name);
    }

    @Override
    public void getPlayers() {
        System.out.println("Состав команды:");
        for (String player : players)
            System.out.println("\t" + player);
    }
    @Override
    public void addPlayer(String newPlayer) {
        if (!players.contains(newPlayer)) {
            players.add(newPlayer);
            System.out.println("Игрок успешно добавлен в команду!");
        }
        else
            System.out.println("Данный игрок уже состоит в команде!");
    }
    @Override
    public void removePlayer(String oldPlayer) {
        if (players.contains(oldPlayer)) {
            players.remove(oldPlayer);
            System.out.println("Игрок успешно исключён из команды!");
        }
        else
            System.out.println("Данный игрок не состоит в команде!");
    }

    @Override
    public void getCoach() {
        System.out.println("Тренер команды: " + this.coach);
    }
    @Override
    public void setCoach(String newCoach) {
        if (this.coach.equals(newCoach))
            System.out.println("Данный человек уже является тренером команды!");
        else {
            this.coach = newCoach;
            System.out.println("Тренер успешно сменён! Новый тренер: " + this.coach);
        }
    }

    @Override
    public void getHomeStadium() {
        System.out.println("Домашний стадион команды: " + this.homeStadium);
    }
    @Override
    public void setHomeStadium(String newHomeStadium) {
        if (this.homeStadium.equals(newHomeStadium))
            System.out.println("Данная арена уже является стадионом команды!");
        else {
            this.homeStadium = newHomeStadium;
            System.out.println("Стадион успешно сменён! Новый стадион: " + this.homeStadium);
        }
    }

    @Override
    public void getStats() {
        System.out.println("Соотношение побед-поражений: " + stats[0] + "-" + stats[1]);
    }
    @Override
    public void setStats(int numWins, int numLose) {
        this.stats[0] = numWins;
        this.stats[1] = numLose;
        System.out.println("Статистика команды успешно изменена! Новая статистика: " + stats[0] + "-" + stats[1]);
    }

    @Override
    public void getLeague() {
        System.out.println("Лига команды: " + this.league);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TeamVTB that = (TeamVTB) o;
        return name.equals(that.name) && players.equals(that.players) &&
                coach.equals(that.coach) && homeStadium.equals(that.homeStadium) &&
                Arrays.equals(stats, that.stats) && league.equals(that.league);
    }
}
