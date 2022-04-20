package core.lesson7;


import core.lesson7.entity.Weather;

import java.io.IOException;
import java.util.List;

public interface WeatherModel {
    void getWeather(String city, Period period) throws IOException;

    List<Weather> getSavedToDBWeather();
}
