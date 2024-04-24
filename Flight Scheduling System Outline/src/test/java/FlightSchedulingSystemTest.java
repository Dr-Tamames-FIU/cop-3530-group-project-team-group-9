package Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import Main.Airport;
import Main.Flight;

public class FlightSchedulingSystemTest {

    @Test
    public void testAddFlight() {
        Airport airport = new Airport("AirportM");
        Flight flight = new Flight("Spirit", "AirportM", "AirportE", "10:00", "12:00");
        airport.addFlight(flight);
        List<Flight> flights = airport.getFlights();
        assertTrue(flights.contains(flight));
    }

    private void assertTrue(boolean contains) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'assertTrue'");
    }

    @Test
    public void testRemoveFlight() {
        Airport airport = new Airport("Airport2");
        Flight flight = new Flight("DEF456", "AirportE", "AirportM", "13:00", "15:00");
        airport.addFlight(flight);
        airport.removeFlight(flight);
        List<Flight> flights = airport.getFlights();
        assertFalse(flights.contains(flight));
    }

    private void assertFalse(boolean contains) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'assertFalse'");
    }

    @Test
    public void testDisplaySchedule() {
        Airport airport = new Airport("AirportM");
        Flight flight1 = new Flight("Spirit", "AirportM", "AirportE", "10:00", "12:00");
        Flight flight2 = new Flight("Spirit2", "AirportE", "AirportM", "13:00", "15:00");
        airport.addFlight(flight1);
        airport.addFlight(flight2);

        // Redirect stdout for testing display output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        
        airport.displaySchedule();

        // Reset stdout
        System.setOut(System.out);

        String expectedOutput = "Flight schedule for AirportM:\n" +
                                "Flight Spirit: Departure: AirportM - Destination: AirportE | Departure Time: 10:00 - Arrival Time: 12:00\n" +
                                "Flight Spirit2: Departure: AirportE - Destination: AirportM | Departure Time: 13:00 - Arrival Time: 15:00\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    private void assertEquals(String expectedOutput, String string) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'assertEquals'");
    }
}
