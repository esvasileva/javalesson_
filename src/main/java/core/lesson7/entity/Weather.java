package core.lesson7.entity;

public class Weather {
    private String city;
    private String localdate;
    private double temperature;

    public Weather(String city, String localdate, double temperature) {
        this.city = city;
        this.localdate = localdate;
        this.temperature = temperature;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLocaldate() {
        return localdate;
    }

    public void setLocaldate(String localdate) {
        this.localdate = localdate;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "city='" + city + '\'' +
                ", localdate='" + localdate + '\'' +
                ", temperature=" + temperature +
                '}';
    }
}
