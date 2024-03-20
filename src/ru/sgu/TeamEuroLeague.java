package ru.sgu;

import java.util.Arrays;

public class TeamEuroLeague extends AbstractTeam implements Team, Comparable<TeamEuroLeague> {
    public TeamEuroLeague(String name, String homeStadium) {
        this.name = name;
        this.homeStadium = homeStadium;
        this.league = "Евролига";
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
        TeamEuroLeague that = (TeamEuroLeague) o;
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
    public int compareTo(TeamEuroLeague o) {
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
        Person hesusMateo = new Person("Хесус", "Матео");
        Person anthonyRandolf = new Person("Энтони", "Рэндольф");
        Person rudyFernandes = new Person("Руди", "Фернандес");
        Person petrKornely = new Person("Пётр", "Корнели");

        TeamEuroLeague RealMadrid = new TeamEuroLeague("Реал Мадрид", "ВиЗинк Центр");

        RealMadrid.setCoach(hesusMateo);
        Person noname = new Person("no", "name");
        RealMadrid.setCoach(noname);
        RealMadrid.setCoach(hesusMateo);
        RealMadrid.getCoach();

        System.out.println();
        RealMadrid.addPlayer(anthonyRandolf);
        RealMadrid.addPlayer(rudyFernandes);
        RealMadrid.addPlayer(petrKornely);
        RealMadrid.addPlayer(noname);
        RealMadrid.removePlayer(noname);
        RealMadrid.getPlayers();

        System.out.println();
        RealMadrid.setStats(24, 6);
        RealMadrid.getStats();

        System.out.println();
        RealMadrid.setHomeStadium("ФОК \"Звёздный\"");
        RealMadrid.getHomeStadium();
        RealMadrid.setHomeStadium("ВиЗинк Центр");

        System.out.println();
        RealMadrid.getLeague();

        System.out.println("\n" + RealMadrid);

        TeamEuroLeague Fenerbahce = (TeamEuroLeague) RealMadrid.clone();
        Fenerbahce.setName("Фенербахче");

        Person sharunasYasikavichus = new Person("Шарунас", "Ясикяыичюс");
        Fenerbahce.setCoach(sharunasYasikavichus);

        System.out.println("\n" + Fenerbahce);
        System.out.println("\n" + RealMadrid);
    }
}
