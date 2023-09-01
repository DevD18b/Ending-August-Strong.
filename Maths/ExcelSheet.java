package Maths;

public class ExcelSheet {
    public static String solver(int columnNumber) {
        String str = "";
        while (columnNumber != 0) {
            columnNumber--;
            int remainder = columnNumber % 26;
            str += (remainder + 'A');
            remainder /= 26;
        }
        return str;
    }
}
