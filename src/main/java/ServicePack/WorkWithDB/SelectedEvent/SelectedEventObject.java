package ServicePack.WorkWithDB.SelectedEvent;

import ServicePack.WorkWithDB.EventObject;
import ServicePack.WorkWithDB.RandomEvent.RandomEventObject;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.sql.*;
import java.util.List;

/**
 * Created by oshchepkovayu on 12.04.17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SelectedEventObject implements EventObject<SelectedEventObject>{

    private Integer                     id;

    private Integer              daynumber;
    private Date                      date;

    private String                    type;
    private Timestamp gmt;
    private String                  lnglat;
    private Float                className;
    private Float                magnitude;
    private String             observatory;
    private String       nearestsettlement;
    private String              objectname;
    private Float          explosiveamount;
    private Timestamp            starttime;
    private Integer                 length;
    private Integer             samplerate;
    private String                    data;
    private String                comments;
    private String                     uid;
    private String                channels;
    private String             networkcode;
    private String               stationid;
    private String              locationid;

    private List<Double>        standardizedCombination;

    private double[][]          dataAsDouble;

    private double              corelation;

    public SelectedEventObject(){}

    public Integer getId() {
        return id;
    }

    public SelectedEventObject setId(Integer id) {
        this.id = id;
        return this;
    }
    @Override
    public Integer getDaynumber() {
        return daynumber;
    }
    @Override
    public SelectedEventObject setDaynumber(Integer daynumber) {
        this.daynumber = daynumber;
        return this;
    }
    @Override
    public Date getDate() {
        return date;
    }
    @Override
    public SelectedEventObject setDate(Date date) {
        this.date = date;
        return this;
    }
    @Override
    public String getType() {
        return type;
    }

    @Override
    public SelectedEventObject setType(String type) {
        this.type = type;
        return this;
    }

    @Override
    public Timestamp getGmt() {
        return gmt;
    }

    @Override
    public SelectedEventObject setGmt(Timestamp gmt) {
        this.gmt = gmt;
        return this;
    }

    @Override
    public String getLnglat() {
        return lnglat;
    }

    @Override
    public SelectedEventObject setLnglat(String lnglat) {
        this.lnglat = lnglat;
        return this;
    }

    @Override
    public Float getClassName() {
        return className;
    }

    @Override
    public SelectedEventObject setClassName(Float className) {
        this.className = className;
        return this;
    }

    @Override
    public Float getMagnitude() {
        return magnitude;
    }

    @Override
    public SelectedEventObject setMagnitude(Float magnitude) {
        this.magnitude = magnitude;
        return this;
    }

    @Override
    public String getObservatory() {
        return observatory;
    }

    @Override
    public SelectedEventObject setObservatory(String observatory) {
        this.observatory = observatory;
        return this;
    }

    @Override
    public String getNearestsettlement() {
        return nearestsettlement;
    }

    @Override
    public SelectedEventObject setNearestsettlement(String nearestsettlement) {
        this.nearestsettlement = nearestsettlement;
        return this;
    }

    @Override
    public String getObjectname() {
        return objectname;
    }

    @Override
    public SelectedEventObject setObjectname(String objectname) {
        this.objectname = objectname;
        return this;
    }

    @Override
    public Float getExplosiveamount() {
        return explosiveamount;
    }

    @Override
    public SelectedEventObject setExplosiveamount(Float explosiveamount) {
        this.explosiveamount = explosiveamount;
        return this;
    }

    @Override
    public Timestamp getStarttime() {
        return starttime;
    }

    @Override
    public SelectedEventObject setStarttime(Timestamp starttime) {
        this.starttime = starttime;
        return this;
    }

    @Override
    public Integer getLength() {
        return length;
    }

    @Override
    public SelectedEventObject setLength(Integer length) {
        this.length = length;
        return this;
    }

    @Override
    public Integer getSamplerate() {
        return samplerate;
    }

    @Override
    public SelectedEventObject setSamplerate(Integer samplerate) {
        this.samplerate = samplerate;
        return this;
    }

    @Override
    public String getData() {
        return data;
    }

    @Override
    public SelectedEventObject setData(String data) {
        this.data = data;
        return this;
    }

    @Override
    public String getComments() {
        return comments;
    }

    @Override
    public SelectedEventObject setComments(String comments) {
        this.comments = comments;
        return this;
    }

    @Override
    public String getUid() {
        return uid;
    }

    @Override
    public SelectedEventObject setUid(String uid) {
        this.uid = uid;
        return this;
    }

    @Override
    public String getChannels() {
        return channels;
    }

    @Override
    public SelectedEventObject setChannels(String channels) {
        this.channels = channels;
        return this;
    }

    @Override
    public String getNetworkcode() {
        return networkcode;
    }

    @Override
    public SelectedEventObject setNetworkcode(String networkcode) {
        this.networkcode = networkcode;
        return this;
    }


    public String getStationid() {
        return stationid;
    }

    public SelectedEventObject setStationid(String stationid) {
        this.stationid = stationid;
        return this;
    }

    public String getLocationid() {
        return locationid;
    }

    public SelectedEventObject setLocationid(String locationid) {
        this.locationid = locationid;
        return this;
    }

    public List<Double> getStandardizedCombination() {
        return standardizedCombination;
    }

    public void setStandardizedCombination(List<Double> standardizedCombination) {
        this.standardizedCombination = standardizedCombination;
    }

    public double[][] getDataAsDouble() {
        return dataAsDouble;
    }

    public void setDataAsDouble(double[][] dataAsDouble) {
        this.dataAsDouble = dataAsDouble;
    }

    @Override
    public double getCorelation() {
        return corelation;
    }

    @Override
    public SelectedEventObject setCorelation(double dataAsDouble) {
        this.corelation = dataAsDouble;
        return this;

    }
}
