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
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    @Column(
            name = "gps_lat",
            nullable = false
    )
    private double gpsLat;

    @Column(
            name = "gps_lon",
            nullable = false
    )
    private double gpsLon;

    @Column(
            name = "size_estimate",
            nullable = false
    )
    private double sizeEstimate;

    @Column(
            name = "reported_at",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String reportedAt;

    @Column(
            name = "bergende_person_ID",
            nullable = true
    )
    private Long bergendePersonID;

    @Column(
            name = "net_status",
            nullable = false
    )
    private NetStatus netStatus;

    public GhostNet(double gpsLat, double gpsLon, double sizeEstimate, String reportedAt, Long bergendePersonID, NetStatus netStatus) {
        this.gpsLat = gpsLat;
        //this.id = id;
        this.gpsLon = gpsLon;
        this.sizeEstimate = sizeEstimate;
        this.reportedAt = reportedAt;
        this.bergendePersonID = bergendePersonID;
        this.netStatus = netStatus;
    }

    //public GhostNet() {}


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

    public Long getbergendePersonID() {
        return bergendePersonID;
    }

    public void setbergendePersonID(Long bergendePersonID) {
        this.bergendePersonID = bergendePersonID;
    }

    public NetStatus getNetStatus() {
        return netStatus;
    }

    public void setNetStatus(NetStatus netStatus) {
        this.netStatus = netStatus;
    }
}
