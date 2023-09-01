package BinarySearch;

public class SearchInRotatedSortedArray {

    // toh basically yeh problem meh mujhe ek array diya hai
    // which is initially sorted in asscending order.
    // lets say the array is --> 0 1 2 3 4 5 6 7.
    // and is question meh specify kiya hai ki yeh array
    // ek index == 3 pr rotated hai
    // toh yeh kuch aisa dikhne lag raha hoga...
    // 4 5 6 7 0 1 2 3.
    // ab aise array meh mujhe mera target search krna hai.
    // right.
    // toh ek chij toh hai ki meh linear search maar duh simple saa

    public static int linearSearch(int[] arr, int target) {
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                index = i;
            }
        }
        return index;
    }

    // lets think of thoda better approach to solve this problem

    // question read kr keh i came to know about the approach...
    // binary search efficiently apply kr sakta hoon.
    // so now lets get to crux of the problem...
    // since mera array phele sorted that is the thing which i know as of now.
    // jab meh is array ko rotate kr dunga to mujhe kyaa pata lagegaa.
    // ki abhi bhi kabhi na kaahi mere kuch half of the array is still sorted.
    // toh sabse phele meh kuch aisa soch looh kii meh kis middle index pr jaa kr
    // yeh find kr loo
    // ki kya mera array left sorted hai yaa right sorted hai...
    // and then afterwards meh apni search space ko frame kr sakta hoon
    // manipulate kr sakta hoon as per the elements i have in that space.

    public static int SearchInRotatedSortedArrayProblem(int[] arr, int target) {

        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == target)
                return mid;

            else if (arr[mid] >= arr[low]) {
                if (target >= arr[low] && target <= arr[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (target >= arr[mid] && target <= arr[high]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;

    }

}
