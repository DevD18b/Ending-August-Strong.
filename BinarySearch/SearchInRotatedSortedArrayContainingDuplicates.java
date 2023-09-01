package BinarySearch;

public class SearchInRotatedSortedArrayContainingDuplicates {

    public static boolean search(int[] nums, int target) {

        // kyuki array kisi pivot index keh across sorted hai toh acha hoga kii meh
        // pahele pivot index find krna start kr duu
        // and what actually happend is fir mujhe pata hoga konsa half sorted and konsa
        // half sort
        // hai konsa nhi aisa krne seh is baat ka idea ho ga kii konse region meh sort
        // maar na hai

        int pivot = findPivot(nums, 0, nums.length - 1, target);

        if (binarySearch(nums, 0, pivot - 1, target)) {
            return true;
        } else
            return binarySearch(nums, pivot, nums.length - 1, target);
    }

    public static int findPivot(int[] arr, int left, int right, int target) {

        while (left < right) {
            int mid = (left) + (right - left) / 2;
            if (arr[mid] > arr[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;

    }

    public static boolean binarySearch(int[] arr, int left, int right, int target) {
        while (left <= right) {
            int mid = (left + right) << 1;
            if (arr[mid] == target) {
                return true;
            }
            if (arr[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}
