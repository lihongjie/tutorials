package Observer.jdk;

import java.util.List;
import java.util.Observable;

public class WeatherSubject extends Observable {

    private String place;//地名
    private float temperature; //温度
    private float humidity;//湿度
    private List<Float> forecastTemperatures;//未来几天的温度

    public WeatherSubject(Builder builder) {
        this.temperature = builder.temperature;
        this.place = builder.place;
        this.humidity = builder.humidity;
        this.forecastTemperatures = builder.forecastTemperatures;
    }


    public void setWeatherSubject(Builder builder) {
        this.temperature = builder.temperature;
        this.place = builder.place;
        this.humidity = builder.humidity;
        this.forecastTemperatures = builder.forecastTemperatures;
        setChanged();
        notifyObservers(null);
    }

    public String getWeatherSubject() {
        return "WeatherSubject{" +
                "place='" + place + '\'' +
                ", temperature=" + temperature +
                ", humidity=" + humidity +
                ", forecastTemperatures=" + forecastTemperatures +
                '}';
    }

    public static class Builder {
        private String place;//地名
        private float temperature; //温度
        private float humidity;//湿度
        private List<Float> forecastTemperatures;//未来几天的温度

        public Builder(String place) {
            this.place = place;
        }

        public Builder temperature(float temperature) {
            this.temperature = temperature;
            return this;
        }

        public Builder humidity(float humidity) {
            this.humidity = humidity;
            return this;
        }

        public Builder forecastTemperatures(List<Float> forecastTemperatures) {
            this.forecastTemperatures = forecastTemperatures;
            return this;
        }

        public WeatherSubject build() {
            return new WeatherSubject(this);
        }
    }
}
