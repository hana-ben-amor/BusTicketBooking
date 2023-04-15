package com.example.busticketbooking.admin.responses;


public class PaymentResponse {
    private boolean paymentSuccessful;

    public PaymentResponse(boolean paymentSuccessful) {
        this.paymentSuccessful = paymentSuccessful;
    }

    public boolean isPaymentSuccessful() {
        return paymentSuccessful;
    }

    public void setPaymentSuccessful(boolean paymentSuccessful) {
        this.paymentSuccessful = paymentSuccessful;
    }
}