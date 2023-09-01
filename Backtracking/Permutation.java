import java.util.*;

public class Permutation {

    // this is to simple take not take problem...
    static List<List<Integer>> ans;

    public static List<List<Integer>> permutationProblem(int[] arr) {
        ans = new ArrayList<>();

        solver(0, new ArrayList<>(), arr);

        return ans;

    }

    public static void solver(int index, ArrayList<Integer> a, int[] arr) {

        if (a.size() == arr.length) {
            ans.add(new ArrayList<>(a));
            return;
        }

        for (int i : arr) {
            if (a.contains(i) == false) {
                a.add(i);
                solver(index, a, arr);
                a.remove(a.size() - 1);
            }
        }
    }

    public static List<List<Integer>> permutationProblemApproach2(int[] arr) {

        SwappingProblem(0, new ArrayList<>(), arr, new boolean[arr.length]);
        return ans;
    }

    public static void swap(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void SwappingProblem(int index, ArrayList<Integer> a, int[] arr, boolean[] visited) {

        if (index == arr.length) {
            ans.add(new ArrayList<>(a));
            return;
        }

        for (int i = index; i < arr.length; i++) {

            if (!visited[i]) {
                visited[i] = true;
                a.add(arr[i]);
                SwappingProblem(index + 1, a, arr, visited);
                a.remove(a.size() - 1);
                visited[i] = false;
            }

        }

    }

}
