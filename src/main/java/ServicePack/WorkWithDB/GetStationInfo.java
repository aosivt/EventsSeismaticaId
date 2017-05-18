package ServicePack.WorkWithDB;

import ServicePack.Entitys.StationsInfo;
import ServicePack.ReturnStationsInfo;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by alex on 09.04.17.
 */
public class GetStationInfo {
    public GetStationInfo()
    {}

    public List<ReturnStationsInfo>  getStationList()
    {
        String temp = "";
        Session session = HibernateUtil.getSessionFactory().openSession();

        Query query = session.createQuery("From StationsInfo");

        List<ReturnStationsInfo> resultlist = new ArrayList<>();
        resultlist = (List<ReturnStationsInfo>) query.list()
                .stream().map(
                        result -> new ReturnStationsInfo(
                                ((StationsInfo)result).getStationId(),
                                ((StationsInfo)result).getLnglat()  )
                )
                .collect(Collectors.toList());
        session.close();
        return resultlist;
    }
    public List<ReturnStationsInfo>  getStationList(String stationId)
    {
        String temp = "";
        Session session = HibernateUtil.getSessionFactory().openSession();

        Query query = session.createQuery("From StationsInfo where stationid = :stationId");
        query.setParameter("stationId", stationId);
        List<ReturnStationsInfo> resultlist = new ArrayList<>();


        resultlist = (List<ReturnStationsInfo>) query.list()
                        .stream().map(
                                result -> new ReturnStationsInfo(
                                        ((StationsInfo)result).getStationId(),
                                        ((StationsInfo)result).getLnglat()  )
                                    )
                        .collect(Collectors.toList());

        session.close();
        return resultlist;
    }
}
