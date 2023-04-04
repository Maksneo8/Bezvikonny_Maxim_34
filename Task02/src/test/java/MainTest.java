import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CalcTest {

    private static Calc calc;

    @BeforeAll
    static void setUpBeforeClass() {
        calc = new Calc();
    }

    @AfterAll
     static void tearDownAfterClass() {
        calc = null;
    }

    @Test
    void testToBinaryString() {
        assertEquals("1010", calc.toBinaryString(10));
    }

    @Test
    void testToOctalString() {
        assertEquals("12", calc.toOctalString(10));
    }

    @Test
    void testToHexString() {
        assertEquals("a", calc.toHexString(10));
    }

    @Test
    void testSaveAndRestore() throws Exception {

        calc.SetDig(10);
        calc.Choice(1);
        calc.save();


        try {
            calc.restore();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        assertEquals("1010", calc.getResult().getValue());
    }
}

