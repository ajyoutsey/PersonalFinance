package com.example.personalfinance;

public class Event {
    private double amount;
    private String eventType;

    public Event(double a, String e) {
        amount = a;
        eventType = e;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getEventType() {
        return eventType;
    }
    public double getAmount() {
        return amount;
    }
}
