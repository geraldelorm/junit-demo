package com.pluralsight.tddjunit5.database;

import com.pluralsight.tddjunit5.airport.*;

import java.util.ArrayList;
import java.util.List;

public class DatabaseUtil {

    private DatabaseUtil() {

    }

    public static List<Flight> buildFlightsList(List<List<String>> queriedData) {
        List<Flight> flightsList = new ArrayList<>();
        for (List<String> row: queriedData) {
            Flight flight;
            if (row.get(1).equals("e")) {
                flight = new EconomyFlight(row.get(0));
            } else if (row.get(1).equals("b")) {
                flight = new BusinessFlight(row.get(0));
            } else {
                flight = new PremiumFlight(row.get(0));
            }
            flight.addPassenger(new Passenger(row.get(2), Boolean.valueOf(row.get(3))));
            flight.setDistance(Integer.valueOf(row.get(4)));
            flightsList.add(flight);
        }
        return flightsList;
    }
}
