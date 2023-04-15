package com.example.busticketbooking.client.requests;

import java.io.Serializable;

public class SearchRequest implements Serializable {
    private String departure;
    private String arrival;
    private String date;

    public SearchRequest(String departure, String arrival, String date) {
        this.departure = departure;
        this.arrival = arrival;
        this.date = date;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
