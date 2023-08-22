package core.design.pattern.behavioral.observer.service;

import core.design.pattern.behavioral.observer.service.Observer;

public interface Subject {

    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}
