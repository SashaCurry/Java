package ru.sgu.Subtask3;

import java.util.Random;

public class Food {
    private final String[][] foodList = new String[][] {{"Салат Цезарь", "350"}, {"Паста карбонара", "500"},
                                                        {"Греческий салат", "250"}, {"Суп-пюре", "150"},
                                                        {"Рабные котлеты", "300"}, {"Пицца Маргарита", "800"},
                                                        {"Фруктовый салат", "120"}, {"Жареный рис с овощами", "400"},
                                                        {"Куриная грудка на гриле", "200"}, {"Свежевыжатый сок", "200"},
                                                        {"Овощное рагу", "180"}, {"Гречневая каша", "250"},
                                                        {"Шаурма с курцей", "600"}, {"Томатный суп", "120"},
                                                        {"Жареный лосось с овощами", "450"}, {"Минестроне", "300"},
                                                        {"Фаршированные баклажаны", "280"}, {"Фруктовый йогурт", "150"},
                                                        {"Чечевичный суп", "200"},
                                                        {"Свиные рёбрышки в барбекю соусе", "300"}};
    private final String name;
    private final int calories;

    public Food() {
        Random random = new Random();
        String[] food = foodList[random.nextInt(foodList.length)];

        this.name = food[0];
        this.calories = Integer.parseInt(food[1]);
    }
    public Food(String name, int calories) {
        this.name = name;
        this.calories = calories;
    }

    public String getName() { return name; }
    public int getCalories() { return calories; }
}
