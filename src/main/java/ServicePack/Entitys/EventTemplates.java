package ServicePack.Entitys;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by alex on 07.04.17.
 */
@Entity
@Table(name = "event_templates", schema = "public")
public class EventTemplates {
    @Id
    @GeneratedValue
    public Integer                     id;

    public Integer              daynumber;
    public Date                      date;

    public String                    type;
    public Timestamp                  gmt;
    public String                  lnglat;
    public Float                className;
    public Float                magnitude;
    public String             observatory;
    public String       nearestsettlement;
    public String              objectname;
    public Float          explosiveamount;
    public Timestamp            starttime;
    public Integer                 length;
    public Integer             samplerate;
    public String                    data;
    public String                comments;
    public String                     uid;
    public String                channels;
    public String             networkcode;
    public String               stationid;
    public String              locationid;

    @ManyToOne
//    @JoinColumn(name = "stationid", referencedColumnName = "stationid")
    public StationsInfo stationsInfo;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDaynumber() {
        return daynumber;
    }

    public void setDaynumber(Integer daynumber) {
        this.daynumber = daynumber;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Timestamp getGmt() {
        return gmt;
    }

    public void setGmt(Timestamp gmt) {
        this.gmt = gmt;
    }

    public String getLnglat() {
        return lnglat;
    }

    public void setLnglat(String lnglat) {
        this.lnglat = lnglat;
    }

    public Float getClassName() {
        return className;
    }

    public void setClassName(Float className) {
        this.className = className;
    }

    public Float getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(Float magnitude) {
        this.magnitude = magnitude;
    }

    public String getObservatory() {
        return observatory;
    }

    public void setObservatory(String observatory) {
        this.observatory = observatory;
    }

    public String getNearestsettlement() {
        return nearestsettlement;
    }

    public void setNearestsettlement(String nearestsettlement) {
        this.nearestsettlement = nearestsettlement;
    }

    public String getObjectname() {
        return objectname;
    }

    public void setObjectname(String objectname) {
        this.objectname = objectname;
    }

    public Float getExplosiveamount() {
        return explosiveamount;
    }

    public void setExplosiveamount(Float explosiveamount) {
        this.explosiveamount = explosiveamount;
    }

    public Timestamp getStarttime() {
        return starttime;
    }

    public void setStarttime(Timestamp starttime) {
        this.starttime = starttime;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Integer getSamplerate() {
        return samplerate;
    }

    public void setSamplerate(Integer samplerate) {
        this.samplerate = samplerate;
    }

    public String getData() {

        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getChannels() {
        return channels;
    }

    public void setChannels(String channels) {
        this.channels = channels;
    }

    public String getNetworkcode() {
        return networkcode;
    }

    public void setNetworkcode(String networkcode) {
        this.networkcode = networkcode;
    }

    public String getStationid() {
        return stationid;
    }

    public void setStationid(String stationid) {
        this.stationid = stationid;
    }

    public String getLocationid() {
        return locationid;
    }

    public void setLocationid(String locationid) {
        this.locationid = locationid;
    }

    public StationsInfo getStationsInfo() {
        return stationsInfo;
    }

    public void setStationsInfo(StationsInfo stationsInfo) {
        this.stationsInfo = stationsInfo;
    }
}
