package model;

public class Reservation {
    private int reserv_id;
    private String carnum;
    private int cuid;
    private String parkdate;

    public Reservation(int reserv_id, String carnum, int cuid, String parkdate) {
        this.reserv_id = reserv_id;
        this.carnum = carnum;
        this.cuid = cuid;
        this.parkdate = parkdate;
    }

    public int getReserv_id() {
        return reserv_id;
    }

    public void setReserv_id(int reserv_id) {
        this.reserv_id = reserv_id;
    }

    public String getCarnum() {
        return carnum;
    }

    public void setCarnum(String carnum) {
        this.carnum = carnum;
    }

    public int getCuid() {
        return cuid;
    }

    public void setCuid(int cuid) {
        this.cuid = cuid;
    }

    public String getParkdate() {
        return parkdate;
    }

    public void setParkdate(String parkdate) {
        this.parkdate = parkdate;
    }
}

