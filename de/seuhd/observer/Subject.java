package de.seuhd.observer;
import java.util.ArrayList;
import java.util.List;

public abstract class Subject {
    protected final List<Observer> observers = new ArrayList<>();

    void attach(Observer observer) {
        if (observer == null) return;
        if (!observers.contains(observer)) {
            observers.add(observer);
        }
    }

    void detach(Observer observer) {
        observers.remove(observer);
    }

    protected void notifyObservers() {
        System.out.println("Sending update to observers ...");


        List<Observer> snapshot = new ArrayList<>(observers);
        for (Observer o : snapshot) {
            o.update(this);
        }
    }
}
