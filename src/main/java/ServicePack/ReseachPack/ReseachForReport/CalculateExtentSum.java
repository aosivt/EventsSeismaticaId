package ServicePack.ReseachPack.ReseachForReport;

import ServicePack.WorkWithDB.EventObject;
import ServicePack.WorkWithDB.ResultPackage.RandomSelectedObject;
import ServicePack.WorkWithDB.SelectedEvent.SelectedEventObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.DoubleStream;

/**
 * Created by alex on 23.04.17.
 */
public class CalculateExtentSum {

    private double[][] matrix;
    private double[][] returnMatrix;
    private int reductionCoefficient = 10;
    private double[][] reductedStandardizedCombination = null;
    List<List<Double>> resultList;


    public CalculateExtentSum(RandomSelectedObject _randomSelectedObject) {
        System.out.print("calculate");
        double[][] dataAsDouble = getDataAsDouble(_randomSelectedObject);

        int n = dataAsDouble.length;
        int m = dataAsDouble[0].length;

        // Creating thread pool collection
        // for DrawingTimeseriesByChannelsThread
        //
//        Collection<Callable<Object>> threadCollection = new ArrayList<Callable<Object>>();

//        // Calculate extent and sum
        double[][] matrix = new double[dataAsDouble.length][dataAsDouble[0].length - 1];
        n = matrix.length;
        m = matrix[0].length;
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                matrix[j][i] = Math.pow(dataAsDouble[j][i] - dataAsDouble[j][i + 1], 2);
            }
        }
        dataAsDouble = null;
