package ServicePack.ReseachPack;

import com.fasterxml.jackson.databind.util.JSONPObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by alex on 17.04.17.
 */
public class TempReseach {
//
//    double[][] accumulatedMatrix = null;
//    double[][] combination = null;
//    double[][] standardizedCombination = null;
//    double[][] reductedStandardizedCombination = null;
//    double[][] dataAsDouble;
//
//    List<String> uids = new ArrayList<String>();
//    final List<String> matchingUnknownSeismicEventUIDs = new ArrayList<String>();
//    public TempReseach(){}
//
//    public void tempReseachFunction() throws InterruptedException, ExecutionException
//    {
//
//        Collection<Callable<Hashtable<String, List<Double>>>> threadCollection2 =
//                new ArrayList<Callable<Hashtable<String, List<Double>>>>();
//
//        List<Future<Hashtable<String, List<Double>>>> createDataArrayThreadFutureList = pool
//                .invokeAll(threadCollection2);
//
//        int cutLeftBoundValue = (int) (Double.valueOf(((JSONPObject) obj).get("templateCutLeftBound").toString()) * samplerate);
//
//        int cutRightBoundValue = (int) (Double.valueOf(((JSONPObject) obj).get("templateCutRightBound").toString()) * samplerate);
//
//        dataAsDouble = new double[createDataArrayThreadFutureList.get(0).get().size() * 3][createDataArrayThreadFutureList
//                .get(0).get().get(uids.get(0)).size()
//                - cutLeftBoundValue - cutRightBoundValue];
//
//        dataAsDouble = new double[createDataArrayThreadFutureList.get(0).get().size() * 3][createDataArrayThreadFutureList
//                .get(0).get().get(uids.get(0)).size()
//                - cutLeftBoundValue - cutRightBoundValue];
//
//        int n = dataAsDouble.length;
//        int m = dataAsDouble[0].length;
//
//        // Creating thread pool collection
//        // for DrawingTimeseriesByChannelsThread
//        //
//        Collection<Callable<Object>> threadCollection = new ArrayList<Callable<Object>>();
//        for (int j = 0; j < n / 3; j++) {
//            for (int i = 0; i < m; i++) {
//                dataAsDouble[3 * j][i] = createDataArrayThreadFutureList.get(0).get().get(uids.get(j))
//                        .get(cutLeftBoundValue + i - 1);
//                dataAsDouble[3 * j + 1][i] = createDataArrayThreadFutureList.get(1).get().get(uids.get(j))
//                        .get(cutLeftBoundValue + i - 1);
//                dataAsDouble[3 * j + 2][i] = createDataArrayThreadFutureList.get(2).get().get(uids.get(j))
//                        .get(cutLeftBoundValue + i - 1);
//            }
//            if (matchingUnknownSeismicEventUIDs.contains(uids.get(j))) {
//                threadCollection.add(new DrawingTimeseriesByChannelsThread(dataAsDouble[3 * j], uids.get(j),
//                        channels[0], request, rnd));
//                threadCollection.add(new DrawingTimeseriesByChannelsThread(dataAsDouble[3 * j + 1], uids.get(j),
//                        channels[1], request, rnd));
//                threadCollection.add(new DrawingTimeseriesByChannelsThread(dataAsDouble[3 * j + 2], uids.get(j),
//                        channels[2], request, rnd));
//            }
//        }
//
//        pool.shutdownNow();
//        pool = null;
//        createDataArrayThreadFutureList = null;
//
//        ExecutorService pool1 = Executors.newCachedThreadPool();
//        List<Future<Object>> drawingTimeseriesByChannelsThreadFutureList = pool1.invokeAll(threadCollection);
//        threadCollection = null;
//
//        // Calculate extent and sum
//        double[][] matrix = new double[dataAsDouble.length][dataAsDouble[0].length - 1];
//        n = matrix.length;
//        m = matrix[0].length;
//        for (int j = 0; j < n; j++) {
//            for (int i = 0; i < m; i++) {
//                matrix[j][i] = Math.pow(dataAsDouble[j][i] - dataAsDouble[j][i + 1], 2);
//            }
//        }
//        dataAsDouble = null;
//
//        double[] sum = new double[n];
//        double tempSum = 0.0;
//        for (int j = 0; j < n; j++) {
//            tempSum = 0.0;
//            for (int i = 0; i < m; i++) {
//                tempSum = tempSum + matrix[j][i];
//            }
//            sum[j] = tempSum;
//        }
//
//        // Calculate weighting, entropy
//        for (int j = 0; j < n; j++) {
//            tempSum = 0.0;
//            for (int i = 0; i < m; i++) {
//                matrix[j][i] = matrix[j][i] / sum[j];
//                if (matrix[j][i] != 0.0) {
//                    matrix[j][i] = -matrix[j][i] * Math.log(matrix[j][i]);
//                }
//            }
//        }
//        tempSum = 0.0;
//
//        // Combination
//        //
//        n = matrix.length;
//        m = matrix[0].length;
//
//        combination = new double[n / 3][m];
//        for (int j = 0; j < n / 3; j++) {
//            tempSum = 0.0;
//            for (int i = 0; i < m; i++) {
//                combination[j][i] = matrix[3 * j][i] + matrix[3 * j + 1][i] + matrix[3 * j + 2][i];
//            }
//        }
//
//        // Accumulation
//        //
//        n = combination.length;
//        m = combination[0].length;
//        accumulatedMatrix = new double[n][m];
//        for (int j = 0; j < n; j++) {
//            tempSum = 0.0;
//            for (int i = 0; i < m; i++) {
//                tempSum = tempSum + combination[j][i];
//                accumulatedMatrix[j][i] = tempSum;
//            }
//        }
//        combination = null;
//
//        // Standardized combination
//        //
//        tempSum = 0.0;
//        n = accumulatedMatrix.length;
//        m = accumulatedMatrix[0].length;
//
//        double[] mean = new double[m];
//        double[] meansqrdev = new double[m];
//
//        standardizedCombination = new double[n][m];
//
//        for (int i = 0; i < m; i++) {
//            tempSum = 0.0;
//            for (int j = 0; j < n; j++) {
//                tempSum = tempSum + accumulatedMatrix[j][i];
//            }
//
//            mean[i] = tempSum / n;
//        }
//        for (int i = 0; i < m; i++) {
//            tempSum = 0.0;
//            for (int j = 0; j < n; j++) {
//                tempSum = tempSum + (Math.pow((accumulatedMatrix[j][i] - mean[i]), 2));
//            }
//            meansqrdev[i] = Math.sqrt(tempSum / n);
//        }
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                standardizedCombination[j][i] = (accumulatedMatrix[j][i] - mean[i]) / meansqrdev[i];
//            }
//        }
//        accumulatedMatrix = null;
//        mean = null;
//        meansqrdev = null;
//    }

}
