/**
 * William Trent Holliday
 * 8/25/15
 *
 * Test arrays starting at 1,0000 numbers and up to 500,000 numbers.
 *
 */
public class SortTester {
    public static void main(String[] args){
        int[] test = {5, 3, 1, 2, 4, 5};

        Bubble bubbleSorter = new Bubble();
        SortedResult testSorted = bubbleSorter.execute(test);
        System.out.println("Bubble execution time: " + testSorted.getExecutionTime());
        for(int i: testSorted.getSortedArr())
            System.out.printf("%d ", i);

        System.out.println("\n----------------------------");

        Insertion insertionSorter = new Insertion();
        SortedResult insertSorted = insertionSorter.execute(test);
        System.out.println("Insertion execution time: " + insertSorted.getExecutionTime());
        for(int i: insertSorted.getSortedArr())
            System.out.printf("%d ", i);
    }
}
