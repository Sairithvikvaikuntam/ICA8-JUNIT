import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Methods {
    public static Boolean goodString(String s) {
        // Checks for the valid Input Strings
        if (s.trim().length() == 0)
            return false;
        Pattern pattern = Pattern.compile("^[0-1]*$");
        if (!pattern.matcher(s).matches()) {
            throw new NumberFormatException("Invalid string");
        }
        return pattern.matcher(s).find();
    }
    public static int countFreeUrinals(String str) {
        //Counts Max number of Urinals available
        boolean inv_match = Pattern.compile("11").matcher(str).find();
        if (inv_match) {
            return -1;
        }
        int count = 0;
        int curr = 0;
        if (str.length() == 0 || str.length() == 1) {
            return 1 - (str.charAt(0) - '0');
        } else if (str.charAt(0) == '0' && str.charAt(1) == '0') {
            count++;
        }
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == '1' && curr != 0) {
                count += Math.floorDiv((curr - 1), 2);
                curr = 0;
            }
            if (str.charAt(i) == '0') {
                curr += 1;
            }
        }
        if (curr != 0) {
            if (curr % 2 == 0) {
                count += Math.floorDiv(curr, 2);
            } else {
                count += Math.floorDiv((curr - 1), 2);
            }
        }
        return count;
}
