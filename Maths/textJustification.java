import java.util.ArrayList;
import java.util.List;

public class textJustification {

    public static List<String> placeWordLineByLine(String[] arr, int maxWidth) {
        int i = 0;
        int n = arr.length;
        List<String> ans = new ArrayList<>();
        while (i < arr.length) {
            int currentWordCount = arr[i].length();
            int spaceCount = 0;
            int j = i + 1;
            while (j < n && currentWordCount + 1 + arr[j].length() + spaceCount <= maxWidth) {
                currentWordCount += arr[j].length();
                spaceCount++;
                j++;
            }
            int remainingSlotsSpace = maxWidth - currentWordCount;
            int extraWordSpace = spaceCount == 0 ? 0 : remainingSlotsSpace / spaceCount;
            int extraSpace = spaceCount == 0 ? 0 : remainingSlotsSpace % spaceCount;
            if (j == n) {
                extraWordSpace = 1;
                extraSpace = 0;
            }
            ans.add(placeString(i, j, extraSpace, extraWordSpace, arr));
            i = j;
        }
        width = maxWidth;
        return ans;
    }

    static int width = 0;

    public static String placeString(int i, int j, int extraSpace, int extraWordSpace, String[] arr) {

        StringBuilder sb = new StringBuilder();

        for (int k = i; k < j; k++) {
            sb.append(arr[i]);
            if (k == j - 1) {
                continue;
            }
            for (int space = 1; space <= extraWordSpace; space++) {
                sb.append(" ");
            }
            if (extraSpace > 0) {
                sb.append(" ");
                extraSpace--;
            }
        }
        while (sb.length() < width) {
            sb.append(" ");
        }
        return sb.toString();
    }
}
