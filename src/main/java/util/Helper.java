package util;


public class Helper {

    public static String getFirstWord(String inp) {
        String[] strArr = inp.trim().split(" ", 2);
        return strArr[0];
    }

    public static String getArgument(String inp) {
        String[] strArr = inp.trim().split(" ", 2);
        if (strArr.length <= 1) {
            return "";
        }
        return strArr[1];
    }
}
