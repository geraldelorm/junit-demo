package com.pluralsight.tddjunit5.milage;

import com.pluralsight.tddjunit5.airport.*;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FlightArgumentConverter extends SimpleArgumentConverter {
    @Override
    protected Object convert(Object source, Class<?> targetType) {
        assertEquals(String.class, source.getClass(), "Can only convert from String");
        assertEquals(Flight.class, targetType, "Can only convert to Flight");

        String[] flightString = source.toString().split(";");
        Flight flight = null;

        switch (flightString[1].toLowerCase().trim()) {
            case "b" : flight = new BusinessFlight(flightString[0]);
                break;
            case "p" : flight = new PremiumFlight(flightString[0]);
                break;
            case "e" : flight = new EconomyFlight(flightString[0]);
                break;
        }

        flight.addPassenger(new Passenger(flightString[2].trim(), Boolean.valueOf(flightString[3].trim())));
        flight.setDistance(Integer.valueOf(flightString[4].trim()));

        return flight;
    }
}
