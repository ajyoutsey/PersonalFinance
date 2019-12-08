package com.example.personalfinance;

import java.util.List;

public class Account {
    private List<Event> eventList;
    private String accountName;
    private double accountTotal;

    public Account(String aName, double aTotal) {
        accountName = aName;
        accountTotal = aTotal;
    }
    public void addEvent(double a, String e) {
        Event temp = new Event(a, e, 1);
        eventList.add(temp);
        accountTotal = accountTotal + a;
    }
    public void addEvent(Event e) {
        eventList.add(e);
    }
    public void removeEvent(double a, String e) {
        for (int i = 0; i < eventList.size(); i++) {
            if (eventList.get(i).getAmount() == a && eventList.get(i).getEventType().equals(e)) {
                eventList.remove(i);
                return;
            }
        }
        accountTotal = accountTotal - a;
    }
    public void setAccountName(String aName) {
        accountName = aName;
    }
}
