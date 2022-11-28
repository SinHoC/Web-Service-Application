package com.TeamTemple.TTempleProject;

import java.util.HashMap;
import java.util.List;

public class Order {

	private String orderNumber;
	private String name;
	private String phoneNumber;
	private String restaurant;
	private String pickup;
	private String arrival;
	private String location;
	private HashMap<String, List<String>> customers;

	public Order(String orderNumber, String name, String phoneNumber, String restaurant, String pickup, String arrival, String location, HashMap<String, List<String>> customers) {
		this.orderNumber = orderNumber;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.restaurant = restaurant;
		this.pickup = pickup;
		this.arrival = arrival;
		this.location = location;
		this.customers = customers;
	}
	
	public Order() {
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(String restaurant) {
		this.restaurant = restaurant;
	}

	public String getPickup() {
		return pickup;
	}

	public void setPickup(String pickup) {
		this.pickup = pickup;
	}

	public String getArrival() {
		return arrival;
	}

	public void setArrival(String arrival) {
		this.arrival = arrival;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public HashMap<String, List<String>> getCustomers() {
		return customers;
	}

	public void setCustomers(HashMap<String, List<String>> customers) {
		this.customers = customers;
	}

}
