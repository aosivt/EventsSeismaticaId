package ServicePack.ReseachPack;

import java.util.Date;
import java.util.List;

/**
 * Created by alex on 17.04.17.
 */
public class ReseachDiElement {
    private Date dateEvent;
    private List<Integer> ResultDiElement;
    ReseachDiElement(){}
    ReseachDiElement(Date _insertDate, List<Integer> _insertDi){

    setDateEvent(_insertDate);
    setResultDiElement(_insertDi);
    }

    public Date getDateEvent() {
        return dateEvent;
    }

    public void setDateEvent(Date dateEvent) {
        this.dateEvent = dateEvent;
    }

    public List<Integer> getResultDiElement() {
        return ResultDiElement;
    }

    public void setResultDiElement(List<Integer> resultDiElement) {
        ResultDiElement = resultDiElement;
    }
}
