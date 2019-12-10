package com.example.personalfinance;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private ArrayList<Event> eventList;
    private String accountName;
    private double accountTotal;

    public Account(String aName, double aTotal) {
        accountName = aName;
        accountTotal = aTotal;
        eventList = new ArrayList<Event>();
    }
    public void addEvent(double a, String e, String date) {
        Event temp = new Event(a, e, date);
        eventList.add(temp);
        accountTotal = accountTotal + a;
    }
    public void addEvent(Event e) {
        eventList.add(e);
        accountTotal = accountTotal + e.getAmount();
    }
    public void removeEvent(double a, String e, String d) {
        for (int i = 0; i < eventList.size(); i++) {
            if (eventList.get(i).getAmount() == a && eventList.get(i).getEventType().equals(e)
                && eventList.get(i).getDate().equals(d)) {
                eventList.remove(i);
                break;
            }
        }
        accountTotal = accountTotal - a;
    }
    public void removeEvent(Event e) {
        for (int i = 0; i < eventList.size(); i++) {
            if (eventList.get(i) == e) {
                eventList.remove(i);
                break;
            }
        }
        accountTotal = accountTotal - e.getAmount();
    }
    public void setAccountName(String aName) {
        accountName = aName;
    }
    public String getAccountName() {
        return accountName;
    }
    public double getAccountTotal() {
        return accountTotal;
    }
    public ArrayList<Event> getEventList() {
        return eventList;
    }
}
