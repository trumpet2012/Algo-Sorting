/**
 * William Trent Holliday
 * 8/25/15
 *
 * Test arrays starting at 1,0000 numbers and up to 200,000 numbers.
 *
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.Random;

public class SelectionTester extends Application{

    private static SortedResult selection1k;
    private static SortedResult selection10k;
    private static SortedResult selection100k;
    private static SortedResult selection200k;

    final static String selection = "Selection";

    final static Random randomGenerator = new Random();

    private Button showGraph, showTable;

    public static void main(String[] args){
        new SelectionTester().showGui(1);
        launch();
    }

    public void showGui(int avgTimes){
        runSimulation(avgTimes);
    }

    private static SortedResult runAlgo(int[] arr, int avgTimes, Sort algo){
        System.out.println("Running: " + algo.toString());
        int[] sortedArray = new int[arr.length];
        long resultTime = 0L;
        for(int i=0; i<avgTimes; i++) {
            SortedResult algoResult = algo.execute(Arrays.copyOf(arr, arr.length));
            resultTime += algoResult.getExecutionTime();
            sortedArray = algoResult.getSortedArr();
        }
        long algoAvg = (resultTime / avgTimes) / 1000; // take avg and convert to microseconds
        return new SortedResult(sortedArray, algoAvg);
    }

    private static void printArray(int[] arr) {
        System.out.println("---------------------");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("---------------------");
    }

    private void runSimulation(int avgTimes){
        int[] array1k = createRandomArray(1000);
        int[] array10k = createRandomArray(10000);
        int[] array100k = createRandomArray(100000);
        int[] array200k = createRandomArray(200000);

        Bubble bubbleSorter = new Bubble();
        Insertion insertionSorter = new Insertion();
        Selection selectionSorter = new Selection();
        QuickSort quickSorter = new QuickSort();

        selection1k = runAlgo(array1k, 1, selectionSorter);
        selection10k = runAlgo(array10k, 1, selectionSorter);
        selection100k = runAlgo(array100k, 1, selectionSorter);
        selection200k = runAlgo(array200k, 1, selectionSorter);
    }

    public static int[] createRandomArray(int size){
        int[] randomArray = new int[size];
        for (int i = 0; i < randomArray.length; i++) {
            randomArray[i] = randomGenerator.nextInt(1000000);
        }
        return randomArray;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Sorting Times");

        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();

        final BarChart<String, Number> barChart = new BarChart<String, Number>(xAxis, yAxis);
        barChart.setTitle("Execution times for Selection Sort");

        xAxis.setLabel("Sorting Algorithm");
        yAxis.setLabel("Speed in Microseconds");

        XYChart.Series<String, Number> series1k = new XYChart.Series<String, Number>();
        series1k.setName("1,000 Items");
        series1k.getData().add(new XYChart.Data(selection, selection1k.getExecutionTime()));

        XYChart.Series series10k = new XYChart.Series();
        series10k.setName("10,000 Items");
        series10k.getData().add(new XYChart.Data(selection, selection10k.getExecutionTime()));

        XYChart.Series series100k = new XYChart.Series();
        series100k.setName("100,000 Items");
        series100k.getData().add(new XYChart.Data(selection, selection100k.getExecutionTime()));

        XYChart.Series series200k = new XYChart.Series();
        series200k.setName("200,000 Items");
        series200k.getData().add(new XYChart.Data(selection, selection200k.getExecutionTime()));

        Scene graphScene = new Scene(barChart, 800, 600);
        barChart.getData().addAll(series1k, series10k, series100k, series200k);

        for (final XYChart.Series<String, Number> series : barChart.getData()) {
            for (final XYChart.Data<String, Number> data : series.getData()) {
                Tooltip tooltip = new Tooltip();
                tooltip.setText(data.getYValue().toString() + " microseconds");
                Tooltip.install(data.getNode(), tooltip);
            }
        }

        primaryStage.setScene(graphScene);

        primaryStage.show();
    }
}
