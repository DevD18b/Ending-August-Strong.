package BinarySearch;

public class searchInMatrix {
    // 2D matrix meh har row keh integer is sorted.
    // har row meh jo element hai first element
    // woh last element seh bada hogaa...
    // brute force is o(n square)...
    // yaa fir har row meh binary search maar doh toh
    // for m rows there is binary search and then the complexity
    // becomes m*(log(n))....
    public static boolean searchingTheTarget(int[][] matrix, int target) {

        for (int[] arr : matrix) {

            int start = 0;
            int end = arr.length - 1;
            while (start <= end) {
                int mid = (start + end) / 2;
                if (arr[mid] == target) {
                    return true;
                }
                if (arr[mid] > target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return false;
    }

    // now since meh humesha ek large array meh search krne keh liye comfortable.
    // but kyaa meh matrix meh yeh kr sakta hoon
    // woh thoda sa difficult jarur hai...
    // but kahinn naa kahiii agar meh mid find krte hai usko kuch maths laga kr
    // map kr deh toh kaafi chijeh sort out kr sakte hai.

    public static boolean searchEffectively(int[][] grid, int target) {

        int row = grid.length;
        int col = grid[0].length;

        int low = 0;
        int high = row * col - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            // [mid/col][mid%col] toh hum kaafi had tak mid keh saath mappping kr rahe
            // honge..
            if (grid[mid / row][mid % col] == target)
                return true;

            if (grid[mid / row][mid % col] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }

}
