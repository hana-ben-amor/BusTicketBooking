package com.example.busticketbooking.client.requests;

import java.io.Serializable;

import com.example.busticketbooking.client.models.Reservation;

public class PaymentRequest implements Serializable {
    private String clientName;
    private Reservation reservation;

    public PaymentRequest(String clientName, Reservation reservation) {
        this.clientName = clientName;
        this.reservation = reservation;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }
}
