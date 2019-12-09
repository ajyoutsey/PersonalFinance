package com.example.personalfinance;

public class Event {
    private double amount;
    private String eventType;
    private String date;

    public Event(double a, String e, String d) {
        amount = a;
        eventType = e;
        date = d;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
    public void setDate(String d) {
        this.date = d;
    }

    public String getEventType() {
        return eventType;
    }
    public double getAmount() {
        return amount;
    }
    public String getDate() {
        return date;
    }
}
