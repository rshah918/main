package leduc.ui;

import leduc.exception.*;
import leduc.task.EventsTask;
import leduc.task.HomeworkTask;
import leduc.task.Task;
import leduc.task.TaskList;
import leduc.ui.Ui;

import java.util.ArrayList;


public class UiEn extends Ui {
    public UiEn() {
        super();
    }
    @Override
    public void showBye(){
        super.display("\t Bye. Hope to see you again soon!");
    }

    @Override
    public void showDelete(Task removedTask, int size) {
        super.display("\t Noted. I've removed this task: \n" +
                "\t\t" + removedTask.toString() +
                "\n\t Now you have "+ size +" tasks in the list");
    }

    @Override
    public void showDone(Task doneTask) {
        super.display("\t Nice! I've marked this task as done:\n\t " + doneTask.toString());
    }

    @Override
    public void showTask(Task newTask, int size) {
        super.display("\t Got it. I've added this task:\n\t   "
                + newTask.toString() +
                "\n\t Now you have " + size + " tasks in the list.");
    }

    @Override
    public void showFindMatching(String result) {
        super.display("\t Here are the most relevant tasks in your list:\n" + result);
    }

    @Override
    public void showFindNotMatching() {
        super.display("\t There is no matching tasks in your list");
    }
    @Override
    public void showList(TaskList tasks){
        System.out.println("\t---------------------------------------------------------------------------------");
        System.out.println("\t Here are the tasks in your list:");
        for (int i = 0 ;i< tasks.size() ; i++ ){
            System.out.print(tasks.displayOneElementList(i));
        }
        System.out.println("\t---------------------------------------------------------------------------------");
    }
    @Override
    public void showNoTask() {
        super.display("\t There aren't any tasks!! ");
    }

    @Override
    public void showPostpone(HomeworkTask postponeTask) {
        super.display("\t Noted. I've postponed this task: \n" +
                "\t\t "+postponeTask.getTag() + postponeTask.getMark() + " " + postponeTask.getTask()+
                " by:" + postponeTask.getDeadlines() + "\n");
    }

    @Override
    public void showPrioritize(Task task) {
        super.display("\t Got it. I've set the priority of this task:\n\t   "
                + task.toString());
    }
    @Override
    public void showReschedule(EventsTask rescheduleTask) {
        super.display("\t Noted. I've rescheduled this task: \n" +
                "\t\t "+rescheduleTask.getTag() + rescheduleTask.getMark() + " " +
                rescheduleTask.getTask()+ " at:" + rescheduleTask.getDateFirst() +
                " - " + rescheduleTask.getDateSecond() + "\n");
    }

    @Override
    public void showNewWelcome(String welcomeMessage) {
        super.display("\t The welcome message is edited: " + welcomeMessage);
    }

    @Override
    public void showSnooze(HomeworkTask snoozeTask) {
        super.display("\t Noted. I've snoozed this task: \n" +
                "\t\t "+snoozeTask.getTag() + snoozeTask.getMark() + " " + snoozeTask.getTask()+
                " by:" + snoozeTask.getDeadlines() + "\n");
    }

