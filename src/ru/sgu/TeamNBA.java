package ru.sgu;

import java.util.Arrays;

public class TeamNBA extends AbstractTeam implements Team, Comparable<TeamNBA> {
    public TeamNBA(String name, String homeStadium) {
        this.name = name;
        this.homeStadium = homeStadium;
        this.league = "Национальная Баскетбольная Ассоциация";
        this.stats = new int[] {0, 0};
    }

    @Override
    public void getName() {
        System.out.println("Название команды: " + this.name); }
    @Override
    public void setName(String newName) {
        this.name = newName;
        System.out.println("Команда успешно переименована! Новое название команды: " + this.name);
    }

    @Override
    public void getPlayers() {
        System.out.println("Состав команды:");
        for (Person player : players)
            System.out.println("\t" + player);
    }
    @Override
    public void addPlayer(Person newPlayer) {
        if (!players.contains(newPlayer)) {
            players.add(newPlayer);
            System.out.println("Игрок " + newPlayer + " успешно добавлен в команду!");
        }
        else
            System.out.println("Игрок " + newPlayer + " уже состоит в команде!");
    }
    @Override
    public void removePlayer(Person oldPlayer) {
        if (players.contains(oldPlayer)) {
            players.remove(oldPlayer);
            System.out.println("Игрок " + oldPlayer + " успешно исключён из команды!");
        }
        else
            System.out.println("Игрок " + oldPlayer + " не состоит в команде!");
    }

    @Override
    public void getCoach() {
        System.out.println("Тренер команды: " + this.coach);
    }
    @Override
    public void setCoach(Person newCoach) {
        if (this.coach == null || !this.coach.equals(newCoach)) {
            this.coach = newCoach;
            System.out.println("Тренер успешно сменён! Новый тренер: " + this.coach);
        }
        else
            System.out.println("Данный человек уже является тренером команды!");
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
        TeamNBA that = (TeamNBA) o;
        return name.equals(that.name) && players.equals(that.players) &&
                coach.equals(that.coach) && homeStadium.equals(that.homeStadium) &&
                Arrays.equals(stats, that.stats) && league.equals(that.league);
    }

    @Override
    public int hashCode() {
        int result = name == null? 0 : name.hashCode();
        for (Person player : players)
            result = 31 * result + player.hashCode();
        result = 31 * result + coach.hashCode();
        result = 31 * result + homeStadium.hashCode();
        result = 31 * result + stats[0] + stats[1];
        return 31 * result + league.hashCode();
    }

    @Override
    public int compareTo(TeamNBA o) {
        return this.name.compareTo(o.name);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder("Название: " + name + "\nИгроки: ");
        for (Person player : players)
            res.append("\n\t").append(player);
        res.append("\nТренер: ").append(coach);
        res.append("\nДомашний стадион: ").append(homeStadium);
        res.append("\nСтатистика: ").append(stats[0]).append("-").append(stats[1]);
        res.append("\nЛига: ").append(league);
        return res.toString();
    }


    public static void main(String[] args) throws CloneNotSupportedException {
        Person steveKerr = new Person("Стив", "Керр");
        Person stephenCurry = new Person("Стефен", "Карри");
        Person klayThompson = new Person("Клэй", "Томпсон");
        Person draymondGreen = new Person("Дрэймонд", "Грин");

        TeamNBA GSW = new TeamNBA("Golden State Warriors", "Chase Center");

        GSW.setCoach(steveKerr);
        Person noname = new Person("no", "name");
        GSW.setCoach(noname);
        GSW.setCoach(steveKerr);
        GSW.getCoach();

        System.out.println();
        GSW.addPlayer(stephenCurry);
        GSW.addPlayer(klayThompson);
        GSW.addPlayer(draymondGreen);
        GSW.addPlayer(noname);
        GSW.removePlayer(noname);
        GSW.getPlayers();

        System.out.println();
        GSW.setStats(35, 32);
        GSW.getStats();

        System.out.println();
        GSW.setHomeStadium("Стадион Локомотив");
        GSW.getHomeStadium();
        GSW.setHomeStadium("Chase Center");

        System.out.println();
        GSW.getLeague();

        System.out.println("\n" + GSW);

        TeamNBA OKC = (TeamNBA) GSW.clone();
        OKC.setName("Oklahoma City Thunder");

        Person markDaino = new Person("Марк", "Дэйгнолт");
        OKC.setCoach(markDaino);

        System.out.println("\n" + OKC);
        System.out.println("\n" + GSW);
    }
}
