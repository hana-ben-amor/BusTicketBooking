package com.example.busticketbooking.admin.models;
public class AdminReservation {
    private String clientName;
    private String clientEmail;
    private String clientPhone;
    private BusRoute busRoute;
    private int[] reservedSeats;
    private double paymentAmount;
    private boolean isPaid;

    public AdminReservation(String clientName, String clientEmail, String clientPhone, BusRoute busRoute,
                            int[] reservedSeats, double paymentAmount, boolean isPaid) {
        this.clientName = clientName;
        this.clientEmail = clientEmail;
        this.clientPhone = clientPhone;
        this.busRoute = busRoute;
        this.reservedSeats = reservedSeats;
        this.paymentAmount = paymentAmount;
        this.isPaid = isPaid;
    }

    // getters and setters

    public String getClientName() {
        return clientName;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public String getClientPhone() {
        return clientPhone;
    }

    public BusRoute getBusRoute() {
        return busRoute;
    }

    public Object[] getReservedSeats() {
        return new int[][]{reservedSeats};
    }

    public double getPaymentAmount() {
        return paymentAmount;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    public void setClientPhone(String clientPhone) {
        this.clientPhone = clientPhone;
    }

    public void setBusRoute(BusRoute busRoute) {
        this.busRoute = busRoute;
    }

    public void setReservedSeats(int[] reservedSeats) {
        this.reservedSeats = reservedSeats;
    }

    public void setPaymentAmount(double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }
}