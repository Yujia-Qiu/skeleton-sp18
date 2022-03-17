import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestOffByN {
    /*
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset. */
    static CharacterComparator offByN = new OffByOne();

    public void testEqualChars() {
        assertTrue(offByN.equalChars('a', 'u'));
        assertTrue(offByN.equalChars('w', 'j'));
        assertFalse(offByN.equalChars('y', 'o'));
    }
}
