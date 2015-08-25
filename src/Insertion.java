/**
 * William Trent Holliday
 * 8/25/15
 */
public class Insertion extends SortHelpers implements Sort {

    private void sort(int[] arr){
        int size = arr.length;
        for (int i=1; i < size - 1; i++){
            int j=i;
            while (j > 0 && arr[j-1] > arr[j]){
                swap(arr, j-1, j);
                j--;
            }
        }
    }

    @Override
    public SortedResult execute(int[] arr) {
        long start = System.nanoTime();
        sort(arr);
        long end = System.nanoTime();

        return new SortedResult(arr, end - start);
    }
}