//
        double[] sum = new double[n];
        double tempSum = 0.0;
        for (int j = 0; j < n; j++) {
            tempSum = 0.0;
            for (int i = 0; i < m; i++) {
                tempSum = tempSum + matrix[j][i];
            }
            sum[j] = tempSum;
        }

        // Calculate weighting, entropy
        for (int j = 0; j < n; j++) {
            tempSum = 0.0;
            for (int i = 0; i < m; i++) {
                matrix[j][i] = matrix[j][i] / sum[j];
                if (matrix[j][i] != 0.0) {
                    matrix[j][i] = -matrix[j][i] * Math.log(matrix[j][i]);
                }
            }
        }
        tempSum = 0.0;

        // Combination
        //
        n = matrix.length;
        m = matrix[0].length;

        double[][] combination = new double[n / 3][m];
        for (int j = 0; j < n / 3; j++) {
            tempSum = 0.0;
            for (int i = 0; i < m; i++) {
                combination[j][i] = matrix[3 * j][i] + matrix[3 * j + 1][i] + matrix[3 * j + 2][i];
            }
        }

        // Accumulation
        //
        n = combination.length;
        m = combination[0].length;
        double[][] accumulatedMatrix = new double[n][m];
        for (int j = 0; j < n; j++) {
            tempSum = 0.0;
            for (int i = 0; i < m; i++) {
                tempSum = tempSum + combination[j][i];
                accumulatedMatrix[j][i] = tempSum;
            }
        }
        combination = null;

        // Standardized combination
        //
        tempSum = 0.0;
        n = accumulatedMatrix.length;
        m = accumulatedMatrix[0].length;

        double[] mean = new double[m];
        double[] meansqrdev = new double[m];

        double[][] standardizedCombination = new double[n][m];

        for (int i = 0; i < m; i++) {
            tempSum = 0.0;
            for (int j = 0; j < n; j++) {
                tempSum = tempSum + accumulatedMatrix[j][i];
            }

            mean[i] = tempSum / n;
        }
        for (int i = 0; i < m; i++) {
            tempSum = 0.0;
            for (int j = 0; j < n; j++) {
                tempSum = tempSum + (Math.pow((accumulatedMatrix[j][i] - mean[i]), 2));
            }
            meansqrdev[i] = Math.sqrt(tempSum / n);
        }
        List<List<Double>> lists;
        List<Double> listsDouble = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                standardizedCombination[j][i] = (accumulatedMatrix[j][i] - mean[i]) / meansqrdev[i];
            }

        }
        accumulatedMatrix = null;
        mean = null;
        meansqrdev = null;


        double[] correlation = new double[n];
        mean = new double[n];
        double tempSum1 = 0.0;
        double tempSum2 = 0.0;
        double meanUnknownData = 0.0;

        for (int j = 0; j < n; j++) {
            tempSum = 0.0;
            for (int i = 0; i < m; i++) {
                tempSum = tempSum + standardizedCombination[j][i];
            }
            mean[j] = tempSum / m;
        }

        meanUnknownData =  DoubleStream.of(standardizedCombination[n-1]).sum()
                                            /standardizedCombination[n-1].length;

        for (int j = 0; j < n; j++) {
            tempSum = 0.0;
            tempSum1 = 0.0;
            tempSum2 = 0.0;
            for (int i = 0; i < m; i++) {
                tempSum = tempSum
                        + ((standardizedCombination[n-1][i] - meanUnknownData) * (standardizedCombination[j][i] - mean[j]));
                tempSum1 = tempSum1
                        + Math.pow((standardizedCombination[n-1][i] - meanUnknownData),
                        2);
                tempSum2 = tempSum2 + Math.pow((standardizedCombination[j][i] - mean[j]), 2);
            }
            _randomSelectedObject.getSelectedEventObjects().get(j)
                    .setCorelation((Math.abs(tempSum)) / (Math.sqrt(tempSum1 * tempSum2)));
            if ((Math.abs(tempSum)) / (Math.sqrt(tempSum1 * tempSum2))<0.0){
                System.err.print((tempSum) / (Math.sqrt(tempSum1 * tempSum2)));
            }
//            correlation[j] = (tempSum) / (Math.sqrt(tempSum1 * tempSum2));
        }
        mean = null;



        double reductionSum1 = 0.0;
        int reductionCounting = 0;

        reductedStandardizedCombination = new double[n][(m - (m % reductionCoefficient)) / reductionCoefficient];
        for (int j = 0; j < n; j++) {
            listsDouble = new ArrayList<>();
            reductionSum1       = 0.0;
            reductionCounting   = 0;
            for (int i = 0; i < m; i++) {

                if (i % reductionCoefficient == 0) {
                    try {

                        reductionSum1 = reductionSum1 + standardizedCombination[j][i];
                        listsDouble.add(reductionSum1 / reductionCoefficient);
//                        reductedStandardizedCombination[j][reductionCounting] = reductionSum1
//                                / reductionCoefficient;
                        reductionSum1 = 0.0;
                        reductionCounting++;
                    } catch (Exception ex) {
                    }
                }

            }

        _randomSelectedObject.getSelectedEventObjects().get(j)
        .setStandardizedCombination(listsDouble);
//        listsDouble.clear();
//            lists.add(listsDouble);
        }
//        returnMatrix = standardizedCombination;
//        setResultList(lists);

        standardizedCombination = null;

    }
    private double[][] getDataAsDouble(RandomSelectedObject _randomSelectedObject){

        int sizeRandomeSelectedObject = _randomSelectedObject.getSelectedEventObjects().size();

        double[][] dataAsDouble = new
                double[sizeRandomeSelectedObject*3][];
        int j = 0;

        for (  EventObject tempEventObject : _randomSelectedObject.getSelectedEventObjects())
        {
                dataAsDouble[3 * j]       = tempEventObject.getDataAsDouble()[0];
                dataAsDouble[3 * j + 1]   = tempEventObject.getDataAsDouble()[1];
                dataAsDouble[3 * j + 2]   = tempEventObject.getDataAsDouble()[2];

            j=j+1;
        }

        return dataAsDouble;

    }

    public double[][] getReturnMatrix() {
        return returnMatrix;
    }

    public List<List<Double>> getResultList() {
        return resultList;
    }

    private void setResultList(List<List<Double>> resultList) {
        this.resultList = resultList;
    }
}





