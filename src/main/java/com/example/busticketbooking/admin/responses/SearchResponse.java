package com.example.busticketbooking.admin.responses;
import com.example.busticketbooking.admin.models.BusRoute;
import com.example.busticketbooking.client.models.Bus;

import java.util.List;

public class SearchResponse {
    private List<Bus> buses;
    private List<BusRoute> busRoutes;

    public SearchResponse(List<Bus> buses, List<BusRoute> busRoutes) {
        this.buses = buses;
        this.busRoutes = busRoutes;
    }

    public List<Bus> getBuses() {
        return buses;
    }

    public void setBuses(List<Bus> buses) {
        this.buses = buses;
    }

    public List<BusRoute> getBusRoutes() {
        return busRoutes;
    }

    public void setBusRoutes(List<BusRoute> busRoutes) {
        this.busRoutes = busRoutes;
    }
}
