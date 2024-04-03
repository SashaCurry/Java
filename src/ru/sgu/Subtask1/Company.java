package ru.sgu.Subtask1;

public class Company implements Comparable<Company> {
    private String name;
    private String surname;
    private String patronymic = "";
    private String company;
    private int rating;

    public Company(String str) {
        String[] mas = str.split(" ");
        surname = mas[0];
        name = mas[1];
        if (mas.length == 5) {
            patronymic = mas[2];
            company = mas[3];
            rating = Integer.parseInt(mas[4]);
        } else {
            company = mas[2];
            rating = Integer.parseInt(mas[3]);
        }
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getCompany() {
        return company;
    }

    public int getRating() {
        return rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company that = (Company) o;
        return surname.equals(that.surname) && name.equals(that.name) && patronymic.equals(that.patronymic) &&
                company.equals(that.company) && rating == that.rating;
    }

    @Override
    public String toString() {
        return surname + " " + name + " " + patronymic + " " + company + " " + rating;
    }

    @Override
    public int compareTo(Company o) {
        if (this.rating != o.rating)
            return -(this.rating - o.rating);
        else if (!this.surname.equals(o.surname))
            return this.surname.compareTo(o.surname);
        else if (!this.name.equals(o.name))
            return -this.name.compareTo(o.name);
        else
            return this.patronymic.compareTo(o.patronymic);
    }
}