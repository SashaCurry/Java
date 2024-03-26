package ru.sgu;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Person steveKerr = new Person("Стив", "Керр");
        Person stephenCurry = new Person("Стефен", "Карри");
        Person klayThompson = new Person("Клэй", "Томпсон");
        Person draymondGreen = new Person("Дрэймонд", "Грин");

        iTeam GSW = new TeamNBA("Golden State Warriors", "Chase Center");
        GSW.setCoach(steveKerr);
        GSW.addPlayer(stephenCurry);
        GSW.addPlayer(klayThompson);
        GSW.addPlayer(draymondGreen);
        GSW.setStats(35, 32);

        Person milenkoBogicevic = new Person("Миленко", "Богичевич");
        Person aleksandrPetenev = new Person("Александр", "Петенёв");
        Person matveyPopov = new Person("Матвей", "Попов");
        Person stanislavRaish = new Person("Станислав", "Рейш");

        iTeam Avtodor = new TeamVTB("Автодор Саратов", "ЛДС \"Кристалл\"");
        Avtodor.setCoach(milenkoBogicevic);
        Avtodor.addPlayer(aleksandrPetenev);
        Avtodor.addPlayer(matveyPopov);
        Avtodor.addPlayer(stanislavRaish);
        Avtodor.setStats(16, 16);

        Person hesusMateo = new Person("Хесус", "Матео");
        Person anthonyRandolf = new Person("Энтони", "Рэндольф");
        Person rudyFernandes = new Person("Руди", "Фернандес");
        Person petrKornely = new Person("Пётр", "Корнели");

        TeamEuroLeague RealMadrid = new TeamEuroLeague("Реал Мадрид", "ВиЗинк Центр");
        RealMadrid.setCoach(hesusMateo);
        RealMadrid.addPlayer(anthonyRandolf);
        RealMadrid.addPlayer(rudyFernandes);
        RealMadrid.addPlayer(petrKornely);
        RealMadrid.setStats(24, 6);

        List<iTeam> teams = new ArrayList<>();
        teams.add(GSW);
        teams.add(Avtodor);
        teams.add(RealMadrid);
        System.out.println();
        for (iTeam team : teams) {
            team.getName();
            team.getLeague();
            System.out.println();
        }
    }
}
