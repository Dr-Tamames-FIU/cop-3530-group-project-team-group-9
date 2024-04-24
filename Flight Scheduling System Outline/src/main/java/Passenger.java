package Main;

public class Passenger {
    private String name;
    private String contactInfo;
    private Flight flight;

    public Passenger(String name, String contactInfo) {
        this.name = name;
        this.contactInfo = contactInfo;
    }

    public String getName() {
        return name;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    @Override
    public String toString() {
        return "Passenger: " + name + " | Contact Info: " + contactInfo + " | Flight: " + flight;
    }
}
