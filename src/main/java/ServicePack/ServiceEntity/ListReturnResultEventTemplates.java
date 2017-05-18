package ServicePack.ServiceEntity;

import ServicePack.ReturnResult;
import ServicePack.ReturnStationsInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by alex on 10.04.17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ListReturnResultEventTemplates {
    @JsonProperty("stationsEventTemplates")
    public List<ReturnResult> listReturnResult;

    public List<ReturnResult> getListReturnStationsInfo() {
        return listReturnResult;
    }

    public void setListReturnStationsInfo(List<ReturnResult> listReturnResult) {
        this.listReturnResult = listReturnResult;
    }
}
