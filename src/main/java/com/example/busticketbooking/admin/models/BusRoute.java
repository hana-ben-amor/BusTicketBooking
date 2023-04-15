package com.example.busticketbooking.admin.models;

public class BusRoute {
    private int routeNumber;
    private String departurePoint;
    private String arrivalPoint;
    private String schedule;
    private int availableSeats;

    public BusRoute(int routeNumber, String departurePoint, String arrivalPoint, String schedule, int availableSeats) {
        this.routeNumber = routeNumber;
        this.departurePoint = departurePoint;
        this.arrivalPoint = arrivalPoint;
        this.schedule = schedule;
        this.availableSeats = availableSeats;
    }

    // Getters and setters
    public int getRouteNumber() {
        return routeNumber;
    }

    public void setRouteNumber(int routeNumber) {
        this.routeNumber = routeNumber;
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







