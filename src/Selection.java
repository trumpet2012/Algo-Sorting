/**
 * William Trent Holliday
 * 8/25/15
 */
public class Selection extends SortHelpers implements Sort {

    private void sort(int[] arr){
        int size = arr.length;
        for(int i=0; i < size - 1; i++){
            int minimumIndex = i;

            for(int j=i+1; j<size;j++){
                if (arr[j] < arr[minimumIndex]){
                    minimumIndex = j;
                }
            }

            if (minimumIndex != i){
                swap(arr, i, minimumIndex);
            }
        }
    }

    @Override
    public SortedResult execute(int[] arr) {
        long startTime = System.nanoTime();
        sort(arr);
        long endTime = System.nanoTime();
        return new SortedResult(arr, endTime - startTime);
    }
}
