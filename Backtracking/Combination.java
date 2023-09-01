import java.util.*;

public class Combination {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        solver(0, n, k, ans, new ArrayList<>());
        return ans;
    }

    // at every index we need to take a decision that
    // kyaa meh yeh index keh corresponding number consider kru naa ni karu.
    public static void solver(int index, int n, int k, List<List<Integer>> ans, List<Integer> operationArray) {

        // if the index is out of range then return simpliiii.. check kii kya mene mere
        // k combination bana diya hai
        // if it is true simple return the ansList.

        if (index > n) {
            if (k == 0) {
                ans.add(new ArrayList<>(operationArray));
            }
            return;
        }

        // we need to make k-digits combination of the numbers ranges from [1,n];
        // and now what we have two choices take or not take.

        operationArray.add(index);
        solver(index + 1, n, k - 1, ans, operationArray);
        operationArray.remove(operationArray.size() - 1);
        solver(index + 1, n, k, ans, operationArray);
    }
}