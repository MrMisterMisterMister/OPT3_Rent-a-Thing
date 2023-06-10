package com.rentathing.observers;

import java.util.ArrayList;
import java.util.List;

public abstract class Observable {

    private final List<IObserver> observers;
    private boolean hasChanged;

    protected Observable() {
        observers = new ArrayList<>();
    }

    public void registerObserver(IObserver observer) {
        observers.add(observer);
    }
    public boolean removeObserver(IObserver observer) {
        return observers.remove(observer);
    }
    public void notifyObservers() {
        if (hasChanged) {
            for (IObserver observer : observers) {
                observer.update();
            }
            clearChanged();
        }
    }

    protected void setChanged() {
        hasChanged = true;
    }

    public boolean hasChanged() {
        return hasChanged;
    }

    public void clearChanged() {
        hasChanged = false;
    }
}
