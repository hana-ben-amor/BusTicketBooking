package com.example.busticketbooking.client.models;

public class Bus {
    private int busNumber;
    private String departurePoint;
    private String arrivalPoint;
    private String schedule;
    private int availableSeats;

    public Bus(int busNumber, String departurePoint, String arrivalPoint, String schedule, int availableSeats) {
        this.busNumber = busNumber;
        this.departurePoint = departurePoint;
        this.arrivalPoint = arrivalPoint;
        this.schedule = schedule;
        this.availableSeats = availableSeats;
    }

    // getters and setters
    public int getBusNumber() {
        return busNumber;
    }

    public void setBusNumber(int busNumber) {
        this.busNumber = busNumber;
    }

    public String getDeparturePoint() {
        return departurePoint;
    }

    public void setDeparturePoint(String departurePoint) {
        this.departurePoint = departurePoint;
    }

    public String getArrivalPoint() {
        return arrivalPoint;
    }

    public void setArrivalPoint(String arrivalPoint) {
        this.arrivalPoint = arrivalPoint;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }
}

