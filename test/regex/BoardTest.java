package regex;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BoardTest {
    @Test
    public void expressionIsTrue() throws Exception {
        Expression expression = new Expression("(DI|NS|TH|OM)*", "DITH");

        assertTrue(expression.check());
    }

    @Test
    public void expressionIsFalse() throws Exception {
        Expression expression = new Expression("(DI|NS|TH|OM)*", "DIT");

        assertFalse(expression.check());
    }

}
