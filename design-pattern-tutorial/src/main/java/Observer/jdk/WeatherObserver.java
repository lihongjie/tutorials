package Observer.jdk;

import java.util.Observable;
import java.util.Observer;

public class WeatherObserver implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        WeatherSubject weatherSubject = (WeatherSubject) o;
    }
}
