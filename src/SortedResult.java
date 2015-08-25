/**
 * William Trent Holliday
 * 8/25/15
 */
public class SortedResult {
    int[] sortedArr;
    long executionTime;

    public SortedResult(int[] arr, long time){
        sortedArr = arr;
        executionTime = time;
    }

    public long getExecutionTime(){
        return executionTime;
    }

    public int[] getSortedArr(){
        return sortedArr;
    }
}
