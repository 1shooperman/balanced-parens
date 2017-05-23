import org.junit.*;
import static org.junit.Assert.*;

public class BalancedTest {
    
    @Test
    public void truthy() {
        assertTrue("{} is balanced", Balanced.answer("{}"));
        assertTrue("[] is balanced", Balanced.answer("[]"));
        assertTrue("() is balanced", Balanced.answer("()"));
        assertFalse("}{ is not balanced", Balanced.answer("}{"));
        assertFalse("][ is not balanced", Balanced.answer("]["));
        assertFalse(")( is not balanced", Balanced.answer(")("));
    }
    
    @Test
    public void singleLeft() {
        assertFalse("{ is not balanced", Balanced.answer("{"));
        assertFalse("[ is not balanced", Balanced.answer("["));
        assertFalse("( is not balanced", Balanced.answer("("));
    }

    @Test
    public void singleRight() {
        assertFalse("} is not balanced", Balanced.answer("}"));
        assertFalse("] is not balanced", Balanced.answer("]"));
        assertFalse(") is not balanced", Balanced.answer(")"));
    }

    @Test
    public void exampleSeries() {
        assertFalse("{{)(}} is not balanced", Balanced.answer("{{)(}}"));
        assertFalse("{{)(}}} is not balanced", Balanced.answer("{{)(}}}"));
        assertFalse("({)} is not balanced", Balanced.answer("({)}"));
        assertTrue("[({})] is balanced", Balanced.answer("[({})]")); 
        assertTrue("{}([]) is balanced", Balanced.answer("{}([])"));
        assertTrue("{()}[[{}]] is balanced", Balanced.answer("{()}[[{}]]"));
        assertFalse("}{()() is not balanced", Balanced.answer("}{()()"));
    }
    
    @Test
    public void withSpace() {
         assertTrue("{ ( ) } is balanced", Balanced.answer("{ ( ) }"));
        assertFalse("{_ is not balanced", Balanced.answer("{ "));
        assertFalse("_} is not balanced", Balanced.answer(" }"));
    }
    
    @Test
    public void emptyString() {
         assertTrue(" is balanced", Balanced.answer(""));
        assertTrue("__ is balanced", Balanced.answer(" "));
        assertTrue("__ is balanced", Balanced.answer(null));
    }
}

