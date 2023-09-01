package DynamicProgramming;

import java.util.HashSet;

public class WordBreak {

    static HashSet<String> set = new HashSet<>();

    public static boolean DriverFunction(String targetString, String[] wordDictionary) {

        for (String word : wordDictionary) {
            set.add(word);
        }

        return solver(0, targetString);

    }

    public static boolean solver(int index, String operationsString) {
        if (index == operationsString.length()) // it means we have found out the whole string into dictionary.
            return true;

        // if it is already present in the set we will return true.
        if (set.contains(operationsString))
            return true;

        for (int i = index; i < operationsString.length(); i++) {
            String tukdaTukdaMehStringDistribution = operationsString.substring(index, i + 1);

            // target string is --> leetcode and word dictionary is --> "leet","code"...
            // so humm naa aise distribute karenge le, lee , leet aise string ko develop
            // krte rahenge.
            // and now what can i do is t tk toh search hoo gaya. and now code bach gaya hai
            // so we call recursively(i+1 , operationstring)....

            if (set.contains(tukdaTukdaMehStringDistribution) && solver(i + 1, operationsString)) {
                return true;
            }
        }
        return false;
    }
}
