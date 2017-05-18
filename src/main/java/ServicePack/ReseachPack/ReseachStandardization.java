package ServicePack.ReseachPack;

import ServicePack.ReseachPack.ReseachForReport.CalculateExtentSum;
import ServicePack.ReturnResult;
import ServicePack.WorkWithDB.ResultPackage.RandomSelectedObject;

import javax.xml.crypto.Data;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by alex on 17.04.17.
 */
public class ReseachStandardization {

    private RandomSelectedObject    randomSelectedObjects;

    private List<List<Double>>          returnResultList;


    {
        System.out.println("---------reseachDiElements---------");
    }

    public ReseachStandardization(){}
    public ReseachStandardization(RandomSelectedObject _randomSelectedObject){

        CalculateExtentSum reseachExtentSum = new CalculateExtentSum(_randomSelectedObject);
        returnResultList = reseachExtentSum.getResultList();

        setRandomSelectedObjects(_randomSelectedObject);

    }


    public RandomSelectedObject getRandomSelectedObjects() {
        return randomSelectedObjects;
    }

    public void setRandomSelectedObjects(RandomSelectedObject randomSelectedObjects) {
        this.randomSelectedObjects = randomSelectedObjects;
    }


    public List<List<Double>> getReturnResultList() {
        return returnResultList;
    }
}
//        reseachDiElements = new ArrayList<>();
//
//        ReseachDiElement reseachDiElement;
//        System.out.println("---------ReseachStandardization---------");
//
//        try {
//            _randomSelectedObject.getSelectedEventObjects().forEach(
//                    eventObject ->
//                    {
//                        String[] part = eventObject.getData().split(";");
//
//                        List<String> e = Arrays.asList(part[0].split(" "));
//                        List<String> n = Arrays.asList(part[1].split(" "));
//                        List<String> z = Arrays.asList(part[2].split(" "));
//
//                        /*List<Integer> returnResult = Arrays.asList(part).stream().
//                                peek(
//                                i->System.out.println(
//                                        )
//                                ).
//                                collect(Collectors.toList());*/
//
//                        List<Integer> returnResult =
//                        Stream<Integer> integerStream =
//                                IntStream.rangeClosed(0,e.size()-1)
//                                        .forEach
//                                        .mapToObj
//                                                (i->
//
//                       e.get(i)!=""? Integer.parseInt(e.get(i)):0 +
//                       n.get(i)!=""? Integer.parseInt(n.get(i)):0 +
//                       z.get(i)!=""? Integer.parseInt(z.get(i)):0
//                                                )
//                                        .collect(Collectors.toList())
//                                ;

//                        reseachDiElements.add(new ReseachDiElement(eventObject.getDate(),returnResult));
//
//                    }
//
//            );
//        }
//        catch (Exception e)
//        {
//            System.err.print(e.getMessage());
//        }
