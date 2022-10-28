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

    public static String[] readFromFile(String path) throws IOException {
        // Reading File for String
        List<String> input = new ArrayList<>();
        BufferedReader b = new BufferedReader(new FileReader(path));
        String z = b.readLine();
        while (z != null) {
            input.add(z);
            z = b.readLine();
        }
        b.close();
        return input.toArray(new String[0]);
    }

    public void writeToFile(String[] inputs) throws IOException {
        // Writing output to file.
        String oFN = writeToOutputFile();
        File outputFile = new File("./" + oFN);
        StringBuilder output = new StringBuilder();
        for (String line : inputs) {
            if (goodString(line))
                output.append(this.countFreeUrinals(line)).append("\n");
        }
        Files.write(outputFile.toPath(), output.toString().getBytes());
        System.out.println("Output written to " + oFN);
    }

    public static String writeToOutputFile() {
        File f = new File("./rule.txt");
        if (!f.exists()) return "rule.txt";
        File fol = new File("./");
        File[] files = fol.listFiles();
        int count = 0;
        assert files != null;
        for (File x : files) {
            if (x.isFile()) {
                String fileName = x.getName();
                if (fileName.contains("rule")) count ++;
            }
        }
        return "rule" + count + ".txt";
    }
}
