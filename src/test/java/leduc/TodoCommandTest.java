package leduc;

import leduc.command.TodoCommand;
import leduc.exception.*;
import leduc.storage.Storage;
import leduc.task.TaskList;
import leduc.ui.Ui;
import leduc.ui.UiEn;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Represents a JUnit test class for the TodoCommand.
 */
public class TodoCommandTest {
    private static Ui ui;
    private static Storage storage;
    private static TaskList tasks;

    /**
     * Represents the before of TodoCommandTest.
     */
    @BeforeAll
    public static void beforeTodoCommandTest(){
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
        assertTrue(tasks.size()==0);
    }
    /**
     * Represents a JUnit test method for the TodoCommand.
     * Test the command depending on the input String (user).
     */
    @Test
    public void TodoCommandTest() {
        TodoCommand todoCommand1 = new TodoCommand("todo ok");
        try{
            todoCommand1.execute(tasks,ui,storage);
        }
        catch( DukeException e ){
            assertTrue(false);
        }
        assertTrue(tasks.size()==1);
        assertTrue(tasks.get(0).getPriority() ==5);

        TodoCommand todoCommand2= new TodoCommand("todo prio");
        try{
            todoCommand2.execute(tasks,ui,storage);
        }
        catch( DukeException e ){
            assertTrue(false);
        }
        assertTrue(tasks.size()==2);
        assertTrue(tasks.get(0).getPriority() ==5);
        assertTrue(tasks.get(1).getPriority() ==5);

        TodoCommand todoCommand3= new TodoCommand("todo okprio");
        try{
            todoCommand3.execute(tasks,ui,storage);
        }
        catch( DukeException e ){
            assertTrue(false);
        }
        assertTrue(tasks.size()==3);
        assertTrue(tasks.get(0).getPriority() ==5);
        assertTrue(tasks.get(1).getPriority() ==5);
        assertTrue(tasks.get(2).getPriority() ==5);


        TodoCommand todoCommand4= new TodoCommand("todo");
        try{
            todoCommand4.execute(tasks,ui,storage);
        }
        catch( DukeException e ){
            assertTrue(e instanceof EmptyTodoException);
        }
        assertTrue(tasks.size()==3);
        assertTrue(tasks.get(0).getPriority() ==5);
        assertTrue(tasks.get(1).getPriority() ==5);
        assertTrue(tasks.get(2).getPriority() ==5);


        TodoCommand todoCommand5= new TodoCommand("todo prio 5");
        try{
            todoCommand5.execute(tasks,ui,storage);
        }
        catch( DukeException e ){
            assertTrue(e instanceof EmptyTodoException);
        }
        assertTrue(tasks.size()==3);
        assertTrue(tasks.get(0).getPriority() ==5);
        assertTrue(tasks.get(1).getPriority() ==5);
        assertTrue(tasks.get(2).getPriority() ==5);

        TodoCommand todoCommand6= new TodoCommand("todo priotask");
        try{
            todoCommand6.execute(tasks,ui,storage);
        }
        catch( DukeException e ){
            assertTrue(false);
        }
        assertTrue(tasks.size()==4);
        assertTrue(tasks.get(0).getPriority() ==5);
        assertTrue(tasks.get(1).getPriority() ==5);
        assertTrue(tasks.get(2).getPriority() ==5);
        assertTrue(tasks.get(3).getPriority() ==5);


        TodoCommand todoCommand7= new TodoCommand("todo td prio 23");
        try{
            todoCommand7.execute(tasks,ui,storage);
        }
        catch( DukeException e ){
            assertTrue(e instanceof PrioritizeLimitException);
        }
        assertTrue(tasks.size()==4);
        assertTrue(tasks.get(0).getPriority() ==5);
        assertTrue(tasks.get(1).getPriority() ==5);
        assertTrue(tasks.get(2).getPriority() ==5);
        assertTrue(tasks.get(3).getPriority() ==5);

        TodoCommand todoCommand8= new TodoCommand("todo td prio 2");
        try{
            todoCommand8.execute(tasks,ui,storage);
        }
        catch( DukeException e ){
            assertTrue(e instanceof PrioritizeLimitException);
        }
        assertTrue(tasks.size()==5);
        assertTrue(tasks.get(0).getPriority() ==5);
        assertTrue(tasks.get(1).getPriority() ==5);
        assertTrue(tasks.get(2).getPriority() ==5);
        assertTrue(tasks.get(3).getPriority() ==5);
        assertTrue(tasks.get(4).getPriority() ==2);
    }

    /**
     * Represents the after of TodoCommandTest.
     */
    @AfterAll
    public static void afterTodoCommandTest(){
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
