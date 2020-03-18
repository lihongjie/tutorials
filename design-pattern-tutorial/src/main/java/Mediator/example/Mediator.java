package Mediator.example;

public interface Mediator  {
    void Register(Colleague c, String type);
    void Changed(String type);
}