import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Methods {
    public static Boolean goodString(String s) {
        if (s.trim().length() == 0)
            return false;
        Pattern pattern = Pattern.compile("^[0-1]*$");
        if (!pattern.matcher(s).matches()) {
            throw new NumberFormatException("Invalid string");
        }
        return pattern.matcher(s).find();
    }
}
