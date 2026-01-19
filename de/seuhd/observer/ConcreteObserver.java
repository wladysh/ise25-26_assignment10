package de.seuhd.observer;

public class ConcreteObserver implements Observer {
    private Subject subject;
    private int value;

    private final int id;
    private static int COUNTER = 0;

    public ConcreteObserver(Subject subject) {
        this.subject = subject;
        this.id = ++COUNTER;


        subject.attach(this);
    }

    @Override
    public void update(Subject subject) {
        if (subject instanceof ConcreteSubject concreteSubject) {
            this.value = concreteSubject.getValue();
            System.out.println("Observer " + id + " received update from subject : New value is " + value);
        }
    }


    public void detach() {
            if (subject != null) {
                subject.detach(this);
                subject = null;
            }
    }
}
