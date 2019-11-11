package leduc;

import leduc.command.ShowCommand;
import leduc.exception.*;
import leduc.storage.Storage;
import leduc.task.TaskList;
import leduc.ui.Ui;
import leduc.ui.UiEn;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class ShowCommandTest {

    private static Ui ui;
    private static Storage storage;
    private static TaskList tasks;

    /**
     * Represents the before of ShowCommandTest.
     */
    @BeforeAll
    public static void beforeShowCommandTest(){
        ui = new UiEn();
        try {
            storage = new Storage(System.getProperty("user.dir")+ "/src/test/java/testFile/testFile.txt", System.getProperty("user.dir")+ "/src/test/java/testFile/configTest.txt",System.getProperty("user.dir")+ "/src/test/java/testFile/welcome.txt");
        } catch (FileException e) {
            e.printStackTrace();
        } catch (MeaninglessException e) {
            e.printStackTrace();
        } catch (NonExistentDateException e) {
            e.printStackTrace();
        }
        tasks = new TaskList(new ArrayList<>());
    }

    @Test
    public void ShowCommandTest(){
        ShowCommand showCommand = new ShowCommand("test");
        int dayOfWeek = 0;
        try {
            dayOfWeek = showCommand.getDayOfWeekInInt("monday");
        } catch (MeaninglessException e) {
            e.printStackTrace();
        }
        assertEquals(1, dayOfWeek);
        try {
            dayOfWeek = showCommand.getDayOfWeekInInt("tuesday");
        } catch (MeaninglessException e) {
            e.printStackTrace();
        }
        assertEquals(2, dayOfWeek);
        try {
            dayOfWeek = showCommand.getDayOfWeekInInt("wednesday");
        } catch (MeaninglessException e) {
            e.printStackTrace();
        }
        assertEquals(3, dayOfWeek);
        try {
            dayOfWeek = showCommand.getDayOfWeekInInt("thursday");
        } catch (MeaninglessException e) {
            e.printStackTrace();
        }
        assertEquals(4, dayOfWeek);
        try {
            dayOfWeek = showCommand.getDayOfWeekInInt("friday");
        } catch (MeaninglessException e) {
            e.printStackTrace();
        }
        assertEquals(5, dayOfWeek);
        try {
            dayOfWeek = showCommand.getDayOfWeekInInt("saturday");
        } catch (MeaninglessException e) {
            e.printStackTrace();
        }
        assertEquals(6, dayOfWeek);
        try {
            dayOfWeek = showCommand.getDayOfWeekInInt("sunday");
        } catch (MeaninglessException e) {
            e.printStackTrace();
        }
        assertEquals(7, dayOfWeek);

        try {
            dayOfWeek = showCommand.getDayOfWeekInInt("aazeadzda");
            fail("The exception should be a MeaninglessException");
        } catch (MeaninglessException e) {
            assertTrue(e instanceof MeaninglessException);
        }

        try {
            ShowCommand showCommand1 = new ShowCommand("show dsqdsqdq");
            showCommand1.execute(tasks, ui, storage);
            fail("The exception should be a WrongParameterException");
        } catch (DukeException e) {
            assertTrue(e instanceof WrongParameterException);
        }

        try {
            ShowCommand showCommand2 = new ShowCommand("show day dqdqd");
            showCommand2.execute(tasks, ui, storage);
            fail("The exception should be a NonExistentDateException");
        } catch (DukeException e) {
            assertTrue(e instanceof NonExistentDateException);
        }
        try {
            ShowCommand showCommand3 = new ShowCommand("show dayofweek dqdqd");
            showCommand3.execute(tasks, ui, storage);
            fail("The exception should be a MeaninglessException");
        } catch (DukeException e) {
            assertTrue(e instanceof MeaninglessException);
        }
        try {
            ShowCommand showCommand3 = new ShowCommand("show month /2019");
            showCommand3.execute(tasks, ui, storage);
            fail("The exception should be a NonExistentDateException");
        } catch (DukeException e) {
            assertTrue(e instanceof NonExistentDateException);
        }
        try {
            ShowCommand showCommand3 = new ShowCommand("show month 01/");
            showCommand3.execute(tasks, ui, storage);
            fail("The exception should be a NonExistentDateException");
        } catch (DukeException e) {
            assertTrue(e instanceof  NonExistentDateException);
        }
        try {
            ShowCommand showCommand3 = new ShowCommand("show month 20/2010");
            showCommand3.execute(tasks, ui, storage);
            fail("The exception should be a NonExistentDateException");
        } catch (DukeException e) {
            assertTrue(e instanceof  NonExistentDateException);
        }
        try {
            ShowCommand showCommand3 = new ShowCommand("show month sqd/dqd");
            showCommand3.execute(tasks, ui, storage);
            fail("The exception should be a NonExistentDateException");
        } catch (DukeException e) {
            assertTrue(e instanceof NonExistentDateException);
        }
        try {
            ShowCommand showCommand3 = new ShowCommand("show year dsqdqs");
            showCommand3.execute(tasks, ui, storage);
            fail("The exception should be a NonExistentDateException");
        } catch (DukeException e) {
            assertTrue(e instanceof NonExistentDateException);
        }
    }
}
