package core.design.pattern.behavioral.observer.service;

public interface Subject {

    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}