    @Override
    public void showSort() {
        super.display("\t This is the new task list order: ");
    }
/* @@author rshah918 */
    @Override
    public void showGeneralStats(double numTasks, double numTodos, double numEvents, double numHomework, double numIncomplete, double numComplete, double percentComplete) {
        String message = "Here are some general statistics about your task list: \n" +
                "Number of tasks: " + numTasks + "\n" +
                "Number of Todo's : " + numTodos + "\n" +
                "Number of Events: " + numEvents + "\n" +
                "Number of Homeworks: " + numHomework + "\n" +
                "Number of Uncompleted Tasks: " + numIncomplete + "\n" +
                "Number of Completed Tasks: " + numComplete + "\n" +
                "Percent Complete: " + percentComplete + "%";

        super.display(message);
    }
    @Override
    public void showPriorityStats(int numNinePrio, int numEightPrio, int numSevenPrio, int numSixPrio, int numFivePrio, int numFourPrio, int numThreePrio, int numTwoPrio, int numOnePrio, double percentNinePrio, double percentEightPrio,double percentSevenPrio, double percentSixPrio, double percentFivePrio, double percentFourPrio, double percentThreePrio, double percentTwoPrio, double percentOnePrio){
        String message = "Here are some priority statistics about your task list: \n" +
                "----PRIORITY COUNTS----" + "\n" +
                "Number of tasks with priority 9: " + numNinePrio + "\n" +
                "Number of tasks with priority 8: " + numEightPrio + "\n" +
                "Number of tasks with priority 7: " + numSevenPrio + "\n" +
                "Number of tasks with priority 6: " + numSixPrio + "\n" +
                "Number of tasks with priority 5: " + numFivePrio + "\n" +
                "Number of tasks with priority 4: " + numFourPrio + "\n" +
                "Number of tasks with priority 3: " + numThreePrio + "\n" +
                "Number of tasks with priority 2: " + numTwoPrio + "\n" +
                "Number of tasks with priority 1: " + numOnePrio + "\n" +
                "----PRIORITY PERCENTAGES----" + "\n" +
                "Percent of tasks with priority 9: " + percentNinePrio + "%" + "\n" +
                "Percent of tasks with priority 8: " + percentEightPrio + "%" + "\n" +
                "Percent of tasks with priority 7: " + percentSevenPrio + "%" + "\n" +
                "Percent of tasks with priority 6: " + percentSixPrio + "%" + "\n" +
                "Percent of tasks with priority 5: " + percentFivePrio + "%" + "\n" +
                "Percent of tasks with priority 4: " + percentFourPrio + "%" + "\n" +
                "Percent of tasks with priority 3: " + percentThreePrio + "%" + "\n" +
                "Percent of tasks with priority 2: " + percentTwoPrio + "%" + "\n" +
                "Percent of tasks with priority 1: " + percentOnePrio + "%";
        super.display(message);
    }
    @Override
    public void showCompletionStats( int numIncompleteHomework, int numIncompleteTodo, int numIncompleteEvent,
                                     double percentIncompleteHomework, double percentIncompleteTodo, double percentIncompleteEvent){
        String message = "Here are some completion statistics about your task list: \n" +
                "----COMPLETION COUNTS----" + "\n" +
                "Number of incomplete Homeworks remaining: " + numIncompleteHomework + "\n" +
                "Number of incomplete Todos remaining: " + numIncompleteTodo + "\n" +
                "Number of incomplete Events  remaining: " + numIncompleteEvent + "\n" +
                "----COMPLETION PERCENTAGES----" + "\n" +
                "Percent of incomplete Homework: " + percentIncompleteHomework + "%" + "\n" +
                "Percent of incomplete Todo: " + percentIncompleteTodo + "%" + "\n" +
                "Percent of incomplete Events: " + percentIncompleteEvent + "%";
        super.display(message);
    }
    @Override
    public void showUnFinishedTasks(ArrayList<Task> unfinishedTasks) {
        //print the task so they have the same index
        String result = "";
        TaskList unfinishedTaskList = new TaskList(unfinishedTasks);
        for(int i = 0; i < unfinishedTaskList.size(); i++){
            result += unfinishedTaskList.displayOneElementList(i);
        }
        if(result.equals("")){
            System.out.println("\t---------------------------------------------------------------------------------");
            System.out.println("\t There are no unfinished tasks in your list");
            System.out.println("\t---------------------------------------------------------------------------------");
        }
        else {
            System.out.println("\t---------------------------------------------------------------------------------");
            System.out.println("\t Here are the unfinished tasks in your list:");
            System.out.println(result);
            System.out.println("\t---------------------------------------------------------------------------------");
        }
    }

/* @@author */
    @Override
    public void showHelp(){
        System.out.println("\t---------------------------------------------------------------------------------");
        System.out.println("\t All command will be display as :");
        System.out.println("\t commandName [PARAMETERS] : description of the command");
        System.out.println("\t All parameters will be written in UPPER_CASE");
        System.out.println("\t Parameters are :");
        System.out.println("\t DESCRIPTION : the description of a task");
        System.out.println("\t SORTTYPE : date, description, priority, type or done");
        System.out.println("\t DATE : the date of a task");
        System.out.println("\t INDEX : the index of the task (goes from 1 to ...)");
        System.out.println("\t KEYWORD : the keyword to find a task");
        System.out.println("\t WELCOME: the welcome message");
        System.out.println("\t DATEOPTION");
        System.out.println("\t Date format is DD/MM/YYYY HH:mm except for show");
        System.out.println("\t All blank space should be respected");
        System.out.println("\t Here are the list of all command:");
        System.out.println("\t todo DESCRIPTION prio INDEX: create a todo task ( prio index is optional) with priority index");
        System.out.println("\t homework DESCRIPTION /by DATE prio INDEX recu DATEOPTION INDEX: create a homework task ( prio index is optional) with priority index" +
                " (recu is optional) with a recurrence of DATEOPTION(day, week, month) and the number of recurrence of INDEX");
        System.out.println("\t event DESCRIPTION /at DATE - DATE prio INDEX  recu DATEOPTION INDEX: create an event task ( prio index is optional) with priority index" +
                " (recu is optional) with a recurrence of DATEOPTION(day, week, month) and the number of recurrence of INDEX");
        System.out.println("\t list : show all the tasks");
        System.out.println("\t bye : exit the application");
        System.out.println("\t done INDEX : mark as done the task of index INDEX");
        System.out.println("\t delete INDEX : delete the task of index INDEX");
        System.out.println("\t find KEYWORD : find the task with a keyword");
        System.out.println("\t snooze INDEX : snooze a task of index INDEX");
        System.out.println("\t postpone INDEX /by DATE : postpone a deadline task");
        System.out.println("\t sort SORTTYPE : Sort all task by date/description/priority/type/done or not");
        System.out.println("\t reschedule INDEX /at DATE - DATE : reschedule an event task");
        System.out.println("\t remind : remind the first three task");
        System.out.println("\t setwelcome WELCOME : customize the welcome message");
        System.out.println("\t edit :\n\t\t For multi-step command : 'edit' and then follow the instructions" +
                           "\n\t\t For one shot command:" +
                           "\n\t\t\t edit the description: 'edit INDEX description DESCRIPTION' " +
                           "\n\t\t\t edit the date of an homework task: 'edit INDEX /by DATE' " +
                           "\n\t\t\t edit the period of an event task: 'edit INDEX /at DATE - DATE' ");
        System.out.println("\t show DATEOPTION DATE: show task by day/dayofweek/month/year ( day format is DD/MM/YYYY; " +
                "dayofweek format is monday,tuesday...; month format is MM/YYYY; year format is YYYY)");
        System.out.println("\t prioritize INDEX prio INDEX : give priority to task");
        System.out.println("\t unfinished: Find and display all unfinished tasks");
        System.out.println("\t language LANG: change the language of the program at the next execution. LANG is equal to en or fr");
        System.out.println("\t help : show the list of all command");
        System.out.println("\t---------------------------------------------------------------------------------");
    }

