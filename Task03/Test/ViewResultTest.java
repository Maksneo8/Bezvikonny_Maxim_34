import ex02.Result;
import ex02.ViewResult;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;


public class ViewResultTest {

    private static ViewResult viewResult;

    @Before
    public void setUp() {
        viewResult = new ViewResult();
    }

    @After
    public void tearDownAfterClass() {

        viewResult = null;
    }

    @Test
    public void testGetItems() {
        ArrayList<Result> items = viewResult.getItems();
        assertEquals(10, items.size());
    }

    @Test
    public void testInit() {
        viewResult.init(1, 2);
        ArrayList<Result> items = viewResult.getItems();
        assertEquals("Argument 0: 0 (binary)", items.get(0).getValue());
        assertEquals("Argument 2: 10 (binary)", items.get(1).getValue());
        assertEquals("Argument 4: 100 (binary)", items.get(2).getValue());
    }

    @Test
    public void testSaveAndRestore() throws Exception {
        ArrayList<Result> items = viewResult.getItems();
        viewResult.init(1, 2);
        viewResult.viewSave();

        try {
            viewResult.viewRestore();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        assertEquals("Argument 0: 0 (binary)", items.get(0).getValue());
        assertEquals("Argument 2: 10 (binary)", items.get(1).getValue());
        assertEquals("Argument 4: 100 (binary)", items.get(2).getValue());
    }
}
