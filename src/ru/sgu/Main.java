package ru.sgu;

import java.sql.*;

public class Main {
    private final String username = "postgres";
    private final String password = "zaq11qaz";
    private final String url = "jdbc:postgresql://localhost:5432/task7";
    private final String library = "org.postgresql.Driver";

    private void subtask1(Statement statement) throws SQLException {
        ResultSet resultSet = statement.executeQuery("SELECT * FROM employeesAge WHERE age > 20");
        System.out.println("Сотрудники, чей возраст больше 20: ");
        while (resultSet.next())
            System.out.println("\t" + resultSet.getString(2));
        resultSet.close();
    }

    private void subtask2(Statement statement) throws SQLException {
        ResultSet resultSet = statement.executeQuery("SELECT departmentName, AVG(salary) FROM departmentSalary" +
                                                     " GROUP BY departmentName");
        System.out.println("\nСредняя зарплата по каждому отделу: ");
        while (resultSet.next())
            System.out.println("\t" + resultSet.getString(1) + " " + resultSet.getString(2));
        resultSet.close();
    }

    private void subtask3(Statement statement) throws SQLException {
        ResultSet resultSet = statement.executeQuery("SELECT departmentEmployee.employeeName, " +
                                                     "departmentLocation.departmentName, " +
                                                     "departmentLocation.location FROM " +
                                                     "departmentEmployee JOIN departmentLocation " +
                                                     "ON departmentEmployee.departmentId = " +
                                                     "departmentLocation.departmentId");
        System.out.println("\nСотрудник, его департамент и локация работы: ");
        while (resultSet.next())
            System.out.println("\t" + resultSet.getString(1) + " " + resultSet.getString(2) +
                               " " + resultSet.getString(3));
        resultSet.close();
    }

    public void run() {
        try {
            Class.forName(library);
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();

            subtask1(statement);
            subtask2(statement);
            subtask3(statement);

            statement.close();
            connection.close();
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Отсутствует библиотека " + library);
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }
}