    @Override
    public void showLanguage(String lang) {
        super.display("This is the language that will be used after the next execution :" + lang);
    }

    @Override
    public void showEditChooseTask() {
        super.display("\t Please choose the task to edit from the list by its index: ");
    }

    @Override
    public void showEdit2Choice() {
        super.display("\t Please choose what you want to edit (1 or 2)\n\t 1. The description " +
                "\n\t 2. The deadline/period");
    }

    @Override
    public void showEditWhat(String choice) {
        super.display("\t Please enter the new " + choice + " of the task");
    }

    @Override
    public void showEdit(Task task) {
        super.display("\t The task is edited: \n\t " + task.toString());
    }

    @Override
    public void showAskShortcut(String commandName) {
        super.display("Please enter a shortcut for " + commandName);
    }

    @Override
    public void showAskAllShortcut(String commmandName, String shortcutName) {
        super.display("The precedent shortcut for "+commmandName+ " is " + shortcutName +" please enter new shortcut");
    }

    @Override
    public void showOneShortcutSet(String commandName) {
        super.display("The shortcut for " + commandName +" has been set");
    }

    @Override
    public void showAllShortcutSet() {
        super.display("All shortcut has been set");
    }

    @Override
    public void showEnterDayShow() {
        System.out.println("You have enter the show day mode. Please enter the day as : DD/MM/YYYY");
    }

