package Main;

import java.util.ArrayList;
import java.util.List;

public class Airport {
    private String name;
    private List<Flight> flights;

    public Airport(String name) {
        this.name = name;
        this.flights = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addFlight(Flight flight) {
        flights.add(flight);
    }

    public void removeFlight(Flight flight) {
        flights.remove(flight);
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public void displaySchedule() {
        System.out.println("Flight schedule for " + name + ":");
        for (Flight flight : flights) {
            System.out.println(flight);
        }
    }
}
