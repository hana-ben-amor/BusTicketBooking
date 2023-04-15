package com.example.busticketbooking.client;

import com.example.busticketbooking.client.models.Bus;
import com.example.busticketbooking.client.models.Reservation;
import com.example.busticketbooking.client.requests.SearchRequest;
import com.example.busticketbooking.client.requests.BookingRequest;
import com.example.busticketbooking.client.requests.PaymentRequest;
import com.example.busticketbooking.admin.responses.SearchResponse;
import com.example.busticketbooking.admin.responses.BookingResponse;
import com.example.busticketbooking.admin.responses.PaymentResponse;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

public class SocketClient {
    private Socket socket;
    private ObjectOutputStream out;
    private ObjectInputStream in;

    public SocketClient(String serverAddress, int serverPort) {
        try {
            socket = new Socket(serverAddress, serverPort);
            out = new ObjectOutputStream(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void send(Object object) {
        try {
            out.writeObject(object);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Object receive() {
        Object object = null;
        try {
            object = in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return object;
    }

    public void close() {
        try {
            in.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Bus> searchBuses(String departure, String arrival, String date) {
        // Create a search request object
        SearchRequest request = new SearchRequest(departure, arrival, date);

        // Send the request to the server
        send(request);

        // Receive the search results from the server
        SearchResponse response = (SearchResponse) receive();

        // Return the list of buses
        return response.getBuses();
    }

    public Reservation bookSeats(String clientName, Bus bus, int[] seats) {
        // Create a booking request object
        BookingRequest request = new BookingRequest(clientName, bus, seats);

        // Send the request to the server
        send(request);

        // Receive the booking confirmation from the server
        BookingResponse confirmation = (BookingResponse) receive();

        // Return the reservation
        return confirmation.getReservation();
    }

    public boolean payReservation(String clientName, Reservation reservation) {
        // Create a payment request object
        PaymentRequest request = new PaymentRequest(clientName, reservation);

        // Send the request to the server
        send(request);

        // Receive the payment confirmation from the server
        PaymentResponse confirmation = (PaymentResponse) receive();

        // Return the payment status
        return confirmation.isPaymentSuccessful();
    }

}
