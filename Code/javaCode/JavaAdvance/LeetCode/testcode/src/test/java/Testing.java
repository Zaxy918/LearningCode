import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Testing {
    @Test
    public void testIntTORoman() {
        assertEquals("MMMDCCXLIX", new com.XII.Solution().intToRoman2(3749));
        assertEquals("LVIII", new com.XII.Solution().intToRoman2(58));
        assertEquals("MCMXCIV", new com.XII.Solution().intToRoman2(1994));
    }
}
