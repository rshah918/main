package leduc.command;

import leduc.ui.Ui;
import leduc.exception.DukeException;
import leduc.exception.DuplicationShortcutException;
import leduc.exception.MeaninglessException;
import leduc.storage.Storage;
import leduc.task.TaskList;

import java.util.HashSet;

/**
 * Represent the language command.
 * Allow to set or change the shortcut
 */
public class ShortcutCommand extends Command {

    /**
     * Constructor of ShortcutCommand
     * @param userInput the user input
     */
    public ShortcutCommand(String userInput){
        super(userInput);
    }

    /**
     * HashSet that will contains all the shortcut, use of hashset so there are no duplicate
     */
    private static HashSet<String> setShortcut = new HashSet<>();
    /**
     * HashSet that will contains all the default command name to avoid conflict, use of hashset so there are no duplicate
     */
    private static HashSet<String> setDefaultShortcut = new HashSet<>();

    /**
     * Allow to set or change the shortcut. Three cases :
     * - one line command to change one shortcut command
     * - multi line command to change one shortcut command
     * - multi line command to change all the command
     * @param tasks leduc.task.TaskList which is the list of task.
     * @param ui leduc.ui.Ui which deals with the interactions with the user.
     * @param storage leduc.storage.Storage which deals with loading tasks from the file and saving tasks in the file.
     * @throws DukeException
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        String[] userCommand = this.userInput.split(" ");
        String newShortcut="";
        if (userCommand.length >= 2){
            if(userCommand.length >= 3){
                newShortcut = userCommand[2].trim();
            }
            else {
                ui.showAskShortcut(userCommand[1]);
                newShortcut = ui.readCommand();
            }
            if(setShortcut.contains(newShortcut) || setDefaultShortcut.contains(newShortcut)){
                throw new DuplicationShortcutException();
            }
            else {
                setOneShortcut(userCommand[1], newShortcut);
                ui.showOneShortcutSet(userCommand[1]);
            }
        }
        else {
            do{
                ui.showAskAllShortcut("bye", ByeCommand.getByeShortcut());
                newShortcut = ui.readCommand();
                if(newShortcut.equals("bye")){
                    storage.saveConfig();
                    ui.terminateShortcut();
                    return;
                }
            } while(setShortcut.contains(newShortcut) || setDefaultShortcut.contains(newShortcut));
            setOneShortcut("bye", newShortcut);

            do{
                ui.showAskAllShortcut("list", ListCommand.getListShortcut());
                newShortcut = ui.readCommand();
                if(newShortcut.equals("bye")){
                    storage.saveConfig();
                    ui.terminateShortcut();
                    return;
                }
            } while(setShortcut.contains(newShortcut) || setDefaultShortcut.contains(newShortcut));
            setOneShortcut("list", newShortcut);

            do{
                ui.showAskAllShortcut("help", HelpCommand.getHelpShortcut());
                newShortcut = ui.readCommand();
                if(newShortcut.equals("bye")){
                    storage.saveConfig();
                    ui.terminateShortcut();
                    return;
                }
            } while(setShortcut.contains(newShortcut) || setDefaultShortcut.contains(newShortcut));
            setOneShortcut("help", newShortcut);

            do{
                ui.showAskAllShortcut("done", DoneCommand.getDoneShortcut());
                newShortcut = ui.readCommand();
                if(newShortcut.equals("bye")){
                    storage.saveConfig();
                    ui.terminateShortcut();
                    return;
                }
            } while(setShortcut.contains(newShortcut) || setDefaultShortcut.contains(newShortcut));
            setOneShortcut("done", newShortcut);

            do{
                ui.showAskAllShortcut("find", FindCommand.getFindShortcut());
                newShortcut = ui.readCommand();
                if(newShortcut.equals("bye")){
                    storage.saveConfig();
                    ui.terminateShortcut();
                    return;
                }
            } while(setShortcut.contains(newShortcut) || setDefaultShortcut.contains(newShortcut));
            setOneShortcut("find", newShortcut);

            do{
                ui.showAskAllShortcut("delete", DeleteCommand.getDeleteShortcut());
                newShortcut = ui.readCommand();
                if(newShortcut.equals("bye")){
                    storage.saveConfig();
                    ui.terminateShortcut();
                    return;
                }
            } while(setShortcut.contains(newShortcut) || setDefaultShortcut.contains(newShortcut));
            setOneShortcut("delete", newShortcut);


            do{
                ui.showAskAllShortcut("homework", HomeworkCommand.getHomeworkShortcut());
                newShortcut = ui.readCommand();
                if(newShortcut.equals("bye")){
                    storage.saveConfig();
                    ui.terminateShortcut();
                    return;
                }
            } while(setShortcut.contains(newShortcut) || setDefaultShortcut.contains(newShortcut));
            setOneShortcut("homework", newShortcut);

            do{
                ui.showAskAllShortcut("event", EventCommand.getEventShortcut());
                newShortcut = ui.readCommand();
                if(newShortcut.equals("bye")){
                    storage.saveConfig();
                    ui.terminateShortcut();
                    return;
                }
            } while(setShortcut.contains(newShortcut) || setDefaultShortcut.contains(newShortcut));
            setOneShortcut("event", newShortcut);

            do{
                ui.showAskAllShortcut("todo", TodoCommand.getTodoShortcut());
                newShortcut = ui.readCommand();
                if(newShortcut.equals("bye")){
                    storage.saveConfig();
                    ui.terminateShortcut();
                    return;
                }
            } while(setShortcut.contains(newShortcut) || setDefaultShortcut.contains(newShortcut));
            setOneShortcut("todo", newShortcut);

            do{
                ui.showAskAllShortcut("edit", EditCommand.getEditShortcut());
                newShortcut = ui.readCommand();
                if(newShortcut.equals("bye")){
                    storage.saveConfig();
                    ui.terminateShortcut();
                    return;
                }
            } while(setShortcut.contains(newShortcut) || setDefaultShortcut.contains(newShortcut));
            setOneShortcut("edit", newShortcut);

            do{
                ui.showAskAllShortcut("postpone", PostponeCommand.getPostponeShortcut());
                newShortcut = ui.readCommand();
                if(newShortcut.equals("bye")){
                    storage.saveConfig();
                    ui.terminateShortcut();
                    return;
                }
            } while(setShortcut.contains(newShortcut) || setDefaultShortcut.contains(newShortcut));
            setOneShortcut("postpone", newShortcut);

            do{
                ui.showAskAllShortcut("snooze", SnoozeCommand.getSnoozeShortcut());
                newShortcut = ui.readCommand();
                if(newShortcut.equals("bye")){
                    storage.saveConfig();
                    ui.terminateShortcut();
                    return;
                }
            } while(setShortcut.contains(newShortcut) || setDefaultShortcut.contains(newShortcut));
            setOneShortcut("snooze", newShortcut);

            do{
                ui.showAskAllShortcut("reschedule", RescheduleCommand.getRescheduleShortcut());
                newShortcut = ui.readCommand();
                if(newShortcut.equals("bye")){
                    storage.saveConfig();
                    ui.terminateShortcut();
                    return;
                }
            } while(setShortcut.contains(newShortcut) || setDefaultShortcut.contains(newShortcut));
            setOneShortcut("reschedule", newShortcut);

            do{
                ui.showAskAllShortcut("remind", RemindCommand.getRemindShortcut());
                newShortcut = ui.readCommand();
                if(newShortcut.equals("bye")){
                    storage.saveConfig();
                    ui.terminateShortcut();
                    return;
                }
            } while(setShortcut.contains(newShortcut) || setDefaultShortcut.contains(newShortcut));
            setOneShortcut("remind", newShortcut);

            do{
                ui.showAskAllShortcut("sort", SortCommand.getSortShortcut());
                newShortcut = ui.readCommand();
                if(newShortcut.equals("bye")){
                    storage.saveConfig();
                    ui.terminateShortcut();
                    return;
                }
            } while(setShortcut.contains(newShortcut) || setDefaultShortcut.contains(newShortcut));
            setOneShortcut("sort", newShortcut);

            do{
                ui.showAskAllShortcut("setWelcome", SetWelcomeCommand.getSetWelcomeShortcut());
                newShortcut = ui.readCommand();
                if(newShortcut.equals("bye")){
                    storage.saveConfig();
                    ui.terminateShortcut();
                    return;
                }
            } while(setShortcut.contains(newShortcut) || setDefaultShortcut.contains(newShortcut));
            setOneShortcut("setwelcome", newShortcut);
            do{
                ui.showAskAllShortcut("show", ShowCommand.getShowShortcut());
                newShortcut = ui.readCommand();
                if(newShortcut.equals("bye")){
                    storage.saveConfig();
                    ui.terminateShortcut();
                    return;
                }
            } while(setShortcut.contains(newShortcut) || setDefaultShortcut.contains(newShortcut));
            setOneShortcut("show", newShortcut);

            do{
                ui.showAskAllShortcut("prioritize", PrioritizeCommand.getPrioritizeShortcut());
                newShortcut = ui.readCommand();
                if(newShortcut.equals("bye")){
                    storage.saveConfig();
                    ui.terminateShortcut();
                    return;
                }
            } while(setShortcut.contains(newShortcut) || setDefaultShortcut.contains(newShortcut));
            setOneShortcut("prioritize", newShortcut);

            do{
                ui.showAskAllShortcut("unfinished", UnfinishedCommand.getUnfinishedShortcut());
                newShortcut = ui.readCommand();
                if(newShortcut.equals("bye")){
                    storage.saveConfig();
                    ui.terminateShortcut();
                    return;
                }
            } while(setShortcut.contains(newShortcut) || setDefaultShortcut.contains(newShortcut));
            setOneShortcut("unfinished", newShortcut);

            do{
                ui.showAskAllShortcut("language", LanguageCommand.getLanguageShortcut());
                newShortcut = ui.readCommand();
                if(newShortcut.equals("bye")){
                    storage.saveConfig();
                    ui.terminateShortcut();
                    return;
                }
            } while(setShortcut.contains(newShortcut) || setDefaultShortcut.contains(newShortcut));
            setOneShortcut("language", newShortcut);
            ui.showAllShortcutSet();
        }
        storage.saveConfig();
    }

    /**
     * Helper method to set one command
     * @param commandName the command which the shortcut will be change
     * @param shortcutName the shortcut name
     * @throws MeaninglessException thrown when the command name is unknown
     */
    public static void setOneShortcut(String commandName, String shortcutName) throws MeaninglessException {
        switch (commandName){
            case "bye" :
                setShortcut.remove(ByeCommand.getByeShortcut());
                ByeCommand.setByeShortcut(shortcutName);
                setShortcut.add(shortcutName);
                break;
            case "list" :
                setShortcut.remove(ListCommand.getListShortcut());
                ListCommand.setListShortcut(shortcutName);
                setShortcut.add(shortcutName);
                break;
            case "help" :
                setShortcut.remove(HelpCommand.getHelpShortcut());
                HelpCommand.setHelpShortcut(shortcutName);
                setShortcut.add(shortcutName);
                break;
            case "done" :
                setShortcut.remove(DoneCommand.getDoneShortcut());
                DoneCommand.setDoneShortcut(shortcutName);
                setShortcut.add(shortcutName);
                break;
            case "find" :
                setShortcut.remove(FindCommand.getFindShortcut());
                FindCommand.setFindShortcut(shortcutName);
                setShortcut.add(shortcutName);
                break;
            case "delete" :
                setShortcut.remove(DeleteCommand.getDeleteShortcut());
                DeleteCommand.setDeleteShortcut(shortcutName);
                setShortcut.add(shortcutName);
                break;
            case "homework" :
                setShortcut.remove(HomeworkCommand.getHomeworkShortcut());
                HomeworkCommand.setHomeworkShortcut(shortcutName);
                setShortcut.add(shortcutName);
                break;
            case "event" :
                setShortcut.remove(EventCommand.getEventShortcut());
                EventCommand.setEventShortcut(shortcutName);
                setShortcut.add(shortcutName);
                break;
            case "todo" :
                setShortcut.remove(TodoCommand.getTodoShortcut());
                TodoCommand.setTodoShortcut(shortcutName);
                setShortcut.add(shortcutName);
                break;
            case "edit" :
                setShortcut.remove(EditCommand.getEditShortcut());
                EditCommand.setEditShortcut(shortcutName);
                setShortcut.add(shortcutName);
                break;
            case "postpone" :
                setShortcut.remove(PostponeCommand.getPostponeShortcut());
                PostponeCommand.setPostponeShortcut(shortcutName);
                setShortcut.add(shortcutName);
                break;
            case "snooze" :
                setShortcut.remove(SnoozeCommand.getSnoozeShortcut());
                SnoozeCommand.setSnoozeShortcut(shortcutName);
                setShortcut.add(shortcutName);
                break;
            case "reschedule" :
                setShortcut.remove(RescheduleCommand.getRescheduleShortcut());
                RescheduleCommand.setRescheduleShortcut(shortcutName);
                setShortcut.add(shortcutName);
                break;
            case "remind" :
                setShortcut.remove(RemindCommand.getRemindShortcut());
                RemindCommand.setRemindShortcut(shortcutName);
                setShortcut.add(shortcutName);
                break;
            case "sort" :
                setShortcut.remove(SortCommand.getSortShortcut());
                SortCommand.setSortShortcut(shortcutName);
                setShortcut.add(shortcutName);
                break;
            case "setwelcome" :
                setShortcut.remove(SetWelcomeCommand.getSetWelcomeShortcut());
                SetWelcomeCommand.setSetWelcomeShortcut(shortcutName);
                setShortcut.add(shortcutName);
                break;
            case "show":
                setShortcut.remove(ShowCommand.getShowShortcut());
                ShowCommand.setShowShortcut(shortcutName);
                setShortcut.add(shortcutName);
                break;
            case "prioritize" :
                setShortcut.remove(PrioritizeCommand.getPrioritizeShortcut());
                PrioritizeCommand.setPrioritizeShortcut(shortcutName);
                setShortcut.add(shortcutName);
                break;
            case "unfinished" :
                setShortcut.remove(UnfinishedCommand.getUnfinishedShortcut());
                UnfinishedCommand.setUnfinishedShortcut(shortcutName);
                setShortcut.add(shortcutName);
                break;
            case "language" :
                setShortcut.remove(LanguageCommand.getLanguageShortcut());
                LanguageCommand.setLanguageShortcut(shortcutName);
                setShortcut.add(shortcutName);
                break;
            case "stats" :
                setShortcut.remove(StatsCommand.getStatsShortcut());
                StatsCommand.setStatsShortcut(shortcutName);
                setShortcut.add(shortcutName);
                break;
            default:
                throw new MeaninglessException();
        }
    }

    /**
     * getter to have the HashSet containing all the shortcut
     * @return the hashset containing all the shortcut
     */
    public static HashSet<String> getSetShortcut(){
        return setShortcut;
    }

    /**
     * initialized all the default command name when opening the software
     */
    public static void initializedSetShortcut(){
        setDefaultShortcut.add("bye");
        setDefaultShortcut.add("list");
        setDefaultShortcut.add("done");
        setDefaultShortcut.add("edit");
        setDefaultShortcut.add("homework");
        setDefaultShortcut.add("event");
        setDefaultShortcut.add("find");
        setDefaultShortcut.add("help");
        setDefaultShortcut.add("postpone");
        setDefaultShortcut.add("remind");
        setDefaultShortcut.add("reschedule");
        setDefaultShortcut.add("setwelcome");
        setDefaultShortcut.add("snooze");
        setDefaultShortcut.add("sort");
        setDefaultShortcut.add("todo");
        setDefaultShortcut.add("delete");
        setDefaultShortcut.add("show");
        setDefaultShortcut.add("prioritize");
        setDefaultShortcut.add("unfinished");
        setDefaultShortcut.add("language");
    }
}
