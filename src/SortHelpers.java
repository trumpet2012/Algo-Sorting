/**
 * William Trent Holliday
 * 8/25/15
 */
public class SortHelpers {
    protected void swap(int[] arr, int leftIndex, int rightIndex) {
        /**
         * Swap the left index and the right index values.
         */
        int temp = arr[leftIndex];
        arr[leftIndex] = arr[rightIndex];
        arr[rightIndex] = temp;
    }
}
