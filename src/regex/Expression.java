package regex;

import java.util.regex.Pattern;

/**
 * This class ... TODO
 */
public class Expression {

    private final Pattern pattern;
    private final String string;


    public Expression(String regex, String string) {
        this.pattern = Pattern.compile(regex);
        this.string = string;
    }

    public boolean check() {
        return pattern.matcher(string).matches();
    }
}
