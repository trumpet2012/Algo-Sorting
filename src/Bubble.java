/**
 * William Trent Holliday
 * 8/25/15
 */
public class Bubble extends SortHelpers implements Sort {

    private boolean isLeftBigger(int left, int right){
        return left > right;
    }

    private void sort(int[] arr){
        int size = arr.length;
        boolean swapped = false;
        do{
            swapped = false;
            for (int i=1; i<=size-1; i++){
                if (isLeftBigger(arr[i-1], arr[i])){
                    swap(arr, i-1, i);
                    swapped = true;
                }
            }
        } while(swapped);
    }

    @Override
    public SortedResult execute(int[] arr) {
        long startTime = System.nanoTime();
        sort(arr);
        long endTime = System.nanoTime();
        return new SortedResult(arr, endTime - startTime);
    }

}
