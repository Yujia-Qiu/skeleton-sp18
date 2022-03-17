import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestOffByN {
    static CharacterComparator offByN;

    @Test
    public void testEqualChars() {
        offByN = new OffByN(3);
        assertTrue(offByN.equalChars('a', 'd'));
        assertTrue(offByN.equalChars('g', 'd'));
        assertFalse(offByN.equalChars('a', 'a'));
    }
}
