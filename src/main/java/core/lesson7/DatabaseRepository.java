package core.lesson7;

import core.lesson7.entity.Weather;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseRepository {
    private String insertWeather = "insert into weather (city, localdate, temperature) values (?, ?, ?)";
    private String getWeather = "select * from weather";
    private static final String DB_PATH = "jdbc:sqlite:geekbrains.db";

    static {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public boolean saveWeatherToDataBase(Weather weather) throws SQLException {
        try (Connection connection = DriverManager.getConnection(DB_PATH)) {
            PreparedStatement saveWeather = connection.prepareStatement(insertWeather);
            saveWeather.setString(1, weather.getCity());
            saveWeather.setString(2, weather.getLocaldate());
            saveWeather.setDouble(3, weather.getTemperature());
            return saveWeather.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        throw new SQLException("Сохранение не выполнилось!");
    }

    public boolean saveWeatherToDataBase(List<Weather> weatherList) throws SQLException {

            try (Connection connection = DriverManager.getConnection(DB_PATH)) {
                PreparedStatement saveWeather = connection.prepareStatement(insertWeather);
                for (int i = 0; i < weatherList.size(); i++) {
                    saveWeather.setString(1, weatherList.get(i).getCity());
                    saveWeather.setString(2, weatherList.get(i).getLocaldate());
                    saveWeather.setDouble(3, weatherList.get(i).getTemperature());
                    saveWeather.execute();
                }
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        throw new SQLException("Сохранение не выполнилось!");
    }

    public List<Weather> getSavedToDBWeather() {
        List<Weather> weatherList = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(DB_PATH)) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(getWeather);
            while (resultSet.next()) {
                weatherList.add(new Weather(resultSet.getString("city"), resultSet.getString("localdate"), resultSet.getInt("Temperature")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(weatherList);
        return weatherList;
    }
}
