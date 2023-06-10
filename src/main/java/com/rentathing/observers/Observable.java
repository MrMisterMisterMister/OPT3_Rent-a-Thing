package com.rentathing.observers;

import java.util.ArrayList;
import java.util.List;

public abstract class Observable {

    private final List<IObserver> OBSERVERS;
    private boolean hasChanged;

    protected Observable() {
        OBSERVERS = new ArrayList<>();
    }

    public void registerObserver(IObserver observer) {
        OBSERVERS.add(observer);
    }
    public boolean removeObserver(IObserver observer) {
        return OBSERVERS.remove(observer);
    }
    public void notifyObservers() {
        if (hasChanged) {
            for (IObserver observer : OBSERVERS) {
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
