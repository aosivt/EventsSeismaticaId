package ServicePack.WorkWithDB.ResultPackage;

import ServicePack.WorkWithDB.EventObject;
import ServicePack.WorkWithDB.RandomEvent.RandomEventObject;
import ServicePack.WorkWithDB.SelectedEvent.SelectedEventObject;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.postgresql.jdbc4.Jdbc4ResultSet;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by oshchepkovayu on 13.04.17.
 */
public class RandomSelectedObject {
    @JsonProperty("random_object")
    private RandomEventObject randomEventObject;
    @JsonProperty("selected_objects")
    private List<EventObject> selectedEventObjects;

    private double[][] dataAsDouble;

    public RandomSelectedObject(){}
    public RandomSelectedObject(RandomEventObject _RandomEventObject, String _radius)
    {
        setRandomEventObject(_RandomEventObject);
        List<EventObject> tempSelectedEventObjects = new ArrayList<EventObject>();

        String sqlQuery =
                "select * from event_templates where " +
                        /*выборка определенной станции*/
                        "stationid = " +
                        "'"+ _RandomEventObject.getStationid() +"' " +
                        /*не брать в расчет выбронную произвольную станцию*/
                        "and " +
                        "event_templates.uid <> " +
                        "'" + _RandomEventObject.getUid() + "' and " +
                        /*в заданном году*/

                        "date_trunc('year', event_templates.\"date\") = " +
                        "'" + _RandomEventObject.getCurrentYear() + "' " +
                        " and " +
                        /*одной магнитуды в пределе от -0,2 до 0,2*/

                        " (event_templates.magnitude between "
                        + _RandomEventObject.getMagnitude() + "-0.2" +
                        " and "
                        + _RandomEventObject.getMagnitude() + "+0.2" +
                        ") " +
                        /*одного класса в пределе от -0,2 до 0,2*/
                        "and " +
                        "(event_templates.class between "
                        + _RandomEventObject.getClassName() + "-0.2" +
                        " and "
                        + _RandomEventObject.getClassName() + "+0.2" +
                        ") " +
                        "and " +
                        /*выборка по дате за полгода*/
                        "(event_templates.\"date\" between "
                        + "'" + _RandomEventObject.getStartDate() + "'" +
                        " and "
                        + "'" + _RandomEventObject.getEndDate()  + "'" +
                        ") " +
                        /*в пределах радиуса*/
                        "and " +
                        "ST_DWithin(event_templates.lnglat,ST_MakePoint( "
                        + _RandomEventObject.getX() +" , "
                        + _RandomEventObject.getY() +
                        ")::geography,"+_radius+"000);";
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection       = null;
            Statement statement         = null;

            connection = DriverManager.getConnection(
                    "jdbc:postgresql://84.237.62.137:5432/seismatica","seismatica_usr", "kubank12RX1");

            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sqlQuery);
            SelectedEventObject selectedEventObject;



            while ( rs.next() ) {


                selectedEventObject = new SelectedEventObject();

                selectedEventObject.setDate(                            rs.   getDate( "date"))
                .setId(                              rs.       getInt("id"))
                .setDaynumber(                       rs.getInt("daynumber"))

                .setType(                            rs.  getString("type"))
                .setGmt(                             rs.getTimestamp("gmt"))
                .setLnglat(                          rs.getString("lnglat"))

                .setClassName(                         rs.getFloat("class"))
                .setMagnitude(                     rs.getFloat("magnitude"))
                .setObjectname(                  rs.getString("objectname"))

                .setObservatory(                rs.getString("observatory"))
                .setExplosiveamount(         rs.getFloat("explosiveamount"))

                .setNearestsettlement(    rs.getString("nearestsettlement"))

                .setStarttime(                 rs.getTimestamp("starttime"))

                .setLength(                             rs.getInt("length"))
                .setSamplerate(                     rs.getInt("samplerate"))

                .setData(                              rs.getString("data"))
                .setComments(                      rs.getString("comments"))

                .setUid(                                rs.getString("uid"))

                .setChannels(                      rs.getString("channels"))
                .setNetworkcode(                rs.getString("networkcode"))
                .setStationid(                    rs.getString("stationid"))
                .setLocationid(                  rs.getString("locationid"));


                tempSelectedEventObjects.add(selectedEventObject);
                selectedEventObject.setDataAsDouble(getDataAsDouble(selectedEventObject));
                selectedEventObject = null;

            }
            tempSelectedEventObjects.add(_RandomEventObject);
            _RandomEventObject.setDataAsDouble(getDataAsDouble(_RandomEventObject));
            setSelectedEventObjects(tempSelectedEventObjects);

            statement .close();
            rs        .close();
            connection.close();


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public RandomEventObject getRandomEventObject() {
        return randomEventObject;
    }

    public void setRandomEventObject(RandomEventObject randomEventObject) {
        this.randomEventObject = randomEventObject;
    }

    public List<EventObject> getSelectedEventObjects() {
        return selectedEventObjects;
    }


    public void setSelectedEventObjects(List<EventObject> selectedEventObjects) {
        this.selectedEventObjects = selectedEventObjects;
    }

    public double[][] getMatricForCalculateExtentSum()
    {
        return null;

    }
    private double[][] getDataAsDouble(EventObject _randomSelectedObject){

        String[] part = _randomSelectedObject.getData().split("; ");

        double[][] dataAsDouble = new
                double[3]
                [part[0].split(" ").length];

        int m = dataAsDouble[0].length;

        int j = 0;

//        double[] temp;
//                = Arrays.stream(part[0].substring(0, part[0].length()).split(" "))
//                .map(String::trim).mapToDouble(Double::parseDouble).toArray();



                dataAsDouble[0]      = Arrays.stream(part[0].split(" "))
                        .map(String::trim).mapToDouble(Double::parseDouble).toArray();
                dataAsDouble[1]      = Arrays.stream(part[1].split(" "))
                        .map(String::trim).mapToDouble(Double::parseDouble).toArray();
                dataAsDouble[2]      = Arrays.stream(part[2].split(" "))
                        .map(String::trim).mapToDouble(Double::parseDouble).toArray();



        return dataAsDouble;

    }


}
