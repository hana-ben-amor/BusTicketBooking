package com.example.busticketbooking.admin.responses;
import com.example.busticketbooking.client.models.Reservation;

public class BookingResponse {
    private Reservation reservation;

    public BookingResponse(Reservation reservation) {
        this.reservation = reservation;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }
}