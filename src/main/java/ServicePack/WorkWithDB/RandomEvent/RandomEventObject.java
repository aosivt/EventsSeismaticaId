package ServicePack.WorkWithDB.RandomEvent;

import ServicePack.WorkWithDB.EventObject;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonRootName;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.jdbc.Work;
import util.HibernateUtil;

import java.sql.*;
import java.util.List;

/**
 * Created by oshchepkovayu on 12.04.17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)

public class RandomEventObject implements EventObject<RandomEventObject> {

    /*-----Созданные в запросе поля-----*/

    private Date                startDate;
    private Date                  endDate;
    private Date              currentYear;
    private Float                       x;
    private Float                       y;

    /*
    private List<String>                e;
    private List<String>                n;
    private List<String>                z;
    */




    /*----------Поля таблици------------*/
    private Integer                     id;

    private Integer              daynumber;
    private Date                      date;

    private String                    type;
    private Timestamp                  gmt;
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

    public RandomEventObject(){}
    public RandomEventObject(String _stationid)
    {
        String sqlQuery =
                "select   " +
                        "\"date\" as data_event_random," +


                        "(cast(\"date\" as timestamp) - cast('6 months' as interval)) as start_date," +
                        "(cast(\"date\" as timestamp) + cast('6 months' as interval)) as end_date, " +
                        "date_trunc('year', \"date\") as curent_year," +
                        "magnitude as magnitude_event_random," +
                        "class as class_event_random," +
                        "ST_X(cast(lnglat as geometry)) as x," +
                        "ST_Y(cast(lnglat as geometry)) as y " +
                        ",*" +
                        " from event_templates  " +
                        " where stationid = '" + _stationid + "' offset floor(random()* 1000) LIMIT 1";
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection       = null;
            Statement statement         = null;

//            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//            Session session = sessionFactory.openSession();
//
//            // Way1 - using doWork method
//            session.doWork(new Work() {
//                @Override
//                public void execute(Connection connection) throws SQLException {
//
//                    // do your work using connection
//                }
//
//            });

            connection = DriverManager.getConnection(
                    "jdbc:postgresql://84.237.62.137:5432/seismatica","seismatica_usr", "kubank12RX1");

            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sqlQuery);
            while ( rs.next() ) {
            /*-----Заполнение созданных полей-----*/
            setStartDate(           rs.getDate( "start_date"));

            setEndDate(             rs.getDate(   "end_date"));
            setCurrentYear(         rs.getDate("curent_year"));
            setX(                   rs.getFloat         ("x"));
            setY(                   rs.getFloat         ("y"));

            /*-----Заполнение полей сущности------*/

                setDate(                            rs.   getDate( "date"));
                setId(                              rs.       getInt("id"));
                setDaynumber(                       rs.getInt("daynumber"));

                setType(                            rs.  getString("type"));
                setGmt(                             rs.getTimestamp("gmt"));
                setLnglat(                          rs.getString("lnglat"));

                setClassName(                         rs.getFloat("class"));
                setMagnitude(                     rs.getFloat("magnitude"));

                setObservatory(                rs.getString("observatory"));
                setExplosiveamount(         rs.getFloat("explosiveamount"));
                setObjectname(                rs.getString("objectname"));

                setNearestsettlement(   rs.getString("nearestsettlement"));

                setStarttime(                 rs.getTimestamp("starttime"));

                setLength(                             rs.getInt("length"));
                setSamplerate(                     rs.getInt("samplerate"));

                setData(                              rs.getString("data"));

                setComments(                      rs.getString("comments"));

                setUid(                                rs.getString("uid"));

                setChannels(                      rs.getString("channels"));
                setNetworkcode(                rs.getString("networkcode"));
                setStationid(                    rs.getString("stationid"));
                setLocationid(                  rs.getString("locationid"));


            }


            statement .close();
            rs        .close();
            connection.close();


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getCurrentYear() {
        return currentYear;
    }

    public void setCurrentYear(Date currentYear) {
        this.currentYear = currentYear;
    }

    public Float getX() {
        return x;
    }

    public void setX(Float x) {
        this.x = x;
    }

    public Float getY() {
        return y;
    }

    public void setY(Float y) {
        this.y = y;
    }

    public Integer getId() {
        return id;
    }

    public RandomEventObject setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getDaynumber() {
        return daynumber;
    }

    public RandomEventObject setDaynumber(Integer daynumber) {
        this.daynumber = daynumber;
        return this;
    }

    public Date getDate() {
        return date;
    }

    public RandomEventObject setDate(Date date) {
        this.date = date;
        return this;
    }

    public String getType() {
        return type;
    }

    public RandomEventObject setType(String type) {
        this.type = type;
        return this;
    }

    public Timestamp getGmt() {
        return gmt;
    }

    public RandomEventObject setGmt(Timestamp gmt) {
        this.gmt = gmt;
        return this;
    }

    public String getLnglat() {
        return lnglat;
    }

    public RandomEventObject setLnglat(String lnglat) {
        this.lnglat = lnglat;
        return this;
    }

    public Float getClassName() {
        return className;
    }

    public RandomEventObject setClassName(Float className) {
        this.className = className;
        return this;
    }

    public Float getMagnitude() {
        return magnitude;
    }

    public RandomEventObject setMagnitude(Float magnitude) {
        this.magnitude = magnitude;
        return this;
    }

    public String getObservatory() {
        return observatory;
    }

    public RandomEventObject setObservatory(String observatory) {
        this.observatory = observatory;
        return this;
    }

    public String getNearestsettlement() {
        return nearestsettlement;
    }

    public RandomEventObject setNearestsettlement(String nearestsettlement) {
        this.nearestsettlement = nearestsettlement;
        return this;
    }

    public String getObjectname() {
        return objectname;
    }

    public RandomEventObject setObjectname(String objectname) {
        this.objectname = objectname;
        return this;
    }

    public Float getExplosiveamount() {
        return explosiveamount;
    }

    public RandomEventObject setExplosiveamount(Float explosiveamount) {
        this.explosiveamount = explosiveamount;
        return this;
    }

    public Timestamp getStarttime() {
        return starttime;
    }

    public RandomEventObject setStarttime(Timestamp starttime) {
        this.starttime = starttime;
        return this;
    }

    public Integer getLength() {
        return length;
    }

    public RandomEventObject setLength(Integer length) {
        this.length = length;
        return this;
    }

    public Integer getSamplerate() {
        return samplerate;
    }

    public RandomEventObject setSamplerate(Integer samplerate) {
        this.samplerate = samplerate;
        return this;
    }

    public String getData() {
        return data;
    }

    public RandomEventObject setData(String data) {
        this.data = data;
        return this;
    }

    public String getComments() {
        return comments;
    }

    public RandomEventObject setComments(String comments) {
        this.comments = comments;
        return this;
    }

    public String getUid() {
        return uid;
    }

    public RandomEventObject setUid(String uid) {
        this.uid = uid;
        return this;
    }

    public String getChannels() {
        return channels;
    }

    public RandomEventObject setChannels(String channels) {
        this.channels = channels;
        return this;
    }

    public String getNetworkcode() {
        return networkcode;
    }

    public RandomEventObject setNetworkcode(String networkcode) {
        this.networkcode = networkcode;
        return this;
    }

    public String getStationid() {
        return stationid;
    }

    public RandomEventObject setStationid(String stationid) {
        this.stationid = stationid;
        return this;
    }

    public String getLocationid() {
        return locationid;
    }

    public RandomEventObject setLocationid(String locationid) {
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
    public RandomEventObject setCorelation(double dataAsDouble) {
        System.err.print(dataAsDouble);
        this.corelation = dataAsDouble;
        return this;

    }
}
