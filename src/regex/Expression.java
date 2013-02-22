package regex;

import java.util.regex.Pattern;

public class Expression {

    private final Pattern pattern;


    public Expression(String pattern) {
        this.pattern = Pattern.compile(pattern);
    }

    public boolean check(String string) {
        return pattern.matcher(string).matches();
    }
}
