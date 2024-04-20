package Main;

public class Flight {
    private String flightNumber;
    private String departureAirport;
    private String destinationAirport;
    private String departureTime;
    private String arrivalTime;

    public Flight(String flightNumber, String departureAirport, String destinationAirport, String departureTime, String arrivalTime) {
        this.flightNumber = flightNumber;
        this.departureAirport = departureAirport;
        this.destinationAirport = destinationAirport;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public String getDestinationAirport() {
        return destinationAirport;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    @Override
    public String toString() {
        return "Flight " + flightNumber + ": Departure: " + departureAirport + " - Destination: " + destinationAirport +
                " | Departure Time: " + departureTime + " - Arrival Time: " + arrivalTime;
    }
}
