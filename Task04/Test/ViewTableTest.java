import ex02.Result;
import ex03.ViewTable;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ViewTableTest {

    private static ViewTable viewTable;

    @Before
    public void setUp() {
        viewTable = new ViewTable();


    }

    @Test
    public void testSetWidth() {
        assertEquals(50, viewTable.getWidth());
        int newWidth = 100;
        viewTable.setWidth(newWidth);
        assertEquals(newWidth, viewTable.getWidth());
    }



    @org.junit.Test
    public void testSaveAndRestore() throws Exception {
        ViewTable tbl1 = new ViewTable();
        ViewTable tbl2 = new ViewTable();
        tbl1.init(1, 2);
        ArrayList<Result> result = tbl1.getItems();
        tbl1.viewSave();

        try {
            tbl2.viewRestore();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        ArrayList<Result> result2 = tbl2.getItems();
        assertEquals(tbl1.getItems().size(), tbl2.getItems().size());
        Assert.assertEquals(result.get(1).getValue(), result2.get(1).getValue());
    }
}
