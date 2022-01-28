package com.pluralsight.tddjunit5.milage;

import com.pluralsight.tddjunit5.airport.Passenger;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Milage {

    public static final int VIP_FACTOR = 10;
    public static final int USUAL_FACTOR = 20;

    private Map<Passenger, Integer> passengersMilageMap = new HashMap<>();
    private Map<Passenger, Integer> passengersPointsMap = new HashMap<>();

    public Map<Passenger, Integer> getPassengersPointsMap() {
        return Collections.unmodifiableMap(passengersPointsMap);
    }

    public void addMilage(Passenger passenger, int miles) {
        if (passengersMilageMap.containsKey(passenger)) {
            passengersMilageMap.put(passenger, passengersMilageMap.get(passenger) + miles);
        } else {
            passengersMilageMap.put(passenger, miles);
        }
    }

    public void calculateGivenPoints() {
        for (Passenger passenger : passengersMilageMap.keySet()) {
            if (passenger.isVip()) {
                passengersPointsMap.put(passenger, passengersMilageMap.get(passenger)/ VIP_FACTOR);
            } else {
                passengersPointsMap.put(passenger, passengersMilageMap.get(passenger)/ USUAL_FACTOR);
            }
        }
    }

}
