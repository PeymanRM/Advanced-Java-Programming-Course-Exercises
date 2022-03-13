package homework3;

/**
 * Created by Peyman RM
 */
public class StringAnalyzer {
    private String str;

    public StringAnalyzer(String str){
        this.str = str;
    }

    public int analyse() throws NumberException {
        String trimmedStr = str.trim();
        for (int i = 0; i < trimmedStr.length(); i++) {
            if(trimmedStr.charAt(i) > 47 && trimmedStr.charAt(i) < 58) throw new NumberException("Provided string has number!");
        }
        return str.length();
    }
}
