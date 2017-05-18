package ServicePack.WorkWithDB;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by alex on 24.04.17.
 */
public interface EventObject <T extends EventObject<T>> {


    public T setId(Integer id);

    public Integer getDaynumber();

    public T setDaynumber(Integer daynumber);

    public Date getDate();

    public T setDate(Date date);

    public String getType();

    public T setType(String type);

    public Timestamp getGmt();

    public T setGmt(Timestamp gmt) ;

    public String getLnglat();

    public T setLnglat(String lnglat);

    public Float getClassName();

    public T setClassName(Float className);

    public Float getMagnitude();

    public T setMagnitude(Float magnitude);

    public String getObservatory();

    public T setObservatory(String observatory);

    public String getNearestsettlement();

    public T setNearestsettlement(String nearestsettlement);

    public String getObjectname();

    public T setObjectname(String objectname);

    public Float getExplosiveamount();

    public T setExplosiveamount(Float explosiveamount);

    public Timestamp getStarttime();

    public T setStarttime(Timestamp starttime);

    public Integer getLength();

    public T setLength(Integer length);

    public Integer getSamplerate();

    public T setSamplerate(Integer samplerate);

    public String getData();

    public T setData(String data);

    public String getComments();

    public T setComments(String comments);

    public String getUid();

    public T setUid(String uid);

    public String getChannels();

    public T setChannels(String channels) ;

    public String getNetworkcode();

    public T setNetworkcode(String networkcode);

    public String getStationid();

    public T setStationid(String stationid);

    public String getLocationid();

    public T setLocationid(String locationid);

    public List<Double> getStandardizedCombination();

    public void setStandardizedCombination(List<Double> standardizedCombination);

    public double[][] getDataAsDouble();

    public void setDataAsDouble(double[][] dataAsDouble);

    public double getCorelation();

    public T setCorelation(double dataAsDouble);
}