    @Override
    public void showEnterDayOfWeekShow() {
        System.out.println("You have enter the show day of week mode. Please enter the day of the week as : monday, tuesday, wednesday, thursday, friday, saturday, sunday");
    }

    @Override
    public void showEnterMonthShow() {
        System.out.println("You have enter the show month mode. Please enter the month as : MM/YYYY");
    }

    @Override
    public void showEnterYearShow() {
        System.out.println("You have enter the show year mode. Please enter the year as : YYYY");
    }

    @Override
    public void showNotCompleteList(ArrayList<Task> notCompleteTasks, TaskList tasks) {
        System.out.println("\t---------------------------------------------------------------------------------");
        System.out.println("\t Here are the tasks in your list:");
        for(int i = 0; i < tasks.size(); i++){
            if(notCompleteTasks.contains(tasks.get(i))){
                System.out.print(tasks.displayOneElementList(i));
            }
        }
        System.out.println("\t---------------------------------------------------------------------------------");
    }

    @Override
    public void showError(DukeException e) {
        if(e instanceof ConflictDateException){
            String conflictTasks = "";
            for (Task t : ((ConflictDateException)e).getTasks()){
                conflictTasks += "\n\t\t\t" + t.toString();
            }

            System.out.println("\t ConflictDateException:\n\t\t ☹ OOPS!!! There is a date conflict with this event :" +
                    conflictTasks);
        }
        else if(e instanceof DateComparisonEventException){
            System.out.println("\t DateComparisonEventException:\n\t\t ☹ OOPS!!! The second date should not be before the first one.");
        }
        else if(e instanceof DuplicationShortcutException){
            System.out.println("\t DuplicationShortcutException:\n\t\t ☹ OOPS!!! The shortcut already exists");
        }
        else if(e instanceof EmptyArgumentException){
            System.out.println("\t EmptyArgumentException:\n\t\t ☹ OOPS!!! There should have an argument");
        }
        else if(e instanceof EmptyEventDateException){
            System.out.println("\t emptyEventDateException:\n\t\t ☹ OOPS!!! Please enter a period for the event task");
        }
        else if(e instanceof EmptyEventException){
            System.out.println("\t emptyEventException:\n\t\t ☹ OOPS!!! The description of a event task cannot be empty");
        }
        else if(e instanceof EmptyHomeworkDateException){
            System.out.println("\t emptyHomeworkDateException:\n\t\t ☹ OOPS!!! Please enter a deadline for the task");
        }
        else if(e instanceof EmptyHomeworkException){
            System.out.println("\t emptyHomeworkException:\n\t\t ☹ OOPS!!! The description of a homework task cannot be empty");
        }
        else if(e instanceof EmptyTodoException){
            System.out.println("\t emptyTodoException:\n\t\t ☹ OOPS!!! The description of a todo cannot be empty.");
        }
        else if(e instanceof EventTypeException){
            System.out.println("\t EventTypeException:\n\t\t ☹ OOPS!!! The task should be a event task");
        }
        else if(e instanceof FileException){
            System.out.println("File doesn't exist or cannot be created or cannot be opened");
        }
        else if(e instanceof HomeworkTypeException){
            System.out.println("\t HomeworkTypeException:\n\t\t ☹ OOPS!!! The task should be a homework task");
        }
        else if(e instanceof MeaninglessException){
            System.out.println("\t MeaninglessException:\n\t\t OOPS!!! I'm sorry, but I don't know what that means :-(\"");
        }
        else if(e instanceof NonExistentDateException){
            System.out.println("\t NonExistentDateException:\n\t\t ☹ OOPS!!! \n\t\t\t The date doesn't exist");
        }
        else if(e instanceof NonExistentTaskException){
            System.out.println("\t NonExistentTaskException:\n\t\t ☹ OOPS!!! The task doesn't exist");
        }
        else if(e instanceof PostponeHomeworkException){
            System.out.println("\t PostponeHomeworkException:\n\t\t ☹ OOPS!!! The new homework should not be before the old one");
        }
        else if(e instanceof PrioritizeFormatException){
            System.out.println("\t PrioritizeFormatException:\n\t\t ☹ OOPS!!! Please respect the prioritize command format" +
                    "\n\t\t\t prioritize INDEX prio INDEX");
        }
        else if(e instanceof PrioritizeLimitException){
            System.out.println("\t PrioritizeLimitException:\n\t\t ☹ OOPS!!! The priority of a task should be an int greater than or equal to  0 and less than or equal to 9.");
        }
        else if(e instanceof WrongParameterException){
            System.out.println("\t WrongParameterException:\n\t\t ☹ OOPS!!! The parameters are wrong");
        }
        else if (e instanceof EventDateException){
            System.out.println("\t EventDateException:\n\t\t ☹ OOPS!!! The start date should be before the end date for an event task");
        }
        else if(e instanceof EditFormatException){
            System.out.println("\t EditFormatException:\n\t\t ☹ OOPS!!! Please respect the edit command format" +
                     "\n\t\t For multi-step command : 'edit' and then follow the instructions" +
                     "\n\t\t For one shot command:" +
                    "\n\t\t\t edit the description: 'edit INDEX description DESCRIPTION'"+
                    "\n\t\t\t edit the date of an homework task: 'edit INDEX /by DATE'"+
                    "\n\t\t\t edit the period of an event task: 'edit INDEX /at DATE - DATE'");
        }
        else if (e instanceof UserAnswerException){
            System.out.println("\t UserAnswerException:\n\t\t ☹ OOPS!!! Please answer correctly the question.");
        }

        else if (e instanceof InvalidFlagException) {
            System.out.println("\t InvalidFlagException:\n\t\t ☹ Invalid Flag!");
        }
        else if(e instanceof RecurrenceException){
            System.out.println("\t RecurrenceException:\n\t\t ☹ OOPS!!! Please respect the recurrence format" +
                    "\n\t\t\t recu TYPEOFRECURRENCE NBRECURRENCE");
        }
        else if(e instanceof RecurrenceDateException){
            System.out.println("\t RecurrenceException:\n\t\t ☹ OOPS!!! You are trying to make the event recurrent but there will be a conflict date if those events are created" +
                    "\n\t\t\t The event has not been created, please check the date");
        }
        else if(e instanceof NegativeNumberException){
            System.out.println("\t NegativeNumberException:\n\t\t ☹ OOPS!!! There can't be a negative number here.");
        }
    }

    @Override
    public void terminateShortcut() {
        System.out.println("The shortcut edit mode is being terminated earlier. All shortcut edited until now has been saved");
    }

    @Override
    public void showErrorLanguage() {
        System.out.println("The language that you have chosen is currently not available");
    }

    @Override
    public void showErrorRecurrence(String typeOfDate) {
        switch (typeOfDate){
            case "day":
                System.out.println("The maximal number of recurrence for day is 30" +
                "\n\t\t\t The number of recurrence has been change to 30");
                break;
            case "week":
                System.out.println("The maximal number of recurrence for week is 26" +
                        "\n\t\t\t The number of recurrence has been change to 26");
                break;
            case "month":
                System.out.println("The maximal number of recurrence for month is 12" +
                        "\n\t\t\t The number of recurrence has been change to 12");
                break;
        }
    }
}
