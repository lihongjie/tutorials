package com.github.lihongjie.observer;
/**
 * A concrete subject
 */

import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class ConcreteSubject implements Subject {

    private List observerList;

    private Vector strVector;

    public ConcreteSubject() {
        observerList = new LinkedList();
        strVector = new Vector();
    }

    @Override
    public void attach(Observer o) {
        observerList.add(o);
    }

    @Override
    public void detach(Observer o) {
        observerList.remove(o);
    }

    @Override
    public void sendNotify() {
        for (int i = 0; i < observerList.size(); i++) {
            ((Observer) observerList.get(i)).update(this);
        }
    }

    public void setState(String act, String str) {
        if (act.equals("ADD")) {
            strVector.add(str);
        } else if (act.equals("DEL")) {
            strVector.remove(str);
        }
    }

    public Vector getState() {
        return strVector;
    }
}