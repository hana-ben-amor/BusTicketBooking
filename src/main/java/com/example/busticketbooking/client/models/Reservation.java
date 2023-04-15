package com.example.busticketbooking.client.models;

public class Reservation {
    private String clientName;
    private Bus bus;
    private int[] reservedSeats;
    private boolean isPaid;

    public Reservation(String clientName, Bus bus, int[] reservedSeats, boolean isPaid) {
        this.clientName = clientName;
        this.bus = bus;
        this.reservedSeats = reservedSeats;
        this.isPaid = isPaid;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }

    public int[] getReservedSeats() {
        return reservedSeats;
    }

    public void setReservedSeats(int[] reservedSeats) {
        this.reservedSeats = reservedSeats;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }
}

