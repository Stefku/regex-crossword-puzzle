package regex;

import java.util.regex.Pattern;

public class Expression {

    private final Pattern pattern;


    public Expression(String pattern) {
        this.pattern = Pattern.compile(pattern);
    }

    @SuppressWarnings("QuestionableName")
    public boolean check(CharSequence string) {
        return pattern.matcher(string).matches();
    }

    @Override
    public String toString() {
        return "Expression{" +
                "pattern=" + pattern +
                '}';
    }
}
