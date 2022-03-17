
import static org.junit.Assert.*;

public class TestOffByOne {
    /*
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.*/
    static CharacterComparator offByOne = new OffByOne();

    public void testEqualChars() {
        assertTrue(offByOne.equalChars('a', 'u'));
        assertTrue(offByOne.equalChars('w', 'j'));
        assertFalse(offByOne.equalChars('y', 'o'));
    }
}
