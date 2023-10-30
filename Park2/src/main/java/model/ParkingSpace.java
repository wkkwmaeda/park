package model;

public class ParkingSpace {
    private int parkingNumber;
    private String carNumber;
    private String status;
    private String name;
    private String coDate;

    public ParkingSpace(int parkingNumber, String carNumber, String status, String name, String coDate) {
        this.parkingNumber = parkingNumber;
        this.carNumber = carNumber;
        this.status = status;
        this.name = name;
        this.coDate = coDate;
    }

    public int getParkingNumber() {
        return parkingNumber;
    }

    public void setParkingNumber(int parkingNumber) {
        this.parkingNumber = parkingNumber;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCoDate() {
        return coDate;
    }

    public void setCoDate(String coDate) {
        this.coDate = coDate;
    }
}
