package de.kirils.ghostnet.ghostnetfallstudie.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import  jakarta.persistence.*;
import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity(name = "GhostNet")
public class GhostNet {

    @Id
    @SequenceGenerator(
            name = "ghostNet_sequence",
            sequenceName = "ghostNet_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "ghostNet_sequence"
    )
    private Long id;
    private double gpsLat;
    private double gpsLon;
    private double sizeEstimate;
    private String reportedAt;
    private Long bergendePerson;
    private NetStatus netStatus;

    public GhostNet(double gpsLat, Long id, double gpsLon, double sizeEstimate, String reportedAt, Long bergendePerson, NetStatus netStatus) {
        this.gpsLat = gpsLat;
        this.id = id;
        this.gpsLon = gpsLon;
        this.sizeEstimate = sizeEstimate;
        this.reportedAt = reportedAt;
        this.bergendePerson = bergendePerson;
        this.netStatus = netStatus;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getReportedAt() {
        return reportedAt;
    }

    public void setReportedAt(String reportedAt) {
        this.reportedAt = reportedAt;
    }

    public Long getBergendePerson() {
        return bergendePerson;
    }

    public void setBergendePerson(Long bergendePerson) {
        this.bergendePerson = bergendePerson;
    }

    public NetStatus getNetStatus() {
        return netStatus;
    }

    public void setNetStatus(NetStatus netStatus) {
        this.netStatus = netStatus;
    }
}
