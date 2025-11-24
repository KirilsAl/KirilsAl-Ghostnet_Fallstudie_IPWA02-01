package de.kirils.ghostnet.ghostnetfallstudie.dto;

public class ReportNetForm {

    private double gpsLat;
    private double gpsLon;
    private double sizeEstimate;
    private String name;
    private String phone;

    public ReportNetForm() {
    }

    public double getGpsLat() {
        return gpsLat;
    }

    public void setGpsLat(double gpsLat) {
        this.gpsLat = gpsLat;
    }

    public double getGpsLon() {
        return gpsLon;
    }

    public void setGpsLon(double gpsLon) {
        this.gpsLon = gpsLon;
    }

    public double getSizeEstimate() {
        return sizeEstimate;
    }

    public void setSizeEstimate(double sizeEstimate) {
        this.sizeEstimate = sizeEstimate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
