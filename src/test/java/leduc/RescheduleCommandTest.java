package leduc;

import leduc.command.RescheduleCommand;
import leduc.exception.*;
import leduc.storage.Storage;
import leduc.task.*;
import leduc.ui.Ui;
import leduc.ui.UiEn;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertTrue;


/**
 * Represents a JUnit test class for the RescheduleCommand.
 */
public class RescheduleCommandTest {
    private static Ui ui;
    private static Storage storage;
    private static TaskList tasks;

    /**
     * Represents the before of RescheduleCommandTest.
     */
    @BeforeAll
    public static void beforeRescheduleCommandTest(){
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

        LocalDateTime d1 = null;
        LocalDateTime d2 = null;
        Date date1 = null;
        Date date2 = null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm", Locale.ENGLISH);

        tasks.add(new TodoTask("td1"));

        try{
            d1 = LocalDateTime.parse("13/09/2019 01:52".trim(), formatter);
        }catch(Exception e){
            try {
                throw new NonExistentDateException();
            } catch (NonExistentDateException ex) {
                ex.printStackTrace();
            }
        }
        date1 = new Date(d1);
        tasks.add(new HomeworkTask("d1",date1));

        try{
            d1 = LocalDateTime.parse("12/12/2019 22:22".trim(), formatter);
            d2 = LocalDateTime.parse("12/12/2019 22:24".trim(), formatter);
        }catch(Exception e){
            try {
                throw new NonExistentDateException();
            } catch (NonExistentDateException ex) {
                ex.printStackTrace();
            }
        }
        date1 = new Date(d1);
        date2 = new Date(d2);
        tasks.add(new EventsTask("e1",date1,date2));

        tasks.add(new TodoTask("td3"));

        tasks.add(new TodoTask("td4"));

        try{
            d1 = LocalDateTime.parse("13/09/2019 01:52".trim(), formatter);
        }catch(Exception e){
            try {
                throw new NonExistentDateException();
            } catch (NonExistentDateException ex) {
                ex.printStackTrace();
            }
        }
        date1 = new Date(d1);
        tasks.add(new HomeworkTask("d1",date1));

        assertTrue(tasks.size()==6);
    }


    /**
     * Represents a JUnit test method for the RescheduleCommand.
     * Test the command depending on the input String (user).
     */
    @Test
    public void RescheduleCommandTest() {
        RescheduleCommand rescheduleCommand1 = new RescheduleCommand(
                "reschedule 4ee /at 12/12/2222 22:22 - 12/12/2222 22:24");
        try{
            rescheduleCommand1.execute(tasks,ui,storage);
        }
        catch( DukeException e ){
            assertTrue(e instanceof NonExistentTaskException);
        }

        RescheduleCommand rescheduleCommand2 = new RescheduleCommand(
                "reschedule 15 /at 12/12/2222 22:22 - 12/12/2222 22:24");
        try{
            rescheduleCommand2.execute(tasks,ui,storage);
        }
        catch( DukeException e ){
            assertTrue(e instanceof NonExistentTaskException);
        }

        RescheduleCommand rescheduleCommand3 = new RescheduleCommand(
                "reschedule 2 /at 12/12/2222 22:22 - 12/12/2222 22:24");
        try{
            rescheduleCommand3.execute(tasks,ui,storage);
        }
        catch( DukeException e ){
            assertTrue(e instanceof EventTypeException);
        }

        RescheduleCommand rescheduleCommand4 = new RescheduleCommand("reschedule 3");
        try{
            rescheduleCommand4.execute(tasks,ui,storage);
        }
        catch( DukeException e ){
            assertTrue(e instanceof EmptyEventDateException);
        }

        RescheduleCommand rescheduleCommand5 = new RescheduleCommand(
                "reschedule 3 /at 12/12/22a2 22:22 - 12/12/2222 22:24");
        try{
            rescheduleCommand5.execute(tasks,ui,storage);
        }
        catch( DukeException e ){
            assertTrue(e instanceof NonExistentDateException);
        }


        RescheduleCommand rescheduleCommand6 = new RescheduleCommand(
                "reschedule 3 /at 12/12/2222 22:22 - 12/12/1222 22:24");
        try{
            rescheduleCommand6.execute(tasks,ui,storage);
        }
        catch( DukeException e ){
            assertTrue(e instanceof DateComparisonEventException);
        }

        RescheduleCommand rescheduleCommand7 = new RescheduleCommand(
                "reschedule 3 /at 12/12/2019 22:22 - 12/12/2019 22:24");
        try{
            rescheduleCommand7.execute(tasks,ui,storage);
        }
        catch( DukeException e ){
            assertTrue(e instanceof ConflictDateException);
        }
    }

    /**
     * Represents the after of RescheduleCommandTest.
     */
    @AfterAll
    public static void afterRescheduleCommandTest(){
        tasks.getList().removeAll(tasks.getList());
        try {
            storage.save(tasks.getList());
        }
        catch(FileException f){
            assertTrue(false);
        }
        assertTrue(tasks.size()==0);
    }
}
