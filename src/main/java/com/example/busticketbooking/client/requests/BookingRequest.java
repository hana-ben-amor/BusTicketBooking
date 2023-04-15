package com.example.busticketbooking.client.requests;

import java.io.Serializable;
import java.util.Arrays;

import com.example.busticketbooking.client.models.Bus;

public class BookingRequest implements Serializable {
    private String clientName;
    private Bus bus;
    private int[] seats;

    public BookingRequest(String clientName, Bus bus, int[] seats) {
        this.clientName = clientName;
        this.bus = bus;
        this.seats = seats;
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

    public int[] getSeats() {
        return seats;
    }

    public void setSeats(int[] seats) {
        this.seats = seats;
    }

    @Override
    public String toString() {
        return "BookingRequest [clientName=" + clientName + ", bus=" + bus + ", seats=" + Arrays.toString(seats) + "]";
    }
}

