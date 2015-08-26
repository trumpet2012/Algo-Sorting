/**
 * William Trent Holliday
 * 8/25/15
 */
public class QuickSort extends SortHelpers implements Sort {

    private void sort(int[] arr, int lower, int upper){
        if (lower < upper){
            int partition = getPartition(arr, lower, upper);
            sort(arr, lower, partition);
            sort(arr, partition + 1, upper);
        }
    }

    private int getPartition(int[] arr, int lower, int upper) {
        int pivot = arr[lower];
        int i = lower - 1;
        int j = upper + 1;

        while (true){
            do {
                j = j-1;
            } while(arr[j] > pivot);

            do{
                i = i + 1;
            } while(arr[i] < pivot);
            if(i<j){
                swap(arr, i, j);
            }else{
                return j;
            }
        }
    }

    @Override
    public SortedResult execute(int[] arr) {

        long startTime = System.nanoTime();
        sort(arr, 0, arr.length-1);
        long endTime = System.nanoTime();

        return new SortedResult(arr, endTime - startTime);
    }
}
