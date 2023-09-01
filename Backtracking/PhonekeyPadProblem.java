import java.util.*;

public class PhonekeyPadProblem {
    static HashMap<Character, String> map = new HashMap<>();
    static List<String> ans = new ArrayList<>();

    public static void solver(int index, String str, StringBuilder ansString) {

        // base case can be aapne saare possible values ko call kr liya hai...

        if (index == str.length()) {
            ans.add(ansString.toString());
            return;
        }

        char ch = str.charAt(index);
        String number = map.get(ch);

        for (int i = 0; i < number.length(); i++) {
            ansString.append(number.charAt(i));

            // 23 --> ad ae af bd be bf aisa kuch ban raha hoga.
            // toh there is a thing keh yrr...
            // yaa toh meh consider kr luu yeh number yaa fir meh nhi karu yeh number.
            solver(index + 1, str, ansString);
            ansString.deleteCharAt(ansString.length() - 1);
        }
    }

    public static List<String> driverFunction(String str) {
        if (str.length() == 0)
            return new ArrayList<>();

        map.put('2', "abc");
        map.put('3', "abc");
        map.put('4', "abc");
        map.put('5', "abc");
        map.put('6', "abc");
        map.put('7', "abc");
        map.put('8', "abc");
        map.put('9', "abc");

        solver(0, str, new StringBuilder());

        return ans;
    }

}