package com.example.Restaurant.models;

public class ReservationDTO {

    private Integer customerID;
    private Integer restaurantID;
	private Integer partySize;
	private String reservationTime;
	private String reservationDate;
	
    public ReservationDTO() {
		super();
	}
	public ReservationDTO(Integer customerID, Integer restaurantID, Integer partySize, String reservationTime, String reservationDate) {
		super();
        this.customerID = customerID;
        this.restaurantID = restaurantID;
        this.partySize = partySize;
        this.reservationTime = reservationTime;
        this.reservationDate = reservationDate;
	}
    
    public String getReservationDate() {
		return reservationDate;
	}
	public void setReservationDate(String reservationDate) {
		this.reservationDate = reservationDate;
	}
	public Integer getCustomerID() {
        return customerID;
    }
    
    public void setCustomerID(Integer customerID) {
        this.customerID = customerID;
    }
    
    public Integer getRestaurantID() {
        return restaurantID;
    }
    
    public void setRestaurantID(Integer restaurantID) {
        this.restaurantID = restaurantID;
    }
    
    public Integer getPartySize() {
        return partySize;
    }
    
    public void setPartySize(Integer partySize) {
        this.partySize = partySize;
    }
    
    public String getReservationTime() {
        return reservationTime;
    }
    
    public void setReservationTime(String reservationTime) {
        this.reservationTime = reservationTime;
    }
}
