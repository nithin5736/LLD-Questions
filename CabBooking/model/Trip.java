package model;

public class Trip {
    private String tripId;
    private Cab cab;
    private User user;
    private double originX, originY;
    private double destX, destY;
    private boolean completed;

    public Trip(String tripId, Cab cab, User user, double originX, double originY, double destX, double destY){
        this.tripId = tripId;
        this.cab = cab;
        this.user = user;
        this.originX = originX;
        this.originY = originY;
        this.destX = destX;
        this.destY = destY;
        this.completed = false;
    }

    public String getTripId() {
        return this.tripId;
    }

    public Cab getCab() {
        return this.cab;
    }

    public User getUser(){
        return this.user;
    }

    public boolean isCompleted(){
        return this.completed;
    }

    public void completeTrip(){
        this.completed = true;
        cab.setAvailable(true);
        cab.setLocation(destX, destY);
    }
}
