package com.example.busticketbooking.database;

import com.example.busticketbooking.admin.models.AdminReservation;
import com.example.busticketbooking.admin.models.BusRoute;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler {
    //DATABASE CONFIGURATION
    private static DatabaseHandler instance;
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/bus_ticket_booking";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "password";

    private Connection conn = null;

    public void connectToDatabase() throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);
        System.out.println("Connecting to database...");
        conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
        System.out.println("Connected to database successfully!");
    }

    public void closeDatabaseConnection(Connection conn) {
        try {
            conn.close();
        } catch (SQLException e) {
            System.err.println("Error closing database connection: " + e.getMessage());
        }
    }
    public static synchronized DatabaseHandler getInstance() {
        if (instance == null) {
            instance = new DatabaseHandler();
        }
        return instance;
    }

    //Authentification
    public boolean validateAdminLogin(String username, String password) {
        try (Connection connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD)) {
            String sql = "SELECT * FROM admins WHERE username = ? AND password = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    //CRUD Bus routes
    public List<BusRoute> getAllBusRoutes() {
        List<BusRoute> busRoutes = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(DB_URL,USERNAME, PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM bus_routes");
            while (resultSet.next()) {
                BusRoute busRoute = new BusRoute(
                        resultSet.getInt("route_number"),
                        resultSet.getString("departure_point"),
                        resultSet.getString("arrival_point"),
                        resultSet.getString("schedule"),
                        resultSet.getInt("available_seats")
                );
                busRoutes.add(busRoute);
            }
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return busRoutes;
    }

    public boolean addBusRoute(BusRoute busRoute) {
        boolean success = false;
        try {
            Connection connection = DriverManager.getConnection(DB_URL, USERNAME,PASSWORD);
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO bus_routes (route_number, departure_point, arrival_point, schedule, available_seats) VALUES (?, ?, ?, ?, ?)"
            );
            statement.setInt(1, busRoute.getRouteNumber());
            statement.setString(2, busRoute.getDeparturePoint());
            statement.setString(3, busRoute.getArrivalPoint());
            statement.setString(4, busRoute.getSchedule());
            statement.setInt(5, busRoute.getAvailableSeats());
            int rowsAffected = statement.executeUpdate();
            success = rowsAffected == 1;
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return success;
    }

    public boolean updateBusRoute(BusRoute busRoute) {
        boolean success = false;
        try {
            Connection connection = DriverManager.getConnection(DB_URL, USERNAME,PASSWORD);
            PreparedStatement statement = connection.prepareStatement(
                    "UPDATE bus_routes SET departure_point = ?, arrival_point = ?, schedule = ?, available_seats = ? WHERE route_number = ?"
            );
            statement.setString(1, busRoute.getDeparturePoint());
            statement.setString(2, busRoute.getArrivalPoint());
            statement.setString(3, busRoute.getSchedule());
            statement.setInt(4, busRoute.getAvailableSeats());
            statement.setInt(5, busRoute.getRouteNumber());
            int rowsAffected = statement.executeUpdate();
            success = rowsAffected == 1;
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return success;
    }

    public boolean deleteBusRoute(BusRoute busRoute) {
        boolean success = false;
        try {
            Connection connection = DriverManager.getConnection(DB_URL, USERNAME,PASSWORD);
            PreparedStatement statement = connection.prepareStatement(
                    "DELETE FROM bus_routes WHERE route_number = ?"
            );
            statement.setInt(1, busRoute.getRouteNumber());
            int rowsAffected = statement.executeUpdate();
            success = rowsAffected == 1;
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return success;
    }


    //CRUD AdminReservation
    public boolean addAdminReservation(AdminReservation adminReservation) {
        try (Connection connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD)) {
            String sql = "INSERT INTO admin_reservations(client_name, client_email, client_phone, route_number, reserved_seats, payment_amount, is_paid) VALUES(?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, adminReservation.getClientName());
            statement.setString(2, adminReservation.getClientEmail());
            statement.setString(3, adminReservation.getClientPhone());
            statement.setInt(4, adminReservation.getBusRoute().getRouteNumber());
            statement.setString(5, convertReservedSeatsToString(adminReservation.getReservedSeats()));
            statement.setDouble(6, adminReservation.getPaymentAmount());
            statement.setBoolean(7, adminReservation.isPaid());
            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    public boolean updateAdminReservation(AdminReservation adminReservation) {
        try (Connection connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD)) {
            String sql = "UPDATE admin_reservations SET client_name=?, client_email=?, client_phone=?, route_number=?, reserved_seats=?, payment_amount=?, is_paid=? WHERE client_email=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, adminReservation.getClientName());
            statement.setString(2, adminReservation.getClientEmail());
            statement.setString(3, adminReservation.getClientPhone());
            statement.setInt(4, adminReservation.getBusRoute().getRouteNumber());
            statement.setString(5, convertReservedSeatsToString(adminReservation.getReservedSeats()));
            statement.setDouble(6, adminReservation.getPaymentAmount());
            statement.setBoolean(7, adminReservation.isPaid());
            statement.setString(8, adminReservation.getClientEmail());
            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private String convertReservedSeatsToString(Object[] reservedSeats) {
        if (reservedSeats == null || reservedSeats.length == 0) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        for (Object seat : reservedSeats) {
            sb.append(seat.toString()).append(",");
        }

        // Remove the trailing comma
        sb.setLength(sb.length() - 1);

        return sb.toString();
    }


    public boolean deleteAdminReservation(AdminReservation adminReservation) {
        try (Connection connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD)) {
            String sql = "DELETE FROM admin_reservations WHERE client_email=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, adminReservation.getClientEmail());
            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<AdminReservation> getAllAdminReservations() {
        List<AdminReservation> adminReservations = new ArrayList<>();

        try {
            // Connect to database
            connectToDatabase();

            // Execute SQL query to get all admin reservations
            String sql = "SELECT * FROM admin_reservations";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // Loop through the result set and create AdminReservation objects
            while (rs.next()) {
                String clientName = rs.getString("client_name");
                String clientEmail = rs.getString("client_email");
                String clientPhone = rs.getString("client_phone");
                int routeNumber = rs.getInt("route_number");
                String departurePoint = rs.getString("departure_point");
                String arrivalPoint = rs.getString("arrival_point");
                String schedule = rs.getString("schedule");
                int availableSeats = rs.getInt("available_seats");
                BusRoute busRoute = new BusRoute(routeNumber, departurePoint, arrivalPoint, schedule, availableSeats);
                String reservedSeatsString = rs.getString("reserved_seats");
                String[] reservedSeatsArray = reservedSeatsString.split(",");
                int[] reservedSeats = new int[reservedSeatsArray.length];
                for (int i = 0; i < reservedSeatsArray.length; i++) {
                    reservedSeats[i] = Integer.parseInt(reservedSeatsArray[i]);
                }
                double paymentAmount = rs.getDouble("payment_amount");
                boolean isPaid = rs.getBoolean("is_paid");

                AdminReservation adminReservation = new AdminReservation(clientName, clientEmail, clientPhone, busRoute, reservedSeats, paymentAmount, isPaid);
                adminReservations.add(adminReservation);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            // Close the database connection
            closeDatabaseConnection(conn);
        }

        return adminReservations;
    }



}

