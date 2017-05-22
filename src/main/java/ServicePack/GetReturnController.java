package ServicePack;

import ServicePack.Entitys.StationsInfo;
import ServicePack.ReseachPack.ReseachForReport.CalculateExtentSum;
import ServicePack.ReseachPack.ReseachStandardization;
import ServicePack.ReturnResult;
import ServicePack.ServiceEntity.ListReturnStationInfo;
import ServicePack.WorkWithDB.GetEventTemp;

import ServicePack.WorkWithDB.GetStationInfo;
import ServicePack.WorkWithDB.RandomEvent.RandomEventObject;
import ServicePack.WorkWithDB.ResultPackage.RandomSelectedObject;
import ServicePack.WorkWithDB.SelectedEvent.SelectedEventObject;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by alex on 07.04.17.
 */


@RestController
public class GetReturnController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value = "/stations",method = RequestMethod.POST)
    public ListReturnStationInfo getStationInfo(@RequestParam(value="stationid", defaultValue="") String stationId) {

        ListReturnStationInfo listReturnStationInfo = new ListReturnStationInfo();
        if (!stationId.equals("")) {
            List<ReturnStationsInfo> stationsInfos = new GetStationInfo().getStationList();
            listReturnStationInfo.setListReturnStationsInfo(stationsInfos);
            return listReturnStationInfo;
        }

        List<ReturnStationsInfo> stationsInfos = new GetStationInfo().getStationList();

        listReturnStationInfo.setListReturnStationsInfo(stationsInfos);
        return listReturnStationInfo;
    }

    @RequestMapping(value = "/randomevent",method = RequestMethod.POST)

    public RandomSelectedObject getRandomEvent(
            @RequestParam(value="stationid" , defaultValue="KEM") String stationId,
            @RequestParam(value="radius"    , defaultValue="5") String  radius
    ) {

        RandomSelectedObject selectedEventObject =
                new RandomSelectedObject(new RandomEventObject(stationId),radius);
        new CalculateExtentSum(selectedEventObject);
        return selectedEventObject;
    }

}
