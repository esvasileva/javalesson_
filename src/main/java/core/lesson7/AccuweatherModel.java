package core.lesson7;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import core.lesson7.entity.Weather;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccuweatherModel implements WeatherModel {

    private static final String PROTOCOL = "https";
    private static final String BASE_HOST = "dataservice.accuweather.com";
    private static final String FORECAST = "forecasts";
    private static final String VERSION = "v1";
    private static final String DAILY = "daily";
    private static final String ONE_DAY = "1day";
    private static final String FIVE_DAY = "5day";
    private static final String API_KEY = "g7l7GJh6s6JrUaOdGnvKgKaT7MRstwpy";
    private static final String API_KEY_QUERY_PARAM = "apikey";
    private static final String LOCATIONS = "locations";
    private static final String CITIES = "cities";
    private static final String AUTOCOMPLETE = "autocomplete";

    private static final OkHttpClient okHttpClient = new OkHttpClient();
    private static final ObjectMapper objectMapper = new ObjectMapper();

    private DatabaseRepository databaseRepository = new DatabaseRepository();

    @Override
    public void getWeather(String city, Period period) throws IOException {
        switch (period){
            case NOW:
                HttpUrl httpUrl = new HttpUrl.Builder()
                        .scheme(PROTOCOL)
                        .host(BASE_HOST)
                        .addPathSegment(FORECAST)
                        .addPathSegment(VERSION)
                        .addPathSegment(DAILY)
                        .addPathSegment(ONE_DAY)
                        .addPathSegment(detectedCityKey(city))
                        .addQueryParameter(API_KEY_QUERY_PARAM, API_KEY)
                        .build();

                Request request = new Request.Builder()
                        .url(httpUrl)
                        .build();

                Response oneDayForecastResponse = okHttpClient.newCall(request).execute();
                String weatherResponse = oneDayForecastResponse.body().string();
                System.out.println(weatherResponse);
                break;

            case FIVE_DAYS:
                HttpUrl httpUrlFiveDays = new HttpUrl.Builder()
                        .scheme(PROTOCOL)
                        .host(BASE_HOST)
                        .addPathSegment(FORECAST)
                        .addPathSegment(VERSION)
                        .addPathSegment(DAILY)
                        .addPathSegment(FIVE_DAY)
                        .addPathSegment(detectedCityKey(city))
                        .addQueryParameter(API_KEY_QUERY_PARAM, API_KEY)
                        .build();

                Request requestFiveDays = new Request.Builder()
                        .url(httpUrlFiveDays)
                        .build();

                Response fiveDayForecastResponse = okHttpClient.newCall(requestFiveDays).execute();
                String weatherResponseFiveDays = fiveDayForecastResponse.body().string();

                List<Weather> weatherList = new ArrayList<>();
                int i = 0;

                System.out.println("Погода в городе " + city + ":\n");
                JsonNode root = objectMapper.readTree(weatherResponseFiveDays);
                JsonNode daysNode = root.path("DailyForecasts");
                for (JsonNode node : daysNode) {

                    String dateNode = node.path("Date").asText();
                    int temperatureDay  = (int) ((node.path("Temperature").path("Maximum").path("Value").asInt() - 32) / 1.8);
                    int temperatureNight = (int) ((node.path("Temperature").path("Minimum").path("Value").asInt() - 32) / 1.8);
                    String day = node.path("Day").path("IconPhrase").asText();
                    String night = node.path("Night").path("IconPhrase").asText();
                    System.out.println("Дата : " + dateNode);
                    System.out.println("Днем: " + temperatureDay + "C " + day + "\n" +
                            "Ночью: " + temperatureNight + "C " + night + "\n");
                    weatherList.add(i, new Weather(city,dateNode,temperatureDay));
                    i++;
                }
                try {
                    databaseRepository.saveWeatherToDataBase(weatherList);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    private String detectedCityKey(String city) throws IOException {
        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme(PROTOCOL)
                .host(BASE_HOST)
                .addPathSegment(LOCATIONS)
                .addPathSegment(VERSION)
                .addPathSegment(CITIES)
                .addPathSegment(AUTOCOMPLETE)
                .addQueryParameter(API_KEY_QUERY_PARAM, API_KEY)
                .addQueryParameter("q", city)
                .build();

        Request request = new Request.Builder()
                .url(httpUrl)
                .get()
                .addHeader("accept", "application/json")
                .build();

        Response cityResponse = okHttpClient.newCall(request).execute();
        String weatherResponse = cityResponse.body().string();

        String cityKey = objectMapper.readTree(weatherResponse).get(0).at("/Key").asText();
        //System.out.println(cityKey);

        return cityKey;
    }

    @Override
    public List<Weather> getSavedToDBWeather() {
        return databaseRepository.getSavedToDBWeather();
    }

    public static void main(String[] args) throws IOException {
        UserInterfaceView userInterfaceView = new UserInterfaceView();
        userInterfaceView.runInterface();

    }
}
