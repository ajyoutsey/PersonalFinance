package com.example.personalfinance;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private static ArrayList<Event> eventList;
    private String accountName;
    private static double accountTotal;

    public Account(String aName, double aTotal) {
        accountName = aName;
        accountTotal = aTotal;
        eventList = new ArrayList<Event>();
    }
    public static void addEvent(double a, String e, int date) {
        Event temp = new Event(a, e, date);
        eventList.add(temp);
        accountTotal = accountTotal + a;
    }
    public static void addEvent(Event e) {
        eventList.add(e);
    }
    public static void removeEvent(double a, String e) {
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
    public String getAccountName() {
        return accountName;
    }
    public double getAccountTotal() {
        return accountTotal;
    }
    public static ArrayList<Event> getEventList() {
        return eventList;
    }
}
