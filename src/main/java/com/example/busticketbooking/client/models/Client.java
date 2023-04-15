package com.example.busticketbooking.client.models;

public class Client {
    private String client_name;
    private String client_email;
    private String client_phone;
    private String client_username;
    private String client_password;

    public Client(String name, String email, String phone, String username, String password) {
        this.client_name = name;
        this.client_email = email;
        this.client_phone = phone;
        this.client_username = username;
        this.client_password = password;
    }

    // getters and setters for all the fields

    public String getName() {
        return client_name;
    }

    public void setName(String name) {
        this.client_name = name;
    }

    public String getEmail() {
        return client_email;
    }

    public void setEmail(String email) {
        this.client_email = email;
    }

    public String getPhone() {
        return client_phone;
    }

    public void setPhone(String phone) {
        this.client_phone = phone;
    }

    public String getUsername() {
        return client_username;
    }

    public void setUsername(String username) {
        this.client_username = username;
    }

    public String getPassword() {
        return client_password;
    }

    public void setPassword(String password) {
        this.client_password = password;
    }
}