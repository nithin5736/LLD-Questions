package model;

public class Cab {
    private String cabId;
    private String driverName;
    private double x;
    private double y;
    private boolean available;

    public Cab(String cabId, String driverName, double x, double y) {
        this.cabId = cabId;
        this.driverName = driverName;
        this.x = x;
        this.y = y;
        this.available = true;
    }

    public String getCabId(){
        return this.cabId;
    }

    public String getDriverName(){
        return this.driverName;
    } 

    public double getX(){
        return this.x;
    }

    public double getY(){
        return this.y;
    }

    public boolean isAvailable() {
        return this.available;
    }

    public void setLocation(double x, double y){
        this.x = x;
        this.y = y;
    }

    public void setAvailable(boolean available){
        this.available = available;
    }
}
