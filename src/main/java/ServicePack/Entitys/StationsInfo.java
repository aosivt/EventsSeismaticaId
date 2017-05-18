package ServicePack.Entitys;

import javax.persistence.*;
import java.util.List;

/**
 * Created by alex on 07.04.17.
 */
@Entity
@Table(name = "stations_info", schema = "public")
public class StationsInfo {
    @Id
    @GeneratedValue
    public String stationId;

    public String lnglat;

    @OneToMany(/*fetch = FetchType.EAGER,*/mappedBy="stationid",cascade= CascadeType.PERSIST)
//    @JoinColumn(name = "stationid", referencedColumnName = "stationid")
    public List<EventTemplates> eventTemplates;

    public String getLnglat() {
        return lnglat;
    }

    public void setLnglat(String lnglat) {
        this.lnglat = lnglat;
    }

    public String getStationId() {
        return stationId;
    }

    public void setStationId(String stationId) {
        this.stationId = stationId;
    }

    public List<EventTemplates> getEventTemplates() {
        return eventTemplates;
    }

    public void setEventTemplates(List<EventTemplates> eventTemplates) {
        this.eventTemplates = eventTemplates;
    }
}
