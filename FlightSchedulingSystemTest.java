package Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import Main.Airport;
import Main.Flight;

public class FlightSchedulingSystemTest {

    @Test
    public void testAddFlight() {
        Airport airport = new Airport("Airport1");
        Flight flight = new Flight("ABC123", "Airport1", "Airport2", "10:00", "12:00");
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
        Flight flight = new Flight("DEF456", "Airport2", "Airport1", "14:00", "16:00");
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
        Airport airport = new Airport("Airport1");
        Flight flight1 = new Flight("ABC123", "Airport1", "Airport2", "10:00", "12:00");
        Flight flight2 = new Flight("DEF456", "Airport2", "Airport1", "14:00", "16:00");
        airport.addFlight(flight1);
        airport.addFlight(flight2);

        // Redirect stdout for testing display output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        
        airport.displaySchedule();

        // Reset stdout
        System.setOut(System.out);

        String expectedOutput = "Flight schedule for Airport1:\n" +
                                "Flight ABC123: Departure: Airport1 - Destination: Airport2 | Departure Time: 10:00 - Arrival Time: 12:00\n" +
                                "Flight DEF456: Departure: Airport2 - Destination: Airport1 | Departure Time: 14:00 - Arrival Time: 16:00\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    private void assertEquals(String expectedOutput, String string) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'assertEquals'");
    }
}
