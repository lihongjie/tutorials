package Observer.jdk;

public class Observer implements IObserver {

    @Override
    public void update(ISubject subject) {
        Subject sub = (Subject) subject;
    }
}
