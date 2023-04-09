import ex04.*;
import ex02.Result;
import ex03.ViewTable;
import org.junit.Assert;
import org.junit.Test;
import ex02.ViewResult;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.Random;

/** Тестирование класса
 * ChangeItemCommand
 * @author xone
 * @version 4.0
 * @see ChangeItemCommand
 */
public class Task05Test {
    /** Проверка метода {@linkplain ChangeItemCommand#execute()} */
    @Test
    public void testExecute() {
        ChangeItemCommand cmd = new ChangeItemCommand();
        cmd.setItem(new Result());
        Random ran = new Random();
        int x, y, offset;
        for (int ctr = 0; ctr < 1000; ctr++) {
            cmd.getItem().setVal(x = ran.nextInt(50));
            cmd.getItem().setArg(y = ran.nextInt(50));
            cmd.setOffset(offset = ran.nextInt(50));
            cmd.execute();
            Assertions.assertEquals(y, cmd.getItem().getArgInt());
            Assertions.assertEquals(x * offset, cmd.getItem().getValInt());
        }
    }



    /** Проверка класса {@linkplain ChangeConsoleCommand} */
    @Test
    public void testChangeConsoleCommand() {
        ChangeConsoleCommand cmd = new ChangeConsoleCommand(new ViewResult());
        cmd.getView().viewInit(1,23);
        cmd.execute();
        Assertions.assertEquals("'c'hange", cmd.toString());
        Assertions.assertEquals('c', cmd.getKey());
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
        Assertions.assertEquals(tbl1.getItems().size(), tbl2.getItems().size());
        Assert.assertEquals(result.get(1).getValue(), result2.get(1).getValue());
    }
}