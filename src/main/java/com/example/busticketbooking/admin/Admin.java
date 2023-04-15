package com.example.busticketbooking.admin;

import java.util.ArrayList;
import java.util.List;

import com.example.busticketbooking.admin.models.AdminReservation;
import com.example.busticketbooking.admin.models.BusRoute;
import com.example.busticketbooking.database.DatabaseHandler;

public class Admin {
    private String username;
    private String password;
    private DatabaseHandler dbHandler;

    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
        dbHandler = new DatabaseHandler();
    }

    public boolean authenticate() {
        // Perform authentication logic here, such as checking the credentials against a database
        // For simplicity, we'll just assume that the credentials are valid
        return true;
    }

    public List<BusRoute> getAllBusRoutes() {
        return (List<BusRoute>) dbHandler.getAllBusRoutes();
    }

    public List<AdminReservation> getAllReservations() {
        return dbHandler.getAllAdminReservations();
    }

    public boolean addBusRoute(BusRoute busRoute) {
        return dbHandler.addBusRoute(busRoute);
    }

    public boolean updateBusRoute(BusRoute busRoute) {
        return dbHandler.updateBusRoute(busRoute);
    }

    public boolean deleteBusRoute(BusRoute busRoute) {
        return dbHandler.deleteBusRoute(busRoute);
    }

    public boolean addAdminReservation(AdminReservation adminReservation) {
        return dbHandler.addAdminReservation(adminReservation);
    }

    public boolean updateAdminReservation(AdminReservation adminReservation) {
        return dbHandler.updateAdminReservation(adminReservation);
    }

    public boolean deleteAdminReservation(AdminReservation adminReservation) {
        return dbHandler.deleteAdminReservation(adminReservation);
    }
}