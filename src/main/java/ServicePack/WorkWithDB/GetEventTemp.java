package ServicePack.WorkWithDB;

import ServicePack.Entitys.EventTemplates;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import util.HibernateUtil;

import java.sql.*;
import java.util.List;

/**
 * Created by alex on 07.04.17.
 */
public class GetEventTemp {
    public GetEventTemp() {
    }

    public String getEventTempString() {
        String temp = "";
        Session session = HibernateUtil.getSessionFactory().openSession();

        Query q = session.createQuery("From EventTemplates where id = :idEvent");
        q.setParameter("idEvent", 1);


        List<EventTemplates> resultlist = q.list();
        for (EventTemplates next : resultlist) {
            temp = next.getData();
            break;
        }
        session.close();
        return temp;
    }

    public String getRandomEvent() {
        String temp = "";
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();
        SQLQuery result =


                session.createSQLQuery(

                        "select   \"date\" as data_event_random," +
                                "lnglat as lnglat_event_random, " +
//                "(\"date\" \\:\\:timestamp - '6 months' \\:\\: interval) as start_date," +
//                "(\"date\" \\:\\:timestamp + '6 months' \\:\\: interval) as end_date, " +
                                "(cast(\"date\" as timestamp) - cast('6 months' as interval)) as start_date," +
                                "(cast(\"date\" as timestamp) + cast('6 months' as interval)) as end_date, " +
                                "date_trunc('year', \"date\") as curent_year," +
                                "magnitude as magnitude_event_random," +
                                "class as class_event_random," +
                                "ST_X(cast(lnglat as geometry)) as x," +
                                "ST_Y(cast(lnglat as geometry)) as y " +
//                                ",*" +
                                " from event_templates  " +
                                " where stationid = 'KEM' offset floor(random()* 1000) LIMIT 1"
                );

        List resultList = result.list();


        return temp;
    }

    public void getRandomEventWithoutHibernate()
    {
        String sqlQuery =               "select   \"date\" as data_event_random," +
                "lnglat as lnglat_event_random, " +
//                "(\"date\" \\:\\:timestamp - '6 months' \\:\\: interval) as start_date," +
//                "(\"date\" \\:\\:timestamp + '6 months' \\:\\: interval) as end_date, " +
                "(cast(\"date\" as timestamp) - cast('6 months' as interval)) as start_date," +
                "(cast(\"date\" as timestamp) + cast('6 months' as interval)) as end_date, " +
                "date_trunc('year', \"date\") as curent_year," +
                "magnitude as magnitude_event_random," +
                "class as class_event_random," +
                "ST_X(cast(lnglat as geometry)) as x," +
                "ST_Y(cast(lnglat as geometry)) as y " +
                ",*" +
                " from event_templates  " +
                " where stationid = 'KEM' offset floor(random()* 1000) LIMIT 1";
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = null;
            Statement statement = null;

            connection = DriverManager.getConnection(
                    "jdbc:postgresql://84.237.62.137:5432/seismatica","seismatica_usr", "kubank12RX1");
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sqlQuery);
            while ( rs.next() ) {
                int id = rs.getInt("id");
//                String  name = rs.getString("name");
//                int age  = rs.getInt("age");
//                String  address = rs.getString("address");
//                float salary = rs.getFloat("salary");
                System.out.println( "ID = " + id );
//                System.out.println( "NAME = " + name );
//                System.out.println( "AGE = " + age );
//                System.out.println( "ADDRESS = " + address );
//                System.out.println( "SALARY = " + salary );
                System.out.println();
            }
            rs.close();
            connection.createStatement();

            connection.close();


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
