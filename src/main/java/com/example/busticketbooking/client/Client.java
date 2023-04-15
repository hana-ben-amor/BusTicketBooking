package com.example.busticketbooking.client;

import com.example.busticketbooking.client.models.Bus;
import com.example.busticketbooking.client.models.Reservation;

import java.io.IOException;
import java.util.List;

public class Client {

    private final SocketClient socketClient;

    public Client(String host, int port) throws IOException {
        socketClient = new SocketClient(host, port);
    }

    public List<Bus> searchBuses(String departure, String arrival, String date) throws IOException, ClassNotFoundException {
        return socketClient.searchBuses(departure, arrival, date);
    }

    public Reservation bookSeats(String clientName, Bus bus, int[] seats) throws IOException, ClassNotFoundException {
        return socketClient.bookSeats(clientName, bus, seats);
    }

    public boolean payReservation(String clientName, Reservation reservation) throws IOException, ClassNotFoundException {
        return socketClient.payReservation(clientName, reservation);
    }

}
