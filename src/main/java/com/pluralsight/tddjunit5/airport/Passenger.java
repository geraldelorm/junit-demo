package com.pluralsight.tddjunit5.airport;

import java.util.Objects;

public class Passenger {
	private String name;
	private boolean vip;

    public Passenger(String name, boolean vip) {
		this.name = name;
		this.vip = vip;
	}

	public String getName() {
		return name;
	}

	public boolean isVip() {
		return vip;
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Passenger passenger = (Passenger) o;
        return Objects.equals(name, passenger.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name);
    }

}
