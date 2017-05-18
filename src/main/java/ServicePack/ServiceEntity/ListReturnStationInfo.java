package ServicePack.ServiceEntity;

import ServicePack.ReturnStationsInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by oshchepkovayu on 10.04.17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ListReturnStationInfo {
    @JsonProperty("stationsInfos")
    public List<ReturnStationsInfo> listReturnStationsInfo;

    public List<ReturnStationsInfo> getListReturnStationsInfo() {
        return listReturnStationsInfo;
    }

    public void setListReturnStationsInfo(List<ReturnStationsInfo> listReturnStationsInfo) {
        this.listReturnStationsInfo = listReturnStationsInfo;
    }
}
