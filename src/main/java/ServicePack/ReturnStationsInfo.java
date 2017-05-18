package ServicePack;

/**
 * Created by alex on 09.04.17.
 */
public class ReturnStationsInfo {

    public String stationId;

    public String lnglat;

    public ReturnStationsInfo(String _stationId,String _lnglat)
    {
        stationId = _stationId;
        lnglat = _lnglat;
    }

    public String getStationId() {
        return stationId;
    }

    public void setStationId(String stationId) {
        this.stationId = stationId;
    }

    public String getLnglat() {
        return lnglat;
    }

    public void setLnglat(String lnglat) {
        this.lnglat = lnglat;
    }
}
