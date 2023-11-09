package model;

public class Reservation {
    private int reserv_id;
    private String carnum;
    private int cuid;
    private String parkdate;
    private String cuname; 

    

    public Reservation(int reserv_id, String carnum, int cuid, String cuname, String parkdate) {
        this.reserv_id = reserv_id;
        this.carnum = carnum;
        this.cuid = cuid;
        this.cuname = cuname;
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
    
 // customerName��getter�i�擾�p���\�b�h�j
    public String getCustomerName() {
        return cuname;
    }

    // customerName��setter�i�ݒ�p���\�b�h�j
    public void setCustomerName(String cuname) {
        this.cuname = cuname;
    }
}

